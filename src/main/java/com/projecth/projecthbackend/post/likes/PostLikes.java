package com.projecth.projecthbackend.post.likes;

import com.projecth.projecthbackend.post.Attitude;

import java.time.LocalDateTime;

public record PostLikes(Long id, Long postId, Long userId, Attitude attitude, LocalDateTime likedAt) {

    public PostLikesEntity toPostLikesEntity() {
        return new PostLikesEntity(this.id, this.postId, this.userId, this.attitude, this.likedAt);
    }
}
