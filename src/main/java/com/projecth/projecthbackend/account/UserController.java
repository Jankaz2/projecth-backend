package com.projecth.projecthbackend.account;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/sign-up")
    public User signUp(@RequestBody User user) {
        return userService.signUp(user);
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

}
