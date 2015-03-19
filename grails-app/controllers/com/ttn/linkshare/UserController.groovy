package com.ttn.linkshare

import com.ttn.linkShare.Topic
import com.ttn.linkShare.User
import com.ttn.linkShare.UserCO
import com.ttn.linkShare.UserPasswordCO
import com.ttn.linkShare.UserUpdateCO

class UserController {
    def userService
    def tagService


    def dashBoard() {

    }

    def listOfUser() {


    }

    def editProfilePage() {

    }
    def user(){

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

//    def show() {
//        String key = params.user
//        render template: 'userInfo', model: [userList: userService.listingUser(key)]
//
//    }

    def updateUserByActivation(Long userId) {
        User user = User.get(userId)
        Boolean result = userService.updateByActivation(userId)
        if (result) {
            render "true"
        } else {
            render "false"
        }


    }

    def updateUserProfile(UserUpdateCO userUpdateCO) {
        Boolean userStatus = userService.updateProfile(userUpdateCO, "${session['username']}")
        if (userStatus) {
            session['username'] = userUpdateCO.username
           redirect(controller: 'user', action: 'editProfilePage')
        } else {
                flash.error="Updation is not done"
            redirect(controller: 'user', action: 'editProfilePage')
        }
    }

    def updateUserPassword(UserPasswordCO userPasswordCO) {
        Boolean userStatus = userService.updatePassword(userPasswordCO, "${session['username']}")
        if (userStatus) {
            flash.message="New password is send to u in email"
            redirect(controller: 'user', action: 'editProfilePage')
        } else {
            flash.error = "Password is invalid"
            redirect(controller: 'user', action: 'editProfilePage')
        }
    }

def test(){
   User user= User.findByUsername("${session['username']}")
  render  ( tagService.userPublicProfileInfo(user))
}


}
