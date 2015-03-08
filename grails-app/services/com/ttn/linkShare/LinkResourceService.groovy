package com.ttn.linkShare

import grails.transaction.Transactional

@Transactional
class LinkResourceService {

    def save(LinkCO linkCO,String username) {
        linkCO.topic = Topic.findByName(linkCO.name)

          linkCO.user =User.findByUsername(username)
          linkCO.isRead=true
        if(!linkCO.validate())
        {
            linkCO.errors.allErrors.each {println(it)}
            return false
        }
        else{

            LinkResource linkResource=new  LinkResource(linkCO.properties)
           if( linkResource.save(flush: true, failOnError: true))
           {
               return true
           }
            else
           {
               return false
           }
        }

    }
}
