package com.ttn.linkshare

import com.ttn.linkShare.User
import com.ttn.linkShare.UserCO
import org.springframework.web.multipart.MultipartFile

class LoginController {
    def loginService

    def login() {

    }

    def loginHandler(UserCO userCO) {
        if (session.getAttribute("username")) {
            redirect(controller: 'user', action: 'dashBoard')
            return
        }
        Boolean isUserExist = loginService.isUserExist(userCO)
        if (isUserExist) {
            session["username"] = userCO.username
            redirect(controller: 'user', action: 'dashBoard')
        } else {
            flash.error = "User not Found."
            redirect(controller: "login", action: "login")
        }
    }

    def logout() {
        session.invalidate()
        redirect(controller: 'login', action: 'login')

    }


    def changePassword() {

    }


}
