package com.ttn.linkshare

import com.ttn.linkShare.User
import com.ttn.linkShare.UserCO
import org.springframework.web.multipart.MultipartFile

class LoginController {

    def loginHandler(UserCO userCO) {
        User user = User.findByEmailAndPassword(userCO.email, userCO.password)
        if (user) {
            session["username"] = user.username
            redirect(controller: 'user', action: 'dashBoard')
        } else {
            flash.error = "User not Found."
            redirect(controller: "dashboard", action: "index")
        }
    }

    def registerHandler(UserCO userCO) {
        MultipartFile file = userCO.photo
        if(!userCO.validate()) {
            log.error("UserCO validation failed.")
            redirect(controller: 'dashboard', action: 'index', params: ['name': "kindly enter valid data CO FAIL"])
        }
        String name = file.getOriginalFilename()
        String filePath = '/home/intelligrape/Project/linkShare/photo/' + userCO.username + name.substring(name.lastIndexOf('.'))
        println "filePath: $filePath"
        File photoFile = new File(filePath)
        photoFile.createNewFile()
        println photoFile.canonicalPath
        file.transferTo(photoFile)

        User user = new User(firstName: userCO.firstName, lastName: userCO.lastName, email: userCO.email, password: userCO.password, username: userCO.username, photo: photoFile.canonicalPath)
        if (user.validate()) {
            try {
                if (user.save()) {
                    session['username'] = user.username
                    redirect(controller: 'user', action: 'dashBoard')
                } else {
                    log.error("User not Saved")
                    redirect(controller: 'dashboard', action: 'index', params: ['name': "kindly enter valid data"])
                }
            } catch (Exception ex) {
                log.error("User not Saved")
                redirect(controller: 'dashboard', action: 'index', params: ['name': "Unique failed."])
            }
        } else {
            log.error("User validation failed.")
            redirect(controller: 'dashboard', action: 'index', params: ['name': "kindly enter valid data"])
        }
    }
}
