package ua.maxbondar.tour_agency.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role  implements GrantedAuthority {
    ROLE_SUPERADMIN,
    ROLE_MANAGER,
    ROLE_USER,
    ;

    @Override
    public String getAuthority() {
        return name();
    }
}
