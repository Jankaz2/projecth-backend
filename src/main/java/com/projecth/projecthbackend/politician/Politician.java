package com.projecth.projecthbackend.politician;

import java.util.List;

import com.projecth.projecthbackend.event.Event;


public record Politician(
        Long id,
        String name,
        String surname,
        String bio,
        PoliticalParty politicalParty,
        String profilePhotoPath
) {
    public PoliticianEntity toPoliticianEntity() {
        return new PoliticianEntity(
                this.id,
                this.name,
                this.surname,
                this.bio,
                this.politicalParty,
                this.profilePhotoPath
        );
    }
}
