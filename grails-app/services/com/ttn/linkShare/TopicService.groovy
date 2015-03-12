package com.ttn.linkShare

import com.ttn.linkShare.enums.Seriousness
import com.ttn.linkShare.enums.Visibility
import grails.transaction.Transactional

@Transactional
class TopicService {
    Boolean create(TopicCo topicCo,String username){
        if(topicCo.validate()) {
            User user = User.findByUsername(username)
            topicCo.user = user
            Topic topic = new Topic(topicCo.properties)
            Subscription subscription=new Subscription(seriousness:Seriousness.CASUAL,topic: topic,user:user)
           if(topic.save() &&subscription.save())
           {
            return  true
           }
        }
        else {
            return false
        }
}
    Boolean topicSubscription(Long topicId,Seriousness seriousness,String username){
            if(topicId!=null&&seriousness!=null) {
                User user = User.findByUsername(username)
                Topic topic = Topic.findById(topicId)
                Subscription subscription = new Subscription(user: user, topic: topic, seriousness: subscriptionCO.seriousness)
                subscription.save(flush: true) ? true : false
            }
    else
            {
                return false
            }
    }


}
