package com.projecth.projecthbackend.politician;

import com.projecth.projecthbackend.event.Event;

import java.util.List;

public record Politician(Long id, String name, String surname, String bio, String politicianParty, List<Event> events) {
    public PoliticianEntity toPoliticianEntity() {
        return new PoliticianEntity(this.id, this.name, this.surname, this.bio, this.politicianParty, this.events.stream().map(Event::toEventEntity).toList());
    }
}
