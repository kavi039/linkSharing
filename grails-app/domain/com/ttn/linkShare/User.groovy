package com.ttn.linkShare

class User {

    String email
    String username
    String password
    String firstName
    String lastName
    String photo
    Boolean admin
    Boolean active
    String name
    static  transients =['name']
    //String confirmPassword

//    static transients = ['confirmPassword']

    static hasMany = [topics: Topic, resourceRatings: ResourceRating];


    static constraints = {
        email blank: false, email: true, unique: true
        username blank: false, unique: true
        lastName blank: false
        firstName blank: false
        password size: 4..10
        admin nullable: true
        active nullable: true
        photo nullable: true

    }
    String getName(){
        return "${firstName} ${lastName}"
    }


}
