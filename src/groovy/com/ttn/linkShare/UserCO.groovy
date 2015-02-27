package com.ttn.linkShare

import grails.validation.Validateable
import org.springframework.web.multipart.MultipartFile

/**
 * Created by intelligrape on 28/2/15.
 */
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

    static constraint = {
        password(validator: { val, obj ->
            print("password : ${val.equals(obj.confirmPassword) == true ? true : false}")
            val.equals(obj.confirmPassword) == true ? true : false
        })
        email(validator: { value, object ->
            print("email: ${User.findByEmail(value) ? false : true}")
            User.findByEmail(value) ? false : true
        })
        username(validator: { value, object ->
            print("username: ${User.findByUsername(value) ? false : true}")
            User.findByUsername(value) ? true : false
        })
    }

}
