package com.projecth.projecthbackend.politician.response;

import com.projecth.projecthbackend.politician.PoliticalParty;
import com.projecth.projecthbackend.politician.believes.CorePoliticalBelieves;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PoliticianProfileResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String bio;
    private PoliticalParty politicalParty;
    private String profilePhotoPath;
    private String backgroundPhotoPath;
    private CorePoliticalBelieves corePoliticalBelievesEntity;
    private String eventName;
    private boolean isFollowedByUser;

}
