package com.ttn.linkShare

import grails.transaction.Transactional

@Transactional
class LinkResourceService {

    def save(LinkCO linkCO,String username) {
        ReadingItem readingItem
          linkCO.user =User.findByUsername(username)
        if (linkCO.validate()) {
            LinkResource linkResource
            if (linkCO.id != null) {
                linkResource = LinkResource.get(linkCO.id)
                linkResource.properties = [description: linkCO.description, user: linkCO.user, topic: linkResource.topic,url: linkCO.url]
                readingItem = ReadingItem.findOrCreateByResourceAndUser(linkResource,linkCO.user)
                readingItem.properties = [isRead: false]
            } else {
                Topic topic = Topic.get(linkCO.topicId)
                linkResource = new LinkResource(description: linkCO.description, user: linkCO.user, topic: topic,url: linkCO.url)
                readingItem = new ReadingItem(resource: linkResource, isRead: false, user: linkCO.user)
            }
            (linkResource.save(failOnError: true) != null) && (readingItem.save(flush: true) != null)
        } else {
            linkCO.errors.allErrors.each {
                println it
            }
            return false
        }

    }
}
























//        if(!linkCO.validate())
//        {
//            linkCO.errors.allErrors.each {println(it)}
//            return false
//        }
//        else{
//
//            LinkResource linkResource=new  LinkResource(linkCO.properties)
//            ReadingItem readingItem=new ReadingItem(resource:linkResource,isRead: false,user:linkCO.user)
//            (linkResource.save(flush: true, failOnError: true)!=null)&&(readingItem.save(flush: true))
//        }
//
//    }
//}
