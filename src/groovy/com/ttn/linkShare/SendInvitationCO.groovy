package com.ttn.linkShare

import grails.validation.Validateable

@Validateable
class SendInvitationCO {
    String email
    Long topicId
    String url
    static constraints={
        email email: true
    }

}
