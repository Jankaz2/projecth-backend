package com.projecth.projecthbackend.event;

import com.projecth.projecthbackend.politician.PoliticianEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private OffsetDateTime occurrenceDate;
    @ManyToOne(fetch = FetchType.LAZY)
    private PoliticianEntity politicianEntity;

    public Event toDto() {
        return new Event(this.id, this.name, this.occurrenceDate, this.politicianEntity.toDto());
    }

}
