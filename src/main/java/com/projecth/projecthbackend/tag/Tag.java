package com.projecth.projecthbackend.tag;

import com.projecth.projecthbackend.post.Post;

public record Tag(Long id, Post post, String name) {
    public TagEntity toEntity() {
        return new TagEntity(this.id, this.post.toPostEntity(), this.name);
    }
}
