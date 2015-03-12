package com.ttn.linkshare

import com.ttn.linkShare.Resource
import com.ttn.linkShare.SubscriptionCO
import com.ttn.linkShare.Topic
import com.ttn.linkShare.TopicCo
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

    def saveTopic(TopicCo topicCO) {

        if (topicService.create(topicCO, "" + session['username'])) {
            flash.error = "Topic created"
        } else {
            flash.error = "Topic Not Created"
        }
        redirect(controller: "user", action: "dashBoard")
    }

    def subscription() {

    }

    def resourceListByTopic(Long id) {
        Set<Resource> resourceList = Topic.get(id).resources
        render(template: "../user/inbox", model: [resourceList: resourceList])
    }

    def topicSubscription(Long topicId,Seriousness seriousness) {
        println "innn         >$topicId"
        Boolean isSubscribed = topicService.topicSubscription(topicId,seriousness, "${session['username']}")
        if (isSubscribed) {
            return  true
        } else {
            return false
        }

    }

}
