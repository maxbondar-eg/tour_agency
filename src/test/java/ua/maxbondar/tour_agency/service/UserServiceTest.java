package ua.maxbondar.tour_agency.service;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import ua.maxbondar.tour_agency.entity.Role;
import ua.maxbondar.tour_agency.entity.User;
import ua.maxbondar.tour_agency.repositories.UserRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @Test
    public void addUser() {
        User user = User.builder().firstName("Vasya").lastName("Pupkin").username("v_pupkin2007").password("123").build();
        Mockito.doReturn("encoded123").when(passwordEncoder).encode("123");
        Mockito.doReturn(user).when(userRepository).save(user);

        boolean isUserCreated = userService.addUser(user);

        Assert.assertTrue(isUserCreated);
        Assert.assertNotNull(user.getPassword());
        Assert.assertTrue(CoreMatchers.is(user.getRoles()).matches(Collections.singleton(Role.ROLE_USER)));

        Mockito.verify(userRepository, Mockito.times(1)).save(user);
        Mockito.verify(passwordEncoder, Mockito.times(1)).encode("123");
    }

    @Test
    public void loadByUsernameTest(){
        User user = User.builder().firstName("Vasya").lastName("Pupkin").username("v_pupkin2007").password("123").build();
        Mockito.doReturn(user).when(userRepository).findByUsername("v_pupkin2007");
        User result = (User) userService.loadUserByUsername("v_pupkin2007");

        Assert.assertNotNull(result);
        Mockito.verify(userRepository, Mockito.times(1)).findByUsername("v_pupkin2007");
    }

    @Test
    public void addUserNullTest(){
        User user = new User();
        assertFalse(userService.addUser(user));
    }

    @Test
    public void findAllTest(){
        User testUser = User.builder().firstName("Vasya").lastName("Pupkin").username("v_pupkin2007").password("123").build();
        User anotherTestUser = User.builder().firstName("Barak").lastName("Obama").username("nu_typa").password("123").build();
        List<User> users = Arrays.asList(testUser, anotherTestUser);

        Mockito.doReturn(users).when(userRepository).findAll();

        List<User> usersAfter = userService.findAll();
        Assert.assertNotNull(usersAfter);
        Assert.assertTrue(usersAfter.size()==2);

        Mockito.verify(userRepository, Mockito.times(1)).findAll();
    }

}