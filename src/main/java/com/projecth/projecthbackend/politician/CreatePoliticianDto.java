package com.projecth.projecthbackend.politician;

public record CreatePoliticianDto(String name, String surname, PoliticalParty politicalParty) {
    public PoliticianEntity toPoliticianEntity() {
        return new PoliticianEntity(null, this.name, this.surname, null, this.politicalParty, null, null, null);
    }
}
