package com.projecth.projecthbackend.post;

public record Tag(Long id, Post post, String name) {
    public TagEntity toEntity() {
        return new TagEntity(this.id, this.post.toPostEntity(), this.name);
    }
}
