package linkshare

import com.ttn.linkShare.DocumentResource
import com.ttn.linkShare.Resource
import com.ttn.linkShare.Subscription
import com.ttn.linkShare.Topic
import com.ttn.linkShare.User

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
        User currentUser = User.findByUsername(session['username'])
        Boolean isAdminOrCreator = ((topic.user == currentUser) || currentUser.admin)
        out << render(template: "/topic/action", model: [topic: topic, isAdminOrCreator: isAdminOrCreator])

    }

    def isAdmin = { attr ->
        User user = User.findByUsername(attr.username)
        Boolean isadmin = user.admin ? true : false
        out << render(template: "/admin/isAdmin", model: [isAdmin: isadmin])

    }

    def userSubscription = { attr ->
        User user = User.findByUsername(session['username'])
        println "in application tag library"
        out << render(template: '/topic/subscription', model: [topicList: tagService.userSubscribedTopic(user.username)])

    }
    def inbox = { attr ->
        User user = User.findByUsername(session['username'])
        out << render(template: '/user/inbox', model: [unreadResource: tagService.inbox(user)])

    }
    def resourceType = { attr ->
        DocumentResource isDocument = DocumentResource.findById(attr.type)
        out << render(template: '/user/isDocOrLink', model: [type: isDocument])
    }
    def markasRead={attr->
        Resource resource=Resource.findByIdAndIsRead(attr.type,true)
        out<<render(template: '/user/isRead',model: [type:resource])

    }

}