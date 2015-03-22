package com.ttn.linkShare

import com.ttn.linkShare.enums.Visibility
import grails.transaction.Transactional

@Transactional
class TagService {

    def recentShare(int offset,int max) {
        List<Resource> resources = Resource.createCriteria().list(max:max,offset: offset) {
            'topic' {
                eq("visibility", Visibility.PUBLIC)
            }
            order("dateCreated", "desc")

        }
        println(">>>>>>>>>>>>>>>>>>>in tagservice${resources.totalCount}")
        return resources
    }

    def topPost(int offset,int max) {
        List<Resource> resources = Resource.createCriteria().list(max:max,offset: offset) {
            'topic' {
                eq("visibility", Visibility.PUBLIC)
            }
            'resourceRatings' {
                order("score", "desc")
            }

        }
        return resources

    }

    List<User> userSubscriptionByTopic(Topic topic,int offset,int max) {

            List<User>     userList = Subscription.createCriteria().list (max:max,offset: offset){
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
        return topicList.unique()
    }

    List<Resource> inbox(User user,int offset,int max) {
        List<Resource> resourceList = ReadingItem.createCriteria().list(max:max,offset: offset) {
            projections {
                property('resource')
            }
            eq('user', user)
            eq('isRead', false)

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

    def trendingTopic(int max,int offset) {
        List<Topic> topicList = []
        List<Object> objectList = Resource.createCriteria().list(max:max, offset:offset) {
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

    List<Resource> displayResourcesOfTopic(Topic topic) {
        List<Resource> resourceList = Resource.createCriteria().list(max: 2) {
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
        Integer subscriptionCount, topicCount = topicCreatedByUser(user.username).size()
        List<Topic> topicList = Subscription.createCriteria().list() {
            projections {
                property('topic')
            }
        }
        subscriptionCount = topicList.size()
        if (!status) {
            topicCount = topicCreatedByUser(user.username).findAll {
                it.visibility.equals(Visibility.PUBLIC)
            }.size()
            subscriptionCount = topicList.findAll {
                it.visibility.equals(Visibility.PUBLIC)
            }.size()

        }
        UserPublicProfile userPublicProfile = new UserPublicProfile(subscriptionCount: subscriptionCount, publicTopicCreated: topicCount, user: user)
        return userPublicProfile

    }

    List<Topic> publicTopicCreatedByUser(User user) {
        List<Topic> topicList = topicCreatedByUser(user.username)
        if (topicList) {
            topicList = topicList.findAll {
                it.visibility.equals(Visibility.PUBLIC)
            }
        }
        return topicList
    }

    List<Topic> userSubscribedTopicOrderByName(String username) {
        User user = User.findByUsername(username)
        List<Topic> topicList
        if (user.admin) {
            topicList = Topic.createCriteria().list {

                'subscriptions' {
                 projections{
                     distinct('topic')
                 }
                }

                order('name')
            }
        } else {
            topicList = Topic.createCriteria().list(max: 5, offset: 0) {

                'subscriptions' {
                    eq('user', user)

                }
                order('name')
            }
        }


        return topicList

    }

    def userSubscribedResourceList(String username) {
        User user = User.findByUsername(username)

        println "$user"
        List<Resource> resourceList
        if (user.admin) {
            resourceList = Resource.createCriteria().list {
                'topic' {
                    'subscriptions' {

                    }
                }
                order('dateCreated')
            }
        } else {
            resourceList = Resource.createCriteria().list(max: 5, offset: 0) {
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


}