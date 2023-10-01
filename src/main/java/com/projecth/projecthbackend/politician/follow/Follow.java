package com.projecth.projecthbackend.politician.follow;

public record Follow(Long id, Long userId, Long politicianId) {

    public FollowEntity toEntity() {
        return new FollowEntity(this.id, this.userId, this.politicianId);
    }
}
