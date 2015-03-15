package com.ttn.linkshare

import com.ttn.linkShare.Resource

class ReadingItemController {
    def readingItemService
    def markAsRead(Long resourceId){
       Boolean isSubscrideb= readingItemService.updateResource(resourceId,"${session['username']}")
       render "Mark as Unread"
    }
    def markAsUnRead(Long resourceId){
        readingItemService.updateResource(resourceId,)
      render "Mark as read"
    }

}
