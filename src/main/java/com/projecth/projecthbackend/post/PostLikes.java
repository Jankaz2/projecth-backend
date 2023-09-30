package com.projecth.projecthbackend.post;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class PostLikes {

    @Id
    @GeneratedValue
    private Long id;

    private Long postId;
    private Long userId;

    @Enumerated(EnumType.STRING)
    private Attitude attitude;
    private LocalDateTime likedAt;

}
