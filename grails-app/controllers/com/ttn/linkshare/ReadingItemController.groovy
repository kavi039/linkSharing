package com.ttn.linkshare

import com.ttn.linkShare.Resource

class ReadingItemController {
    def readingItemService
    def markAsRead(Long resourceId){
       Boolean resourceUpdated= readingItemService.updateResource(resourceId,"${session['username']}")
        if(resourceUpdated) {
            render "Mark as Unread"
        }
        else
        {
            render "Mark as read"
        }
    }
    def markAsUnRead(Long resourceId){
    Boolean isSubscribed=readingItemService.updateResource(resourceId,"${session['username']}")
        if(isSubscribed){
            render "Mark as read"
        }
        else
        {
            render "Mark as Unread"
        }

    }

}
