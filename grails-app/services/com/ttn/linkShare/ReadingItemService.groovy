package com.ttn.linkShare

import grails.transaction.Transactional

@Transactional
class ReadingItemService {

    def updateResource(Long resourceId, String username) {
      User user= User.findByUsername(username)
      Resource resource=  Resource.get(resourceId)
        ReadingItem readingItem=ReadingItem.findByResourceAndUser(resource,user)
        if (Subscription.findByTopicAndUser(resource.topic,user )) {
            Boolean isRead = !readingItem.isRead
            readingItem.properties = [isRead: isRead]
            readingItem.save(flush: true) ? true : false
        } else {
            return false
        }
    }

//    def markAsUnread(Long resourceId, String username) {
//     User user= User.findByUsername(username)
//        Resource resource = Resource.get(resourceId)
//        if (Subscription.findByTopicAndUser(resource.topic,user)) {
//            ReadingItem readingItem=ReadingItem.findByResource(resource)
//            readingItem.
//            return true
//        } else {
//            return false
//        }
//
//    }


}
