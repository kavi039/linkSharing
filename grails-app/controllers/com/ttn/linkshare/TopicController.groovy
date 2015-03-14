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

    def show() {

        println params.name
        render view: 'topicShow', model: [topic: Topic.findByName(params.name)]
    }

    def create() {

    }

    def topicShow() {
        render view: "/topic/topicShow", model: [topicName: params.topicName]
    }

    def saveTopic(TopicCo topicCO) {

        if (topicService.create(topicCO, "${session['username']}")) {
            flash.error = "Topic created"
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
        println("**************")
        println("**************")
        println("**************")
        println("**************")
        println("**************")
        println("**************")
        println("**************")
        println("**************")
        println("**************")
        println("**************")
        println("aaya")
        Integer count = topicService.topicSubscription(topicId, seriousness, "${session['username']}")

        println "subdgfyewf cjhv rj $count"
        println("gaya")
        render ([count:count] as JSON)


    }

    def topicUnSubscription(Long topicId) {
        println "*************$topicId"
   Integer count= topicService.topicUnSubscription(topicId, "${session['username']}")
        render model: [count:count] as JSON

    }


}


