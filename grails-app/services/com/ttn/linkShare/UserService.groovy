package com.ttn.linkShare

import grails.transaction.Transactional

@Transactional
class UserService {
def create(User user){

}
    def delete(User user){

    }
    def update(User user){

    }
    def rollback(){
            new User(firstName: "rahul",lastName: "mahazan")
    }

}
