package com.projecth.projecthbackend.account;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class UserEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String email;
    private String password;

    public User toDto() {
        return new User(this.id, this.email, this.password);
    }
}
