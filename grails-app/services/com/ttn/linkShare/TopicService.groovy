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
            Topic findTopic = Topic.findByNameAndUser(topicCo.name, user)
            if (findTopic) {
                return false
            } else {
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
                }
            }

        } else {
            println "is   not validate*******************************"
            return false
        }

    }

    Integer topicSubscription(Long topicId, String seriousness, String username) {
        Integer count = 0
        User user = User.findByUsername(username)
        Topic topic = Topic.findById(topicId)
        println "***********${topic.resources*.id}"
        Subscription subscription = new Subscription(user: user, topic: topic, seriousness: seriousness)
        if (subscription.save(flush: true)) {
            println("********$seriousness")
            Set<Resource> resourceList = topic.resources
            resourceList.each {
                ReadingItem readingItem = new ReadingItem(resource: it, isRead: false, user: user)
                readingItem.save(flush: true)
            }
            count = Subscription.countByTopic(topic)
//            count = Subscription.countByUser(user)
            return count

        } else {
            return count
        }
    }

    Integer topicUnSubscription(Long topicId, String username) {
        User user = User.findByUsername(username)
        Topic topic = Topic.get(topicId)
        Subscription subscription = Subscription.findByTopicAndUser(topic, user)
        List<ReadingItem> readingItemList = ReadingItem.findAllByResourceInListAndUser(topic.resources as List, user)
        ReadingItem.deleteAll(readingItemList)
        println("**********" + subscription)
        subscription?.delete(flush: true)
        println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + Subscription.countByTopic(topic))
        println("After unsubscribe" + ReadingItem.findAllByUser(user))
        return Subscription.countByTopic(topic)

    }

    Boolean topicSubscriptionUpdate(Long topicId, String username, String seriousness) {
        User user = User.findByUsername(username)
        Topic topic = Topic.get(topicId)
        Subscription subscription = Subscription.findByTopicAndUser(topic, user)
        subscription.properties = [seriousness: seriousness]
        subscription.save(flush: true) ? true : false
    }

    Boolean topicVisibilityUpdate(Long topicId, String visibility) {
        Topic topic = Topic.get(topicId)
        topic.properties = [visibility: visibility]
        topic.save(flush: true) ? true : false
    }

    void deleteTopic(Long topicId) {
       Topic topic=Topic.get(topicId)
        topic.delete(flush:true)
    }
   Boolean updateTopicName(Long topicId,String topicName){
       println("@@@@@@@@@@@@@@$topicId+>>>>>>>>>>$topicName")
     Topic topic=Topic.get(topicId)
       topic.properties=[name:topicName]
       topic.save(flush: true)?true:false
   }
}
