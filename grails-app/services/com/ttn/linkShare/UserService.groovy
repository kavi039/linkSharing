package com.ttn.linkShare

import grails.transaction.Transactional
import org.springframework.web.multipart.MultipartFile

import javax.jws.soap.SOAPBinding

@Transactional
class UserService {
    def mailService

    Boolean register(UserCO userco) {
        userco.active = true
        if (userco.validate()) {
            uploadPhoto(userco)
            User user = new User(userco.properties)
            if (user.save(failOnError: true)) {
                return true
            } else {
                return false
            }
        } else {
            userco.errors.getAllErrors().each { println it }
            return false
        }
    }


    def updateByActivation(Long id) {
        User user = User.get(id)
        println(user.name)
        Boolean active = !user.active
        user.properties = [active: active]
        user.save(flush: true)
        return active

    }

//    def listingUser(String key) {
//        List<User> userList
//        return userList
//    }

    def uploadPhoto(def userCO) {
        File photoFile = null
        MultipartFile file = userCO.photo
        String name = file.getOriginalFilename()
        if (name) {
            String filePath = '/home/intelligrape/Project/Userfolder/' + userCO.username
            File photoFileDir = new File(filePath)
            photoFileDir.mkdirs()
            photoFile = new File("$photoFileDir/$name")
            photoFile.createNewFile()
            file.transferTo(photoFile)
        }
        userCO.photoPath = photoFile?.canonicalPath

    }


    def updateProfile(UserUpdateCO userUpdateCO, String username) {
        User user = User.findByUsername(username)
        println("user name *****${user}")
        userUpdateCO.id = user.id
        uploadPhoto(userUpdateCO)
        if (userUpdateCO.validate()) {
            user.properties = [firstName: userUpdateCO.firstName, lastName: userUpdateCO.lastName, username: userUpdateCO.username, photoPath: userUpdateCO.photoPath]
            user.save(flush: true) ? true : false
        } else {
            userUpdateCO.errors.allErrors.each { println(">>>$it") }
            return false
        }
    }

    def updatePassword(UserPasswordCO userPasswordCO, String username) {
        User user = User.findByUsername(username)
        if (userPasswordCO.validate()) {
            user.properties = [password: userPasswordCO.password]
            if (user.save(flush: true)) {
                return true
            } else {
                return false
            }
        } else {
            return false
        }

    }


    def checkNull(def userCO, User user) {

    }
}
