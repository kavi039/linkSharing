package com.ttn.linkShare

import grails.transaction.Transactional

@Transactional
class ReadingItemService {

    def updateResource(Long resourceId, String username) {
        Resource resource = Resource.get(resourceId)
        if (Subscription.findByTopicAndUser(resource.topic, User.findByUsername(username))) {
            println(">>>>>>>>>>>>>>>>>>>>>*" + resource.isRead)
            Boolean isRead = !resource.isRead
            println(">>>>>>>>>>>>>>>>>>>>>*" + isRead)
            println(">>>>>>>>>>>>>>>>>>>>>*" + isRead)
            resource.properties = [isRead: isRead]
            resource.save(flush: true)?true:false
        } else {
            return false
        }
    }
    def markAsUnread(Long resourceId,String username){
        Resource resource=Resource.get(resourceI

    }


}
