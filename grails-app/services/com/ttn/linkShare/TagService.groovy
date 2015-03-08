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
        List<Topic> topicLists = Topic.createCriteria().list(max: 5, offset: 0) {
            'subscriptions' {
                projections {
                    property('topic')
                }
                eq('user', user)
            }
            'resources' {
                order('dateCreated', 'desc')
            }
        }

        return topicLists
    }

    def userTopicSubscribed(String username) {
        User user = User.findByUsername(username)
        List<Topic> topicList = Subscription.createCriteria().list {
            projections {
                property('topic')
            }
            eq('user', user)
        }
        return topicList
    }

    List<Resource> inbox(User user) {
        List<Resource> resourceList = Resource.createCriteria().list(max: 5) {
            eq('isRead', false)
            eq('user', user)
        }
        resourceList
    }
}
