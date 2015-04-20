package com.ttn.linkShare

abstract class Resource {

    String description
    Date dateCreated
    User user
    static mapping = {
        description sqlType: 'text'
        tablePerHierarchy false
    }

    static constraints = {
        description nullable: true

    }
    static hasMany = [readingItems: ReadingItem, resourceRatings: ResourceRating]

    static belongsTo = [topic: Topic]


}
