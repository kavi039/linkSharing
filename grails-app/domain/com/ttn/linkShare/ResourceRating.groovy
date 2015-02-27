package com.ttn.linkShare

class ResourceRating {

    Integer score;
    static constraints = {

        score blank: false
    }
    static belongsTo = [resource: Resource, user: User]
}
