package com.projecth.projecthbackend.politician;

import com.projecth.projecthbackend.event.EventEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class PoliticianEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private String bio;
    private String politicalParty;
    private String profilePhotoPath;

    @OneToMany
    private List<EventEntity> eventEntities;

    public Politician toDto() {
        return new Politician(this.id, this.name, this.surname, this.bio, this.politicalParty, this.eventEntities.stream().map(EventEntity::toDto).toList());
    }
}
