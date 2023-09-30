package com.projecth.projecthbackend.account;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User getByEmail(String email) {
        var foundUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Not found user with this email: " + email));

        return foundUser.toDto();
    }

    @Transactional
    public User signUp(User user) {
        var userEntity = user.toUserEntity();
        userEntity.setPassword(user.password());
        return userRepository.save(userEntity).toDto();
    }

    @Transactional
    public List<User> getUsers() {
        return userRepository.findAll().stream().map(UserEntity::toDto).toList();
    }
}
