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
                String filePath = '/home/intelligrape/Project/linkShare/web-app/images/Userfolder/' + userco.username
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

            return false
        }
    }

    def delete(User user) {

    }

    def update(User user) {

    }

    def listingUser(String key){
        List<User> userList
        if(key.equals('Alluser'))
        {
            userList=User.list()
        }
        else {
            Boolean b = key.equals('Active')
             userList=User.findAllByActive(b)
        }

      return  userList


    }
}
