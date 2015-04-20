package com.ttn.linkshare

import com.ttn.linkShare.Resource
import com.ttn.linkShare.Topic
import com.ttn.linkShare.User
import com.ttn.linkShare.UserCO
import com.ttn.linkShare.UserPasswordCO
import com.ttn.linkShare.UserUpdateCO
import sun.security.provider.MD5

class UserController {
    def userService
    def tagService

    def index() {

    }

    def dashBoard() {

    }

    def listOfUser() {


    }

    def editProfilePage() {

    }

    def user() {

    }

    def registerHandler(UserCO userCO) {
        if (userService.register(userCO)) {
            session['username'] = userCO.username
            redirect(controller: 'user', action: 'dashBoard')
        } else {
            //flash.error = "Kindly enter valid data"

            redirect(controller: "login", action: "login",params: errors)
        }


    }


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
            flash.error = "Updation is not done"
            redirect(controller: 'user', action: 'editProfilePage')
        }
    }

    def updateUserPassword(UserPasswordCO userPasswordCO) {
        Boolean userStatus = userService.updatePassword(userPasswordCO, "${session['username']}")
        if (userStatus) {
            flash.message = "Password updated"
        } else {
            flash.error = "Password is invalid"
        }
        redirect(controller: 'user', action: 'editProfilePage')
    }

    def inboxPagination() {
        int offset = params.offset ? params.int("offset") : 0
        int max = params.max ? params.int("max") : 5
        List<Resource> resourceList = tagService.inbox(User.findByUsername("${session['username']}"), offset, max)
        int totalCount = resourceList.totalCount
        render(template: "/user/inbox", model: [resourceList: resourceList, total: totalCount])
    }

    def userList() {
        Topic topic = Topic.get(params.int("topicId"))
        int offset = params.offset ? params.int("offset") : 0
        int max = params.max ? params.int("max") : 10
        List<User> userList = tagService.userSubscriptionByTopic(topic, offset, max)
        int totalCount = userList.totalCount
        render(template: "/user/userSubscriptionList", model: [userList: userList, total: totalCount, topicId: topic.id])
    }

    def userListPagination() {
        int offset = params.offset ? params.int("offset") : 0
        int max = params.max ? params.int("max") : 2
        List<User> userList = userService.listOfUser(offset, max)
        int totalCount = userList.totalCount
        render(template: "/user/userInfo", model: [userList: userList, total: totalCount])
    }

}
