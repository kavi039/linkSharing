package com.ttn.linkShare



class SendInvitationService {
    def mailService
    def sendInvitation(String email,String sub,String url){
        mailService.sendMail {
            to email
            subject sub
            html "${url}"

        }
    }
}
