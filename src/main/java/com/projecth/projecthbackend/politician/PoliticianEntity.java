package com.projecth.projecthbackend.politician;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class PoliticianEntity {

    @Id @GeneratedValue private Long id;
    private String name;
    private String surname;
    private String bio;
    private String politicalParty;

    public Politician toDto() {
        return new Politician(this.id, this.name, this.surname, this.bio, this.politicalParty);
    }
}
