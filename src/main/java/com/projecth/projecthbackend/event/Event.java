package com.projecth.projecthbackend.event;

import com.projecth.projecthbackend.politician.Politician;

import java.time.OffsetDateTime;

public record Event(Long id, String name, OffsetDateTime occurrenceDate, Politician politician) {

    public EventEntity toEventEntity() {
        return new EventEntity(this.id, this.name, this.occurrenceDate, this.politician.toPoliticianEntity());
    }
}
