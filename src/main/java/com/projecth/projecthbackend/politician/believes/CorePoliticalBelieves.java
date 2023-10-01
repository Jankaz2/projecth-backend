package com.projecth.projecthbackend.politician.believes;

import com.projecth.projecthbackend.politician.Politician;

public record CorePoliticalBelieves(Long id, int economicMarker, int diplomaticMarker, int civilMarker, int societalMarker/*, Politician politician*/) {

    public CorePoliticalBelievesEntity toCorePoliticalBelievesEntity() {
        return new CorePoliticalBelievesEntity(this.id, this.economicMarker, this.diplomaticMarker, this.civilMarker, this.societalMarker/*, politician.toPoliticianEntity()*/);
    }
}