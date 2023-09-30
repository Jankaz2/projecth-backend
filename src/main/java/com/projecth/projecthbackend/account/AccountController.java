package com.projecth.projecthbackend.account;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/sign-up")
    public Account signUp(@RequestBody Account account) {
        return accountService.signUp(account);
    }

    @GetMapping
    public List<Account> getUsers() {
        return accountService.getUsers();
    }

}
