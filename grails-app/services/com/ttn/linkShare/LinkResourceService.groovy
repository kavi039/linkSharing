package com.ttn.linkShare

import grails.transaction.Transactional

@Transactional
class LinkResourceService {

    def save(LinkCO linkCO,String username) {
          linkCO.user =User.findByUsername(username)
        linkCO.topic = Topic.findByNameAndUser(linkCO.name,linkCO.user)
        if(!linkCO.validate())
        {
            linkCO.errors.allErrors.each {println(it)}
            return false
        }
        else{

            LinkResource linkResource=new  LinkResource(linkCO.properties)
            ReadingItem readingItem=new ReadingItem(resource:linkResource,isRead: false,user:linkCO.user)
            (linkResource.save(flush: true, failOnError: true)!=null)&&(readingItem.save(flush: true))
        }

    }
}
