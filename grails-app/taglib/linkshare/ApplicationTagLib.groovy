package linkshare

import com.ttn.linkShare.Resource
import com.ttn.linkShare.Subscription
import com.ttn.linkShare.Topic
import com.ttn.linkShare.User
import com.ttn.linkShare.enums.Visibility

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

}
