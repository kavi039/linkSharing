package linkshare

import com.ttn.linkShare.DocumentResource
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
        out << render(template: "/user/userSubscripton", model: [userInfo: tagService.userSubscription(session['username'])])
    }

    def subscriptionCount = { attr ->
        Topic topic = attr.topic
        out << Subscription.countByTopic(topic)
    }

    def postCount = { attr ->
        Topic topic = attr.topic
        out << Resource.countByTopic(topic)
    }

    def subscriptionActions = { attr ->
        Topic topic = attr.topic
        User currentUser = User.findByUsername("${session['username']}")
        Boolean isAdminOrCreator = ((topic.user == currentUser) || currentUser.admin)
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
        out << render(template: '/topic/subscription', model: [topicList: tagService.userSubscribedTopic(user.username)])
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
        Resource resource = Resource.findByIdAndIsRead(attr.type, true)
        out << render(template: '/user/isRead', model: [type: resource,resourceId:attr.type])
    }
    def subscriptionTopic = { attr ->
        out << render(template: '/topic/topicSubscription', model: [topicList: tagService.userTopicSubscribed("${session['username']}")])

    }
    def topicCreatedByUSer={attr->
        out<< render(template: '/topic/topicSubscription', model: [topicList: tagService.topicCreatedByUser("${session['username']}")])

    }

}