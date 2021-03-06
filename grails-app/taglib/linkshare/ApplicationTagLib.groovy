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

    def tagService, userService, searchService, grailsApplication

    static defaultEncodeAs = 'raw'

    static namespace = "ls"

    def recentShare = { attrs ->
        List<Resource> resourceList = tagService.recentShare(grailsApplication.config.offset, grailsApplication.config.max1)
        out << render(template: "/login/recentShare", model: [resourceList: resourceList, total: resourceList.totalCount, max: grailsApplication.config.max1])
    }

    def topPost = { attr ->
        List<Object> objectList = tagService.topPost(grailsApplication.config.offset, grailsApplication.config.max1)
        List<Resource> resourceList = objectList.collect() { it[0] }
        out << render(template: "/login/topPost", model: [resourceList: resourceList, total: objectList.totalCount, max: grailsApplication.config.max1])
    }

    def user = { attr ->
        out << render(template: "/user/userSubscripton", model: [userInfo: User.findByUsername("${session['username']}")])
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
        List<Resource> resourceList = tagService.inbox(user, grailsApplication.config.offset, grailsApplication.config.max1)
        out << render(template: '/user/inbox', model: [resourceList: resourceList, total: resourceList.totalCount, max: grailsApplication.config.max1])
    }

    def resourceType = { attr ->
        DocumentResource isDocument = DocumentResource.findById(attr.type)
        // println "************$isDocument"
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
        List<Topic> topicList = tagService.topicCreatedByUser("${session['username']}", grailsApplication.config.offset, grailsApplication.config.max2)
        out << render(template: '/topic/topicCreatedByUser', model: [topicList: topicList, total: topicList.totalCount, max: grailsApplication.config.max2])
    }
    def trendingTopic = { attr ->
        List<Topic> topicList = []
        List<Object> objectList = tagService.trendingTopic(grailsApplication.config.max1, grailsApplication.config.offset)
        objectList.collect(topicList) {
            it[0]
        }
        out << render(template: '/topic/trendingTopicDisplay', model: [topicList: topicList, total: objectList.totalCount, max: grailsApplication.config.max1])

    }
    def isSubscribed = { attr ->
        User user = User.findByUsername("${session['username']}")
        if (Topic.findByIdAndUser(attr.topic?.id, user) == null) {
            Boolean isSubscribe = Subscription.findByTopicAndUser(attr.topic, user) ? true : false
            out << render(template: '/topic/isSubscribed', model: [isSubscribed: isSubscribe, topicId: attr.topic.id])
        }
    }
    def displayResourcesOfTopic = { attr ->
        List<Resource> resourceList = tagService.displayResourcesOfTopic(attr.topic, grailsApplication.config.offset, grailsApplication.config.max2)
        out << render(template: '/topic/displayResourcesOfTopic', model: [resourceList: resourceList, total: resourceList.totalCount, max: grailsApplication.config.max2, topicId: attr.topic.id])
    }
    def subscribedTopicInAlphabeticalOrder = { attr ->
        List<Topic> topicList = tagService.userSubscribedTopicOrderByName("${session['username']}", grailsApplication.config.offset, grailsApplication.config.max2)
        out << render(template: '/topic/topicsSubscription', model: [topicList: topicList, total: topicList.totalCount], max: grailsApplication.config.max2)
    }
    def dateFormat = { attr ->
        Date date = attr.type
        out << attr.type?.format("dd/MM/yyyy")
    }
    def adminOrCreatorOfResource = { attr ->
        User user = User.findByUsername("${session['username']}")
        Resource resource = Resource.findByUserAndId(user, attr.resourceId)
        Boolean adminOrCreator = ((resource != null) || user.admin)
        out << render(template: '/resource/actionPerformed', model: [adminOrCreator: adminOrCreator, resource: resource])
    }
    def userPublicProfile = { attr ->
        Boolean status = false
        User user = User.get(attr.userId)
        if (User.findByUsername("${session['username']}")?.admin) {
            status = true
        }

        out << render(template: '/user/profilePage', model: [userPublicProfileDTO: tagService.userPublicProfileInfo(user, status)])
    }
    def publicTopicCreatedByUser = { attr ->
        User user = User.get(attr.userId)
        List<Topic> topicList = tagService.publicTopicCreatedByUser(user, grailsApplication.config.offset, grailsApplication.config.max1)
        out << render(template: '/topic/publicTopicCreatedByUser', model: [topicList: topicList, total: topicList.totalCount, max: grailsApplication.config.max1, userId: user.id])
    }
    def publicPost = { attr ->
        User user = User.get(attr.userId)
        List<Resource> resourceList = tagService.publicResourcesOfTopicCreatedByUser(user, grailsApplication.config.offset, grailsApplication.config.max1)
        out << render(template: '/user/publicPost', model: [resourceList: resourceList, total: resourceList.totalCount, max: grailsApplication.config.max1, userId: attr.userId])
    }
    def topicSubscribedPost = { attr ->
        List<Resource> resourceList = tagService.userSubscribedResourceList("${session['username']}", grailsApplication.config.offset, grailsApplication.config.max2)
        out << render(template: '/topic/topicSubscribedPost', model: [resourceList: resourceList, total: resourceList.totalCount, max: grailsApplication.config.max2])


    }
    def userList = { attr ->
        List<User> userList = tagService.userSubscriptionByTopic(attr.topic, grailsApplication.config.offset, grailsApplication.config.max1)
        out << render(template: "/user/userSubscriptionList", model: [userList: userList, total: userList.totalCount, max: grailsApplication.config.max1, topicId: attr.topic.id])
    }
    def listOfUser = { attr ->
        List<User> userList = userService.listOfUser(grailsApplication.config.offset, grailsApplication.config.max2)
        out << render(template: "/user/userInfo", model: [userList: userList, total: userList.totalCount, max: grailsApplication.config.max2])

    }
    def searchResult = { attr ->
        Visibility visibility = Visibility.PUBLIC
        List<Resource> resourceList = searchService.fetchAllResourceByNameLikeAndVisibility(attr.text, visibility, params?.max ?: grailsApplication.config.max1, params?.offset ?: grailsApplication.config.offset)
        out << render(template: "/search/searchResult", model: [resourceList: resourceList, total: resourceList.totalCount, searchText: attr.text])
    }

}
