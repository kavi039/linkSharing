package com.ttn.linkShare


class SendInvitationService {
    def mailService

    def sendInvitation(SendInvitationCO sendInvitationCO, String sub) {
        mailService.sendMail {
            to(sendInvitationCO.email)
            subject sub
            html "${sendInvitationCO.url}"

        }
    }
}
