package com.ttn.linkShare

import grails.validation.Validateable

@Validateable
class UserPasswordCO {
   String password
   String confirmPassword
    static constraints={
        password size:4..10
        password (validator:{value,object->
            println (value.equals(object.confirmPassword))
            value.equals(object.confirmPassword)
        })
    }
}

