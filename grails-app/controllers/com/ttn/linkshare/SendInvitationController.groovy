package com.ttn.linkshare

class SendInvitationController {

    def sendInvitationService
    def sendEmail() {
        println("params: $params")
        String url = g.createLink([controller: 'topic', action: 'topicShow', params: [topicName: params.get('topicId')], absolute: true])
        String address = params.get("email")
        String sub = "${params.get("topic")} invitation"
      sendInvitationService.sendInvitation(address, sub, url)
       render true
            flash.message = "message send"
       redirect(controller: 'user', action: 'dashBoard')
    }
}