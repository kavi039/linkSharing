package com.ttn.linkShare


class SendInvitationService {
    def mailService

    def sendInvitation(String email, String sub, String url) {
        println"*"
        println"*"
        println"*"
        println"*"
        println"*"
        println"*"
        println"*"
        println"*"
        println"*"
        println "Sending email to: $email , subject: $sub , html: $url"
        mailService.sendMail {
            to email
            subject sub
            html "${url}"

        }
    }
}
