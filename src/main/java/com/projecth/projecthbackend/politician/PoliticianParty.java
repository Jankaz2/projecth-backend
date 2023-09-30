package com.projecth.projecthbackend.politician;

public enum PoliticianParty {
    KONFEDERACJA("Konfederacja"),
    KOALICJA_OBYWATELSKA("Koalicja Obywatelska"),
    PIS("PIS");

    private String value;

    PoliticianParty(String value) {
        this.value = value;
    }
}
