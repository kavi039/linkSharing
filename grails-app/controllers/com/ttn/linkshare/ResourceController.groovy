package com.ttn.linkshare

import com.ttn.linkShare.DocumentResource
import com.ttn.linkShare.LinkResource
import com.ttn.linkShare.Resource
import com.ttn.linkShare.ResourceRating
import com.ttn.linkShare.User

class ResourceController {
    def tagService

    def downloadAction(Long resourceId) {
        Resource resource = DocumentResource.get(resourceId)
        File file = new File(resource.filePath)
        response.setHeader("Content-disposition", "attachment; filename=${file.name}")
        response.setContentType("application/png")
        response.outputStream << file.bytes
        response.outputStream.flush()
    }

    def viewFullSite(Long resourceId) {
        Resource resource = LinkResource.get(resourceId)
        redirect url: resource.url

    }

    def post() {
        render view: '/resource/post', model: [resourceInstance: Resource.get(params?.resourceId)]
    }


    def resourceRating(Long resourceId, Integer score) {
        User user = User.findByUsername("${session['username']}")
        Resource resource = Resource.get(resourceId)
        ResourceRating resourceRating = ResourceRating.findOrCreateByResourseAndUser(resource, user)
        resourceRating.properties = [user: user, resourse: resource, score: score]
        Boolean status = resourceRating.save(flush: true)
        render status
    }
    def deleteResource(Long resourceId){
        Resource resource=Resource.get(resourceId)
        resource.delete(flush: true)
        render true
    }
    def resourceListPagination(){
       int offset=params.offset?params.int("offset"):0
        int max=params.max?params.int("max"):5
        List<Resource>resourceList=tagService.recentShare(offset,max)
        int totalCount=resourceList.totalCount
        render (template: "/login/recentShare" ,model: [resourceList:resourceList,total:totalCount])
    }

}
