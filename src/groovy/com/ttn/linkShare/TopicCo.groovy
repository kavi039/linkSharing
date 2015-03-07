package com.ttn.linkShare

import com.ttn.linkShare.enums.Visibility
import grails.validation.Validateable

@Validateable
class TopicCo {
    User user
    String name
    Visibility visibility
    static constraints = {
        name blank: false, unique: true
        visibility blank: false
    }
}
