package com.projecth.projecthbackend.post.likes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostLikesRepository extends JpaRepository<PostLikesEntity, Long> {
    Optional<PostLikesEntity> findByPostIdAndUserId(Long postId, Long userId);
}
