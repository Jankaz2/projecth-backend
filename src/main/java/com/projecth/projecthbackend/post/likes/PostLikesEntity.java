package com.projecth.projecthbackend.post.likes;

import com.projecth.projecthbackend.post.Attitude;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class PostLikesEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Long postId;
    private Long userId;

    @Enumerated(EnumType.STRING)
    private Attitude attitude;
    private LocalDateTime likedAt;

    public PostLikes toDto() {
        return new PostLikes(this.id, this.postId, this.userId, this.attitude, this.likedAt);
    }

}
