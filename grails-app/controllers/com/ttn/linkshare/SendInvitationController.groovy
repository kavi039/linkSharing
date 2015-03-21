package com.ttn.linkshare

import com.ttn.linkShare.Topic

class SendInvitationController {

    def sendInvitationService
    def sendEmail() {
        println("params: $params")
        Long id=params.int('topicId')
        String url = g.createLink([controller: 'topic', action: 'topicShow', params: [topicName:id ], absolute: true])
        String address = params.get("email")
        String sub = "${Topic.get(id).name} invitation"
      sendInvitationService.sendInvitation(address, sub, url)
       render true
            flash.message = "message send"
       redirect(controller: 'user', action: 'dashBoard')
    }
}