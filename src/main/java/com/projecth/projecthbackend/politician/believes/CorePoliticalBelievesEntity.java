package com.projecth.projecthbackend.politician.believes;

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
public class CorePoliticalBelievesEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Integer economicMarker;
    private Integer diplomaticMarker;
    private Integer civilMarker;
    private Integer societalMarker;

    public CorePoliticalBelieves toCorePoliticalBelievesDto() {
        return new CorePoliticalBelieves(this.id, this.economicMarker, this.diplomaticMarker, this.civilMarker, this.societalMarker);
    }
}
