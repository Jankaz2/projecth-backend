package com.projecth.projecthbackend.politician;

public record Politician(Long id, String name, String surname, String bio, String politicianParty) {
    public PoliticianEntity toPoliticianEntity() {
        return new PoliticianEntity(this.id, this.name, this.surname, this.bio, this.politicianParty);
    }
}
