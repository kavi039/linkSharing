package com.ttn.linkShare

import grails.validation.Validateable

@Validateable
class LinkCO {
    Long topicId
    String description
    User user
    String url
    Long id

    static constraints = {
        url url: true, blank: false
        id nullable: true
    }

}
