package com.projecth.projecthbackend.politician;

public record CreatePoliticianDto(String name, String surname, PoliticianParty politicianParty) {
    public PoliticianEntity toPoliticianEntity() {
        return new PoliticianEntity(null, this.name, this.surname, null, this.politicianParty, null);
    }
}
