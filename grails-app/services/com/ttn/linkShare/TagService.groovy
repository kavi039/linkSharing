package com.ttn.linkShare

import com.ttn.linkShare.enums.Visibility
import grails.transaction.Transactional

@Transactional
class TagService {

    def recentShare(int offset, int max) {
        List<Resource> resources = Resource.createCriteria().list(max: max, offset: offset) {
            'topic' {
                eq("visibility", Visibility.PUBLIC)
            }
            order("dateCreated", "desc")

        }
        return resources
    }

    def topPost(int offset, int max) {
        List<Object> object = ResourceRating.createCriteria().list(max: max, offset: offset) {
            projections {
                groupProperty("resourse")
                avg("score", "scoreShorting")
            }
            "resourse" {
                "topic" {
                    eq("visibility", Visibility.PUBLIC)
                }

            }
            order("scoreShorting", "desc")

        }
        return object

    }

    List<User> userSubscriptionByTopic(Topic topic, int offset, int max) {

        List<User> userList = Subscription.createCriteria().list(max: max, offset: offset) {
            projections {
                property('user')
            }
            eq('topic', topic)
        }
        return userList


    }


    def userTopicSubscribed(String username) {
        User user = User.findByUsername(username)
        List<Topic> topicList
        if (!user.admin) {

            topicList = Subscription.createCriteria().list() {
                projections {
                    property('topic')
                }
                'topic' {
                    'resources' {
                        order('dateCreated', 'desc')
                    }
                }
                eq('user', user)
            }
        } else {
            topicList = Subscription.createCriteria().list() {
                projections {
                    property('topic')
                }
                'topic' {
                    'resources' {
                        order('dateCreated', 'desc')
                    }
                }
            }
        }
        topicList = topicList.unique()
        if (topicList.size() > 5)
            return topicList.subList(0, 5)
        else
            return topicList
    }

    List<Resource> inbox(User user, int offset, int max) {
        List<Resource> resourceList = ReadingItem.createCriteria().list(max: max, offset: offset) {
            projections {
                property('resource')
            }
            eq('user', user)
            eq('isRead', false)

        }
        resourceList
    }

    List<Topic> topicCreatedByUser(String username, int offset, int max) {
        User user = User.findByUsername(username)
        List<Topic> topicList = Topic.createCriteria().list(max: max, offset: offset) {
            eq('user', user)
            order("dateCreated", 'desc')
        }
        return topicList
    }

    def trendingTopic(int max, int offset) {
        List<Topic> topicList = []
        List<Object> objectList = Resource.createCriteria().list(max: max, offset: offset) {
            projections {
                groupProperty("topic")
                count("topic", "topicCount")

            }
            'topic' {
                eq('visibility', Visibility.PUBLIC)
            }
            order("topicCount", "desc")
        }

        return objectList
    }

    List<Resource> displayResourcesOfTopic(Topic topic, int offset, int max) {
        List<Resource> resourceList = Resource.createCriteria().list(max: max, offset: offset) {
            eq('topic', topic)
        }
        return resourceList
    }

    Float getScore(Resource resourceInstance) {
        Float score = ResourceRating.createCriteria().get {
            projections {
                avg('score')
            }
            eq('resourse', resourceInstance)

        }
        return score
    }

    def userPublicProfileInfo(User user, Boolean status) {
        Integer subscriptionCount, topicCount = Topic.findAllByUser(user).size()
        List<Topic> topicList = Subscription.createCriteria().list() {
            projections {
                property('topic')
            }
             eq('user',user)
        }
        subscriptionCount = topicList.size()-1
        if (!status) {
            topicCount = Topic.findAllByUserAndVisibility(user, Visibility.PUBLIC).size()
            subscriptionCount = topicList.findAll {
                it.visibility.equals(Visibility.PUBLIC)
            }.size()-1

        }
        UserPublicProfile userPublicProfile = new UserPublicProfile(subscriptionCount: subscriptionCount, publicTopicCreated: topicCount, user: user)
        return userPublicProfile

    }

    List<Topic> publicTopicCreatedByUser(User user, int offset, int max) {
        List<Topic> topicList = Topic.createCriteria().list(max: max, offset: offset) {
            eq('user', user)
            eq('visibility', Visibility.PUBLIC)
        }
        return topicList
    }

    List<Topic> userSubscribedTopicOrderByName(String username, int offset, int max) {
        User user = User.findByUsername(username)
        List<Topic> topicList
        if (user.admin) {
            topicList = Topic.createCriteria().list(max: max, offset: offset) {

                'subscriptions' {
                    projections {
                        distinct('topic')
                    }
                }

                order('name')
            }
        } else {
            topicList = Topic.createCriteria().list(max: max, offset: offset) {

                'subscriptions' {
                    eq('user', user)

                }
                order('name')
            }
        }


        return topicList

    }

    def userSubscribedResourceList(String username, int offset, int max) {
        User user = User.findByUsername(username)

        println "$user"
        List<Resource> resourceList
        if (user.admin) {
            resourceList = Resource.createCriteria().list(max: max, offset: offset) {
                'topic' {
                    'subscriptions' {

                    }
                }
                order('dateCreated')
            }
        } else {
            resourceList = Resource.createCriteria().list(max: max, offset: offset) {
                'topic' {
                    'subscriptions' {
                        eq('user', user)
                    }
                }
                order('dateCreated')
            }
        }

        return resourceList
    }

    List<Resource> publicResourcesOfTopicCreatedByUser(User user, int offset, int max) {
        List<Resource> resourceList = Resource.createCriteria().list(offset: offset, max: max) {
            'topic' {
                eq('user', user)
                eq('visibility', Visibility.PUBLIC)
            }
        }
        return resourceList
    }


}