package com.projecth.projecthbackend.security;
import com.projecth.projecthbackend.account.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var authenticatedUser = userService.getByEmail(email);

        return new User(
                authenticatedUser.email(),
                authenticatedUser.password(),
                true,
                true,
                true,
                true,
                List.of()
        );
    }
}
