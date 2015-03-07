package com.ttn.linkShare

import com.ttn.linkShare.enums.Visibility
import grails.transaction.Transactional

@Transactional
class TagService {

    def recentShare() {
        List<Resource> resources = Resource.createCriteria().list(max: 5) {
            'topic' {
                eq("visibility", Visibility.PUBLIC)
            }
            order("dateCreated", "desc")

        }
        return resources
    }

    def topPost() {
        List<Resource> resources = Resource.createCriteria().list(max: 4) {
            'topic' {
                eq("visibility", Visibility.PUBLIC)
            }
            order("score", "desc")
        }
        return resources
    }

    def userSubscription(String username) {
        User user = User.findByUsername(username)

        Long totalSubscription = Subscription.countByUser(user)
        Long totalTopic = Topic.countByUser(user)
        Map m = [user: user, totalSubscription: totalSubscription, totalTopic: totalTopic]
        return m
    }

    def userSubscribedTopic(String username) {
        User user = User.findByUsername(username)

        List<Topic> topicLists=Subscription.createCriteria().list(max:5) {
            projections {
                property('topic')
            }

            eq('user',user)
        }

    /* List<Topic> topicList = Resource.createCriteria().list(sort: 'dateCreated', order: 'desc') {
            projections {
                property('topic')
            }
            'topic' {
                eq('user', user)
            }
        }
        if (topicList) {
            List<Topic> topicLists = Subscription.createCriteria().list(max: 5) {
                projections {
                    property('topic')
                }
                inList('topic', topicList)
            }
            return topicLists
            println "****************************"
            println topicLists.size()
        }

*/
     return  topicLists

    }
  def inbox(User user){
      List<Resource> resourceList=Resource.createCriteria().list (max:5){
          eq('isRead',false)
      }

  }



}
