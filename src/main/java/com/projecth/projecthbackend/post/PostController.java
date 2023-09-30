package com.projecth.projecthbackend.post;

import com.projecth.projecthbackend.post.response.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
