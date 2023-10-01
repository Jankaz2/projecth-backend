package com.projecth.projecthbackend.politician.follow;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/followed")
@RequiredArgsConstructor
public class FollowController {

    private final FollowService followService;

    @GetMapping("/{userId}")
    public List<FollowedResponse> getFollowedPoliticsByUser(@PathVariable Long userId) {
        return followService.getFollowedPoliticsByUser(userId);
    }

    @PostMapping("/{politicianId}/follow/{userId}")
    public void followByUser(@PathVariable Long politicianId, @PathVariable Long userId) {
        followService.followByUser(politicianId, userId);
    }
}
