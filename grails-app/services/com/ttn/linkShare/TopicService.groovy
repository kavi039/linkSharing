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
            Topic topic = new Topic(topicCo.properties)
            Subscription subscription = new Subscription(seriousness: Seriousness.CASUAL, topic: topic, user: user)
            if (topic.save() && subscription.save()) {
                return true
            }
        } else {
            return false
        }
    }

    Boolean topicSubscription(Long topicId, String seriousness, String username) {

            User user = User.findByUsername(username)
            Topic topic = Topic.findById(topicId)
        println "********$user  $topic"
            Subscription subscription = new Subscription(user: user, topic: topic, seriousness: seriousness)

            if (subscription.save(flush: true)) {
                println("********$seriousness")
                return true

            } else {
                return false
            }
        }

   def  topicUnSubscription(Long topicId,String username){
       User user=User.findByUsername(username)
       Topic topic=Topic.get(topicId)
      Subscription subscription= Subscription.findByTopicAndUser(topic,user)
       println("**********"+subscription)
       subscription?.delete(flush: true)
       println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+Subscription.findByTopicAndUser(topic,user))
   }


}
