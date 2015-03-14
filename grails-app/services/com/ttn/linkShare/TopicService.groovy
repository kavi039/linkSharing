package com.ttn.linkShare

import com.ttn.linkShare.enums.Seriousness
import com.ttn.linkShare.enums.Visibility
import grails.transaction.Transactional

@Transactional
class TopicService {
    Boolean create(TopicCo topicCo, String username) {
        if (topicCo.validate()) {
            User user = User.findByUsername(username)
            topicCo.user = user
            Topic findTopic=Topic.findByNameAndUser(topicCo.name,user)
            if(findTopic){
                return false
            }
            else{
            Topic topic = new Topic(topicCo.properties)
            Subscription subscription = new Subscription(seriousness: Seriousness.CASUAL, topic: topic, user: user)
            if (topic.save() && subscription.save()) {
                println "is    save*******************************"
                return true
            } else {
                topic.errors.allErrors.each {
                    println it
                }
                println "is   not save*******************************"
                return false
            }}

        } else {
            println "is   not validate*******************************"
            return false
        }

    }

    Integer topicSubscription(Long topicId, String seriousness, String username) {
        Integer count = 0
        User user = User.findByUsername(username)
        Topic topic = Topic.findById(topicId)
        println "********$user  $topic"
        Subscription subscription = new Subscription(user: user, topic: topic, seriousness: seriousness)

        if (subscription.save(flush: true)) {
            println("********$seriousness")
            count = Subscription.countByTopic(topic)
            return count

        } else {
            return count
        }
    }

    Integer topicUnSubscription(Long topicId, String username) {
        User user = User.findByUsername(username)
        Topic topic = Topic.get(topicId)
        Subscription subscription = Subscription.findByTopicAndUser(topic, user)
        println("**********" + subscription)
        subscription?.delete(flush: true)
        println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +Subscription.countByTopic(topic) )

        return Subscription.countByTopic(topic)

    }


}
