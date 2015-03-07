package com.ttn.linkShare

import grails.validation.Validateable
import org.springframework.web.multipart.MultipartFile


@Validateable
class UserCO {

    String email
    String username
    String password
    String firstName
    String lastName
    String photoPath
    Boolean admin
    Boolean active
    String confirmPassword
    MultipartFile photo

    static constraints = {
        password(validator: { val, obj ->
            val.equals(obj.confirmPassword)
        })
        email email: true
        email(validator: { value, object ->
            print("email: ${User.findByEmail(value) ? false : true}")
            User.findByEmail(value) ? false : true
        })

        username(validator: { value, object ->
            print("username: ${User.findByUsername(value) ? false : true}")
            User.findByUsername(value) ? false:true
        })
    }

}
