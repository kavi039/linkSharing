package com.ttn.linkShare

import grails.transaction.Transactional
import org.springframework.web.multipart.MultipartFile

import javax.jws.soap.SOAPBinding

@Transactional
class UserService {
    Boolean register(UserCO userco) {
        File photoFile = null
        if (userco.validate()) {
            MultipartFile file = userco.photo
            String name = file.getOriginalFilename()
            if (name) {
                String filePath = '/home/intelligrape/Project/Userfolder/' + userco.username
            File  photoFileDir = new File(filePath)
                photoFileDir.mkdirs()
                photoFile=new File("$photoFileDir/$name")
                photoFile.createNewFile()
                file.transferTo(photoFile)
            }
           userco.photoPath = photoFile?.canonicalPath
            userco.admin=false
            userco.active=true
            User user=new User(userco.properties)
            if (user.save(failOnError: true)) {
                return true
            } else {
                return false
            }
        } else {
          userco.errors.getAllErrors().each {println it}
            return false
        }
    }



    def update(Long id) {
       User user=User.get(id)
        println (user.name)
        Boolean active=!user.active
        user.properties=[active:active]
        user.save(flush: true)
        return active

    }

    def listingUser(String key){
        List<User> userList


      return  userList


    }
}
