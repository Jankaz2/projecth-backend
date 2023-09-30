package com.projecth.projecthbackend.post;

import com.projecth.projecthbackend.politician.Politician;
import com.projecth.projecthbackend.post.likes.PostLikes;

public record Post(
        Long id,
        Politician politician,
        PostType postType,
        String content,
        String videoPath,
        int positiveVotes,
        int negativeVotes,
        int neutralVotes
) {
    public PostEntity toPostEntity() {
        return new PostEntity(
                this.id,
                this.politician().toPoliticianEntity(),
                this.postType,
                this.content,
                this.videoPath,
                this.positiveVotes,
                this.negativeVotes,
                this.neutralVotes
        );
    }
}
