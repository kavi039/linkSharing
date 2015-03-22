package com.ttn.linkShare

import com.ttn.linkShare.enums.Visibility
import grails.validation.Validateable

@Validateable
class TopicCo {
    Topic topic
    User user
    String name
    Visibility visibility
    static constraints = {
        name blank: false
        visibility blank: false
        topic nullable: true
    }
}
