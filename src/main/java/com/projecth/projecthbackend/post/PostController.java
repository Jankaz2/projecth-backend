package com.projecth.projecthbackend.post;

import com.projecth.projecthbackend.account.Account;
import com.projecth.projecthbackend.post.response.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/{politicianId}/{userId}")
    public List<PostResponse> getAllPosts(@PathVariable("politicianId") Long politicianId, @PathVariable("userId") Long userId) {
        List<PostResponse> allPosts = postService.getAllPosts(politicianId, userId);
        return allPosts;
    }

    @PostMapping("/{postId}/{userId}/{attitude}")
    public PostResponse rateThePost(
            @PathVariable Long postId,
            @PathVariable Long userId,
            @PathVariable Attitude attitude
    ) {
        return postService.rateThePost(postId, userId, attitude);
    }

}
