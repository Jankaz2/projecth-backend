package com.projecth.projecthbackend.user;

public record User(Long id, String email, String password) {
    public UserEntity toUserEntity() {
        return new UserEntity(this.id, this.email, this.password);
    }
}
