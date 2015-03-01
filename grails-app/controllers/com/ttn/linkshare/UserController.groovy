package com.ttn.linkshare

import com.ttn.linkShare.Topic
import com.ttn.linkShare.User

class UserController {
def tagService
    static beforeInterceptor = {
        if (!User.findByUsername(session['username'])?.admin) {
            flash.error = "not allowed"
           // redirect(controller: 'user', action: 'dashBoard')
            return
        }
    }

    def dashBoard() {
        String username = session.getAttribute("username")
        User user = User.findByUsername(username)
        List<Topic> topicList = Topic.list(max: 5, offset: 0)
        [user: user, topicList: topicList]
    }

    def list() {
        User.list().each { User user ->
            render "<br>${user.firstName} ${user.lastName}"
        }

    }

    def taglib(){
        tagService.topPost()
    }

}
