package com.projecth.projecthbackend.politician;

import com.projecth.projecthbackend.politician.believes.CorePoliticalBelieves;

public record Politician(
        Long id,
        String name,
        String surname,
        String bio,
        PoliticalParty politicalParty,
        String profilePhotoPath,
        CorePoliticalBelieves corePoliticalBelieves
) {
    public PoliticianEntity toPoliticianEntity() {
        return new PoliticianEntity(
                this.id,
                this.name,
                this.surname,
                this.bio,
                this.politicalParty,
                this.profilePhotoPath,
                this.corePoliticalBelieves.toCorePoliticalBelievesEntity()
        );
    }
}
