package com.projecth.projecthbackend.security;

import com.projecth.projecthbackend.account.AccountService;
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

    private final AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var authenticatedUser = accountService.getByEmail(email);

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
