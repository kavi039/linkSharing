package linkshare

import com.ttn.linkShare.DocumentResource
import com.ttn.linkShare.ReadingItem
import com.ttn.linkShare.Resource
import com.ttn.linkShare.Subscription
import com.ttn.linkShare.Topic
import com.ttn.linkShare.User
import com.ttn.linkShare.enums.Seriousness
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
        out << render(template: "/user/userSubscripton", model: [userList: tagService.userSubscriptionByCurrentUserOrByTopic(attr.username, attr.topic)])
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
        DocumentResource isDocument = DocumentResource.get(attr.type)
        out << render(template: '/user/isDocOrLink', model: [type: isDocument, resourceId: attr.type])
    }

    def markAsRead = { attr ->
        User user = User.findByUsername("${session['username']}")
        ReadingItem readingItem = ReadingItem.findByResourceAndIsReadAndUser(attr.type, true, user)
        out << render(template: '/user/isRead', model: [type: readingItem, resourceId: attr.type.id])
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
    def subscribedTopicInAlphabeticalOrder = { attr ->
        out << render(template: '/topic/topicSubscription', model: [topicList: tagService.userTopicSubscribed("${session['username']}").sort {
            it.name
        }])
    }
    def dateFormat = { attr ->
        out << attr.type?.format("hh:mm:ss dd/MM/yyyy")
    }
    def adminOrCreatorOfResource = { attr ->
        User user = User.findByUsername("${session['username']}")
        Resource resource = Resource.findByUserAndId(user, attr.resourceId)
        println("****************$resource")
        Boolean adminOrCreator = ((resource != null) || user.admin)
        out << render(template: '/resource/actionPerformed', model: [adminOrCreator: adminOrCreator, resource: resource])
    }
    def userPublicProfile = { attr ->
        Boolean status = false
        User user = User.get(attr.userId)
        if (user.username.equals("$session['username']") && user.admin) {
            status = true
        }

        out << render(template: '/user/profilePage', model: [userPublicProfileDTO: tagService.userPublicProfileInfo(user, status)])
    }
    def publicTopicCreatedByUser={attr->
        User user=User.get(attr.userId)
        List<Topic>topicList=tagService.topicCreatedByUser(user.username)
        if(topicList)
        {
            topicList=topicList.findAll{
                it.visibility.equals(Visibility.PUBLIC)
            }
        }
        out << render(template: '/topic/topicSubscription', model: [topicList:topicList])
    }
}