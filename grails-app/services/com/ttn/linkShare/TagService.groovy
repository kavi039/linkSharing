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

    def userSubscriptionByCurrentUserOrByTopic(String username, String topicName) {
        List<User> userList = []
        if (username) {
            userList = User.findAllByUsername(username)
        } else {
            Topic topic = Topic.findByName(topicName)
            userList = Subscription.createCriteria().list(max: 5) {
                projections {
                    property('user')
                }
                eq('topic', topic)
            }


        }
        println userList
        return userList
    }


    def userTopicSubscribed(String username) {
        User user = User.findByUsername(username)
        List<Topic> topicList = Subscription.createCriteria().list(max: 2, offset: 0) {
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

    List<Topic> topicCreatedByUser(String username) {
        User user = User.findByUsername(username)
        List<Topic> topicList = Topic.createCriteria().list(max: 4, offset: 0) {
            eq('user', user)
            order("dateCreated", 'desc')
        }
        return topicList
    }

    def trendingTopic() {
        List<Topic> topicList = []
        List<Object> objectList = Resource.createCriteria().list(max: 5, offset: 0) {
            projections {
                groupProperty("topic")
                count("topic", "topicCount")

            }
            'topic' {
                eq('visibility', Visibility.PUBLIC)
            }
            order("topicCount", "desc")
        }
        objectList.collect(topicList) {
            it[0]
        }
        return topicList
    }

    List<Resource> displayResourcesOfTopic(Topic topic) {
        List<Resource> resourceList = Resource.createCriteria().list(max: 2) {
            eq('topic', topic)
            eq('isRead', false)
        }
        return resourceList
    }

}