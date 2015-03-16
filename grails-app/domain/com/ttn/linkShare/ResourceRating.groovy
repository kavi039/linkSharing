package com.ttn.linkShare

class ResourceRating {

    Integer score;

    User user

    static constraints = {
    }
    static belongsTo = [resourse: Resource]
}
