package com.ttn.linkshare

import com.ttn.linkShare.User
import com.ttn.linkShare.UserCO
import org.springframework.web.multipart.MultipartFile

class LoginController {

    def login() {
        println "in **********LoginHandler"
    }

    def loginHandler() {
        println "in **********LoginHandler"
        if (session.getAttribute("username")) {
            redirect(controller: 'user', action: 'dashBoard')
            return
        }

       User user=User.findByUsernameOrEmail(params.email,params.email)

        if (user?.active&&user.password.equals(params.password)) {
            session["username"] = user.username
            redirect(controller: 'user', action: 'dashBoard')
            return
        } else {
            flash.error = "User not Found."
            redirect(controller: "login", action: "login")

        }
    }

    def logout() {
        session.invalidate()
        redirect(controller: 'login', action: 'login')

    }

    def loginForShow() {

    }
   def loginShowHandler(){
       User user=User.findByUsernameOrEmail(params.email,params.email)
       if (user?.active&&user.password.equals(params.password)) {
           session["username"] = user.username
           println(">>>>>>>>>>>>>>>>>>>>>>>>${servletContext.getAttribute('name')}")
           redirect(controller: 'topic', action: 'topicShow',params: [topicName:servletContext.getAttribute("name") ])

       } else {
           flash.error = "User not Found."
           redirect(controller: "login", action: "loginForShow")

       }
   }

    def changePassword() {

    }


}
