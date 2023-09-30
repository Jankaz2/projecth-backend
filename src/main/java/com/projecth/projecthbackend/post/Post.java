package com.projecth.projecthbackend.post;

public record Post(Long id, Long tagId, String content, Attitude attitude) {
    public PostEntity toPostEntity() {
        return new PostEntity(this.id, this.tagId, this.content, this.attitude);
    }
}
