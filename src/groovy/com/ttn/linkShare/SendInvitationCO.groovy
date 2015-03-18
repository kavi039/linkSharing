package com.ttn.linkShare

import grails.validation.Validateable

@Validateable
class SendInvitationCO {
    String email
    String topic
    String subject
    String url
    static constraints={
        email email: true
    }

}
