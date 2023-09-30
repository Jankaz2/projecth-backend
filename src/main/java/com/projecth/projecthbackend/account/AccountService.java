package com.projecth.projecthbackend.account;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository userRepository;

    @Transactional
    public Account getByEmail(String email) {
        var foundUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Not found user with this email: " + email));

        return foundUser.toDto();
    }

    @Transactional
    public Account signUp(Account account) {
        var userEntity = account.toUserEntity();
        userEntity.setPassword(account.password());
        return userRepository.save(userEntity).toDto();
    }

    @Transactional
    public List<Account> getUsers() {
        return userRepository.findAll().stream().map(AccountEntity::toDto).toList();
    }
}
