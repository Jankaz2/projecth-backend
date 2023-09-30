package com.projecth.projecthbackend.post;

import com.projecth.projecthbackend.politician.Politician;

public record Post(
        Long id,
        Politician politician,
        Long tagId,
        PostType postType,
        String content,
        Attitude attitude,
        String videoPath,
        int positive,
        int negative,
        int neutral
) {
    public PostEntity toPostEntity() {
        return new PostEntity(
                this.id,
                this.politician().toPoliticianEntity(),
                this.tagId,
                this.postType,
                this.content,
                this.attitude,
                this.videoPath,
                this.positive,
                this.negative,
                this.neutral
        );
    }
}
