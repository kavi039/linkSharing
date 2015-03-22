package com.ttn.linkshare

import com.ttn.linkShare.Resource
import com.ttn.linkShare.Subscription
import com.ttn.linkShare.Topic
import com.ttn.linkShare.TopicCo
import com.ttn.linkShare.User
import com.ttn.linkShare.enums.Seriousness
import grails.converters.JSON

class TopicController {
    def topicService
    def tagService

    def create() {

    }

    def topicShow() {
        render view: "/topic/topicShow", model: [topic: Topic.get(params.topicName)]
    }

    def saveTopic(TopicCo topicCO) {

        if (topicService.create(topicCO, "${session['username']}")) {
            flash.error = "Topic created"
            println(">>>>>>>>>>>>>>>>>>>>>$params")
            render(view: "/topic/topicShow", model: [topic: topicCO.topic])
        } else {
            flash.error = "Topic Not Created"
            redirect(controller: "user", action: "dashBoard")
        }

    }

    def subscription() {

    }

    def resourceListByTopic(Long id) {
        Set<Resource> resourceList = Topic.get(id).resources
        render(template: "../user/inbox", model: [resourceList: resourceList])
    }

    def topicSubscription(Long topicId, String seriousness) {
        Integer count = topicService.topicSubscription(topicId, seriousness, "${session['username']}")
        println "in topic controller $count"
        render([count: count] as JSON)


    }

    def topicUnSubscription(Long topicId) {
        println "*************$topicId"
        Integer count = topicService.topicUnSubscription(topicId, "${session['username']}")
        render model: [count: count] as JSON

    }

    def topicSubscriptionUpdate(Long topicId, String seriousness) {
        println ">><><><><In topicsubscription+$topicId+$seriousness"
        Boolean isUpdated = topicService.topicSubscriptionUpdate(topicId, "${session['username']}", seriousness)
        if (isUpdated) {
            render true
        } else {
            render false
        }

    }

    def topicVisibilityUpdate(Long topicId, String visibility) {
        Boolean isUpdated = topicService.topicVisibilityUpdate(topicId, visibility)
        if (isUpdated) {
            render true
        } else {
            render false
        }
    }

    def deleteTopic(Long topicId) {
        topicService.deleteTopic(topicId)
        if (Topic.get(topicId)) {
            render false
        } else {
            render true
        }
    }

    def updateTopicName(Long topicId, String topicName) {
        Boolean isUpdated = topicService.updateTopicName(topicId, topicName)
        if (isUpdated) {
            render true
        } else {
            render false
        }
    }

    def publicTopicCreatedByUser() {
        int offset =params.int("offset")
        int max = params.int("max")
        User user=User.get(params.int("userId"))
        List<Topic> topicList = tagService.publicTopicCreatedByUser(user,offset, max)
        int totalCount = topicList.totalCount
        render(template: "/topic/publicTopicCreatedByUser", model: [topicList: topicList, total: totalCount,userId:user.id])
    }

    def topicList() {
        int offset = params.int("offset")
        int max = params.int("max")
        List<Topic> topicList = tagService.userSubscribedTopicOrderByName("${session['username']}", offset, max)
        int totalCount = topicList.totalCount
        render(template: "/topic/topicsSubscription", model: [topicList: topicList, total: totalCount])
    }
    def topicCreatedByUser(){
        int offset = params.offset as Integer
        int max = params.max as Integer
        List<Topic> topicList = tagService.topicCreatedByUser("${session['username']}", offset, max)
        int totalCount = topicList.totalCount
        render(template: '/topic/topicCreatedByUser', model: [topicList: topicList, total: totalCount])
    }


}


