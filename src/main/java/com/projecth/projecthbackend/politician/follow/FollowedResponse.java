package com.projecth.projecthbackend.politician.follow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FollowedResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String profilePhotoPath;
}
