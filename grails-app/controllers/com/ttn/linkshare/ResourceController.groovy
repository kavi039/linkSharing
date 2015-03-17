package com.ttn.linkshare

import com.ttn.linkShare.DocumentResource
import com.ttn.linkShare.LinkResource
import com.ttn.linkShare.Resource

class ResourceController {

    def downloadAction(Long resourceId){
        Resource resource=DocumentResource.get(resourceId)
        File file=new File(resource.filePath)
        response.setHeader("Content-disposition", "attachment; filename=${file.name}")
        response.setContentType("application/png")
        response.outputStream << file.bytes
        response.outputStream.flush()
    }
    def viewFullSite(Long resourceId){
        Resource resource=LinkResource.get(resourceId)
        redirect url:resource.url

    }
}
