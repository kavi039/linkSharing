package com.ttn.linkshare

import com.ttn.linkShare.User
import com.ttn.linkShare.UserCO
import org.springframework.web.multipart.MultipartFile

class LoginController {

    def login() {
        println "in **********LoginHandler"
    }

    def loginHandler(UserCO userCO) {
        println "in **********LoginHandler"
        if (session.getAttribute("username")) {
            redirect(controller: 'user', action: 'dashBoard')
            return
        }
        User user = User.findByEmailAndPassword(userCO.email, userCO.password)
        if (user?.active) {
            session["username"] = user.username
            redirect(controller: 'user', action: 'dashBoard')
            return
        } else {
            flash.error = "User not Found."
            redirect(controller: "login", action: "login")
            return
        }
    }

    def logout() {
        session.invalidate()
        redirect(controller: 'login', action: 'login')

    }
    def changePassword(){

    }



}
