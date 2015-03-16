package linkshare

import com.ttn.linkShare.DocumentResource
import com.ttn.linkShare.ReadingItem
import com.ttn.linkShare.Resource
import com.ttn.linkShare.Subscription
import com.ttn.linkShare.Topic
import com.ttn.linkShare.User
import com.ttn.linkShare.enums.Seriousness

class ApplicationTagLib {

    def tagService

    static defaultEncodeAs = 'raw'

    static namespace = "ls"

    def recentShare = { attrs ->
        out << render(template: "/login/recentShare", model: [resourceList: tagService.recentShare()])
    }

    def topPost = { attr ->
        out << render(template: "/login/topPost", model: [resourceList: tagService.topPost()])
    }

    def user = { attr ->
        out << render(template: "/user/userSubscripton", model: [userList: tagService.userSubscriptionByCurrentUserOrByTopic(attr.username,attr.topic)])
    }


    def subscriptionActions = { attr ->
        Topic topic = attr.topic
        User currentUser = User.findByUsername("${session['username']}")
        Boolean isAdminOrCreator = ((topic.user.equals(currentUser)) || currentUser.admin)
        Seriousness seriousness = topic?.subscriptions?.find { it.user == currentUser }?.seriousness
        out << render(template: "/topic/action", model: [topic: topic, isAdminOrCreator: isAdminOrCreator, seriousness: seriousness])

    }

    def isAdmin = { attr ->
        User user = User.findByUsername("${attr.username}")
        Boolean isadmin = user.admin
        out << render(template: "/admin/isAdmin", model: [isAdmin: isadmin])

    }
    def userSubscription = { attr ->
        User user = User.findByUsername("${session['username']}")
        println "in application tag library, uesr: ${user.username}"
        out << render(template: '/topic/subscription', model: [topicList: tagService.userTopicSubscribed(user.username)])
    }

    def inbox = { attr ->
        User user = User.findByUsername("${session['username']}")
        out << render(template: '/user/inbox', model: [resourceList: tagService.inbox(user)])
    }

    def resourceType = { attr ->
        DocumentResource isDocument = DocumentResource.findById(attr.type)
        out << render(template: '/user/isDocOrLink', model: [type: isDocument])
    }

    def markAsRead = { attr ->
        ReadingItem readingItem = ReadingItem.findByResourceAndIsRead(attr.type,true)
        out << render(template: '/user/isRead', model: [type:readingItem, resourceId: attr.type.id])
    }
    def subscriptionTopic = { attr ->
        out << render(template: '/topic/topicSubscription', model: [topicList: tagService.userTopicSubscribed("${session['username']}")])

    }
    def topicCreatedByUSer = { attr ->
        out << render(template: '/topic/topicSubscription', model: [topicList: tagService.topicCreatedByUser("${session['username']}")])

    }
    def trendingTopic = { attr ->
        out << render(template: '/topic/topicSubscription', model: [topicList: tagService.trendingTopic()])

    }
    def isSubscribed = { attr ->
        User user = User.findByUsername("${session['username']}")
        if (Topic.findByIdAndUser(attr.topic?.id, user) == null) {
            Boolean isSubscribe = Subscription.findByTopicAndUser(attr.topic, user) ? true : false
            out << render(template: '/topic/isSubscribed', model: [isSubscribed: isSubscribe, topicId: attr.topic.id])
        }
    }
    def displayResourcesOfTopic = { attr ->
        out << render(template: '/user/inbox', model: [resourceList: tagService.displayResourcesOfTopic(Topic.findByName(attr.topic))])
    }
//    def userList={attr->
//        out<<render(template: '/user/userInfo',model:[userList:tagService.userList("${session['username']}")])
//
//    }
   def subscribedTopicInAlphabeticalOrder={
       out<<render(template: '/topic/topicSubscription', model: [topicList: tagService.userTopicSubscribed("${session['username']}").sort{it.name}])
   }

}