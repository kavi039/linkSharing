package com.ttn.linkshare

import com.ttn.linkShare.User
import com.ttn.linkShare.UserCO

class UserController {
    def  userService


    def dashBoard() {

    }

    def listOfUser() {


    }

    def registerHandler(UserCO userCO) {
        if (userService.register(userCO)) {
            session['username'] = userCO.username
            redirect(controller: 'user', action: 'dashBoard')
        } else {
            flash.error = "Kindly enter valid data"
            redirect(controller: "login", action: "login")
        }
    }

    def show() {
        String key = params.user
      render template: 'userInfo',model:[userList: userService.listingUser(key)]

    }


}
