package com.ttn.linkShare.enums


public enum Visibility {

    PUBLIC("Public"),
    PRIVATE("Private")

    String displayName;

    Visibility(String displayName) {
        this.displayName = displayName;
    }

}
