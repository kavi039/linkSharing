package com.ttn.linkShare

abstract class Resource {

    String description
    Date dateCreated
    User user
    Boolean isRead
    Integer score

    static mapping = {
        description sqlType: 'text'
        tablePerHierarchy false
    }

    static constraints = {
        description nullable: true
         score nullable: true
        isRead nullable: true

    }


    static belongsTo = [topic:  Topic]

}
