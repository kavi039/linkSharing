package com.ttn.linkshare

import com.ttn.linkShare.SendInvitationCO
import com.ttn.linkShare.Topic

class SendInvitationController {

    def sendInvitationService

    def sendEmail(SendInvitationCO sendInvitationCO) {
        sendInvitationCO.url = g.createLink([controller: 'topic', action: 'topicShow', params: [topicName: sendInvitationCO.topicId], absolute: true])
        if (sendInvitationCO.validate()) {
            String sub = "${Topic.get(sendInvitationCO.topicId).name} invitation"
            sendInvitationService.sendInvitation(sendInvitationCO, sub)
            render true
        } else {
            render false
        }
    }

    def index() {

    }

}