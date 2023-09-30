package com.projecth.projecthbackend.politician;

public enum PoliticalParty {
    KONFEDERACJA("Konfederacja"),
    KOALICJA_OBYWATELSKA("Koalicja Obywatelska"),
    PIS("PIS");

    private String value;

    PoliticalParty(String value) {
        this.value = value;
    }
}
