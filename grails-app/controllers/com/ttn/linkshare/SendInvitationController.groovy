package com.ttn.linkshare

class SendInvitationController {

    def sendInvitationService
    def sendEmail() {
        String url=g.createLink([controller: 'topic',action:'show',params:[name:params.get('topic')],absolute:true])
        String  address=params.get("email")
        String sub= "${params.get("topic")} invitation"

      if(sendInvitationService.sendInvitation(address,sub,url))
      {
          flash.message="message send"
      }
      else{
          flash.message="message has not send"
      }
        redirect(controller:'user',action: 'dashBoard')
    }
}