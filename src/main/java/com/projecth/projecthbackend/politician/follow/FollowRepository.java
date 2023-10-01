package com.projecth.projecthbackend.politician.follow;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowRepository extends JpaRepository<FollowEntity, Long> {

    List<FollowEntity> findByUserId(Long userId);

}
