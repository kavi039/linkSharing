package com.ttn.linkShare

import grails.validation.Validateable
import org.springframework.web.multipart.MultipartFile

@Validateable
class UserUpdateCO {
    String username
    String firstName
    String lastName
    String photoPath
    MultipartFile photo
    Long id
    static constraints = {
           username nullable: true
        firstName nullable: true
        lastName nullable: true
        photoPath nullable: true
        username nullable: true
        username(validator: { value, object ->
            print("username:*********>>>>>>>>>>>>>>>>>>> ${User.findByUsernameAndIdNotEqual(value, object.id) == null}")
            User.findByUsernameAndIdNotEqual(value, object.id) == null
        })


    }
}