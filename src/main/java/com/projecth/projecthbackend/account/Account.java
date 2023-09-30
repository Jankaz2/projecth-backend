package com.projecth.projecthbackend.account;

public record Account(Long id, String email, String password) {
    public AccountEntity toUserEntity() {
        return new AccountEntity(this.id, this.email, this.password);
    }
}
