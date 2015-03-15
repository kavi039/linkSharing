package com.ttn.linkShare

import grails.transaction.Transactional

@Transactional
class LoginService {

    Boolean isUserExist(UserCO userCO) {
        User user=User.findByUsernameOrEmail(userCO.email,userCO.email)

        if (user?.active&&user.password.equals(userCO.password)) {
            userCO.username=user.username
            return true
        } else {
            return  false

        }
    }
}
