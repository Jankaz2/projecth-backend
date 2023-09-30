package com.projecth.projecthbackend.post.response;

import com.projecth.projecthbackend.post.likes.PostLikes;
import com.projecth.projecthbackend.post.PostType;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PostResponse {

    private Long postId;
    private PostLikes postLikesEntity;
    private PostType postType;
    private String content;
    private String positiveVotes;
    private String negativeVotes;
    private String neutralVotes;
    private String tagName;
    private String videoPath;

}
