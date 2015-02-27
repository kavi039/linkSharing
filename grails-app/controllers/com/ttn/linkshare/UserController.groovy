package com.ttn.linkshare

import com.ttn.linkShare.User

class UserController {

    def dashBoard() {
        String username = session.getAttribute("username")
        User user = User.findByUsername(username)
        [user: user]
    }
}
