package com.projecth.projecthbackend.post;

import com.projecth.projecthbackend.politician.Politician;

public record Post(
        Long id,
        Politician politician,
        Long tagId,
        PostType postType,
        String content,
        String videoPath,
        int positive,
        int negative,
        int neutral
) {
    public PostEntity toPostEntity() {
        return new PostEntity(
                this.id,
                this.politician().toPoliticianEntity(),
                this.postType,
                this.content,
                this.videoPath,
                this.positive,
                this.negative,
                this.neutral
        );
    }
}
