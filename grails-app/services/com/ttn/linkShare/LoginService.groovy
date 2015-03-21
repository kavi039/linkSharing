package com.ttn.linkShare

import grails.transaction.Transactional

@Transactional
class LoginService {
    def mailService

    Boolean isUserExist(UserCO userCO) {
        User user = User.findByUsernameOrEmail(userCO.email, userCO.email)

        if (user?.active && user.password.equals(userCO.password)) {
            userCO.username = user.username
            return true
        } else {
            return false

        }
    }

    User forgetPasswordAction(String email) {
        User user = User.findByEmailOrUsername(email, email)
        if (user) {
            String password=user.password
            user.properties = [password: "${password.hashCode()}"]
            user.save(flush: true) ? sendMail(user) :null
        }
        else null

    }

    def sendMail(User user) {

        mailService.sendMail {
            to user.email
            subject "password Reset"
            html "<h1>${user.password}</h1>"

        }
        return user
    }
}
