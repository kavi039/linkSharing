package com.ttn.linkShare

import grails.transaction.Transactional

@Transactional
class LinkResourceService {

    def save(LinkCO linkCO) {
        linkCO.topic = Topic.findByName(linkCO.name)

        println ">>>>>>>>>>>>>>>>>>>>>>>>in save"+linkCO.name
          linkCO.user = linkCO.topic.user
          linkCO.isRead=true
        if(!linkCO.validate())
        {
            return false
        }
        else{

            LinkResource linkResource=new  LinkResource(linkCO.properties)
           if( linkResource.save(failOnError: true))
           {
               return true
           }
            else
           {
               return false
           }
        }

    }
}
