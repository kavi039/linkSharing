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

    def create() {

    }

    def topicShow() {
        render view: "/topic/topicShow", model: [topicName: params.topicName]
    }

    def saveTopic(TopicCo topicCO) {

        if (topicService.create(topicCO, "${session['username']}")) {
            flash.error = "Topic created"
            println(">>>>>>>>>>>>>>>>>>>>>$params")
            //redirect(controller: "user" ,action: "dashBoard")
            render(view: "/topic/topicShow", model: [topicName: topicCO.name])
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
        if(Topic.get(topicId))
        {
            render false
        }
        else
        {
            render true
        }
    }
    def updateTopicName(Long topicId,String topicName){
      Boolean isUpdated= topicService.updateTopicName(topicId,topicName)
        if(isUpdated)
        {
            render true
        }
        else{
            render false
        }
    }
}


