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
        List<Resource> resources = Resource.createCriteria().list {
            'topic' {
                eq("visibility", Visibility.PUBLIC)
            }
        }
        List<Resource> resourceList = ResourceRating.createCriteria().list(max: 4) {
            projections {
                property("resource")
            }
            inList("resource", resources)
            order("score", "desc")
        }
        return resourceList
    }

    def userSubscription(String username) {
        User user = User.findByUsername(username)
        Long totalSuscription = Subscription.countByUser(user)
        Long totalTopic = Topic.countByUser(user)
        Map m = [user: user, totalSubscription: totalSuscription, totalTopic: totalTopic]
        return m
    }
}
