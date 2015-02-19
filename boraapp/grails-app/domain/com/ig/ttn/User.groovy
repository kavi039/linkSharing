package com.ig.ttn

class User {
    String email
    String  username
    String  password
    String  firstName
    String lastName
    byte photo
    Boolean admin
    Boolean active
    Date dateCreated
    Date lastUpdated


    static constraints = {
     email blank:false,email:true
        username blank:false
        lastName blank: false
        firstName blank: false
        password size:4..10
        admin blank:false
        active blank:false
        photo null:true;

    }
    static hasMany = [topics:Topic,resourceRatings:ResourceRating,subsciptions:Subsciption];
}
