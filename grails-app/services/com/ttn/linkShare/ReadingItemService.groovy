package com.ttn.linkShare

import grails.transaction.Transactional

@Transactional
class ReadingItemService {

    def updateResource(Long resourceId) {
        Resource resource=Resource.get(resourceId)
        println(">>>>>>>>>>>>>>>>>>>>>*"+resource.isRead)
      Boolean isRead=  !resource.isRead
        println(">>>>>>>>>>>>>>>>>>>>>*"+isRead)
        println(">>>>>>>>>>>>>>>>>>>>>*"+isRead)
        resource.properties=[isRead:isRead]
        resource.save(flush: true)

    }
}
