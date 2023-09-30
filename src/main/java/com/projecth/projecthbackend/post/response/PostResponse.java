package com.projecth.projecthbackend.post.response;

import com.projecth.projecthbackend.post.Attitude;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PostResponse {

    private Long postId;
    private Attitude attitude;
    private String content;
    private String positiveVotes;
    private String negativeVotes;
    private String neutralVotes;
    private String tagName;
    private String videoPath;

}
