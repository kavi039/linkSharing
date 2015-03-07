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
            Subscription subscription=new Subscription(seriousness:Seriousness.VERYSERIOUS,topic: topic,user:user)
           if(topic.save() &&subscription.save())
           {
            return  true
           }
        }
        else {
            return false
        }
}
}
