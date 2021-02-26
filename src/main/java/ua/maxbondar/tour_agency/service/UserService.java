package ua.maxbondar.tour_agency.service;


import lombok.extern.slf4j.Slf4j;
import ua.maxbondar.tour_agency.entity.Role;
import ua.maxbondar.tour_agency.entity.User;
import ua.maxbondar.tour_agency.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Slf4j
@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user==null){
            log.error("Not found user with username={} !", user.getUsername());
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return user;
    }


    public boolean addUser(User user){
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.ROLE_USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User result =  userRepository.save(user);
        try{
            result.getUsername();
        } catch (NullPointerException e){
            log.error(" Error, User not added! {}", user.getUsername());
            return false;
        }
        return true;
    }

    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    public void saveUser(User user, String username, Map<String, String> form) {
        user.setUsername(username);
        Set<String> roles =  Arrays.stream(Role.values()).map(Role::name).collect(Collectors.toSet());
        user.getRoles().clear();
        for (String key : form.keySet()) {
            if(roles.contains(key)){
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userRepository.save(user);
        log.info("User with username {} was edited", user.getUsername());

    }
}
