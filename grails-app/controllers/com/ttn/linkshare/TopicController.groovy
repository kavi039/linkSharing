package com.ttn.linkshare

import com.ttn.linkShare.Topic
import com.ttn.linkShare.TopicCo

class TopicController {
   def topicService
    def show() {

        println params.name
        render view:'show',model:[topic:Topic.findByName(params.name)]
    }
    def create(){

    }
    def saveTopic(TopicCo topicCO){

    if( topicService.create(topicCO,session['username'])) {
        flash.error = "Topic created"
    }
        else{
        flash.error="Topic Not Created"
    }
        redirect(controller: "user",action: "dashBoard")
    }

}
