package com.projecth.projecthbackend.common;

public enum S3Path {
    VIDEO("/videos"),
    PROFILE("/profiles"),
    BACKGROUND("/background");

    private String path;

    S3Path(String path) {
        this.path = path;
    }
}
