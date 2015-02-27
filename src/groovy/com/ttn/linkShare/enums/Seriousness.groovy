package com.ttn.linkShare.enums

enum Seriousness {

    SERIOUS("Serious"),
    VERYSERIOUS("Very Serious"),
    CASUAL("Casual")

    String displayName

    Seriousness(String displayName) {
        this.displayName = displayName
    }

}