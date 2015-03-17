package com.ttn.linkShare

import grails.validation.Validateable

@Validateable
class LinkCO {
    String name
    String description
    User user
    String url
    Topic topic

    static constraints={
        url url: true,blank: false
    }

}
