package com.ttn.linkshare

class SendInvitationController {

    def sendInvitationService
    def sendEmail() {
        String url=g.createLink([controller: 'topic',action:'show',params:[name:params.get('topic')]])
        String  address=params.get("email")
        String sub= "${params.get("topic")} invitation"

        sendInvitationService.sendInvitation(address,sub,url)


    }
}