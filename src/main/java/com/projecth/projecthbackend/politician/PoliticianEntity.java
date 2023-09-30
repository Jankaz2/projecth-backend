package com.projecth.projecthbackend.politician;

import jakarta.persistence.*;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String bio;
    @Enumerated(EnumType.STRING)
    private PoliticalParty politicalParty;
    private String profilePhotoPath;

    public Politician toDto() {
        return new Politician(this.id, this.name, this.surname, this.bio, this.politicalParty, this.profilePhotoPath);
    }
}
