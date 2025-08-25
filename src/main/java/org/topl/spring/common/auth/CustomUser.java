package org.topl.spring.common.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUser extends User {
    private Long userId;
    private String userName;
    private String password;
    private Collection<GrantedAuthority> authorities;

    public CustomUser(Long userId, String userName, String password, Collection<? extends GrantedAuthority> authorities) {
        super(userName, password, authorities);
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }
}
