package com.ttn.linkshare

import com.ttn.linkShare.DocumentResource
import com.ttn.linkShare.LinkResource
import com.ttn.linkShare.Resource
import com.ttn.linkShare.ResourceRating
import com.ttn.linkShare.Topic
import com.ttn.linkShare.User

import java.text.SimpleDateFormat

class ResourceController {
    def tagService

    def index() {

    }

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

    def deleteResource(Long resourceId) {
        Resource resource = Resource.get(resourceId)
        resource.delete(flush: true)
        render true
    }

    def recentShare() {
        int offset = params.offset ? params.int("offset") : 0
        int max = params.max ? params.int("max") : 5
        List<Resource> resourceList = tagService.recentShare(offset, max)
        int totalCount = resourceList.totalCount
        render(template: "/login/recentShare", model: [resourceList: resourceList, total: totalCount])
    }

    def topPostAction() {
        int offset = params.offset ? params.int("offset") : 0
        int max = params.max ? params.int("max") : 5
        List<Object> objectList = tagService.topPost(0, 5)
        List<Resource> resourceList = objectList.collect() { it[0] }
//        List<Resource> resourceList = tagService.topPost(offset, max)
//        int totalCount = resourceList.totalCount
        int totalCount = objectList.totalCount
        render(template: "/login/topPost", model: [resourceList: resourceList, total: totalCount])
    }

    def resourceList() {
        Topic topic = Topic.get(params.int("topicId"))
        int offset = params.offset ? params.int("offset") : 0
        int max = params.max ? params.int("max") : 5
        List<Resource> resourceList = tagService.displayResourcesOfTopic(topic, offset, max)
        int totalCount = resourceList.totalCount
        render(template: "/topic/displayResourcesOfTopic", model: [resourceList: resourceList, total: totalCount, topicId: topic.id])
    }

    def resourceListOfSubscribedTopic() {
        int offset = params.offset ? params.int("offset") : 0
        int max = params.max ? params.int("max") : 10
        List<Resource> resourceList = tagService.userSubscribedResourceList("${session['username']}", offset, max)
        render(template: '/topic/topicSubscribedPost', model: [resourceList: resourceList, total: resourceList.totalCount])

    }

    def publicResourceListCreatedByUser() {
        int offset = params.int("offset")
        int max = params.int("max")
        User user = User.get(params.int("userId"))
        List<Resource> resourceList = tagService.publicResourcesOfTopicCreatedByUser(user, offset, max)
        int totalCount = resourceList.totalCount
        render(template: "/user/publicPost", model: [resourceList: resourceList, total: totalCount, userId: user.id])
    }
    def action(){
        def v=Resource.load(20)
       println (">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+v)
        println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+v.resourceRatings)
    }

}
