package linkshare

import com.ttn.linkShare.Resource
import com.ttn.linkShare.Topic
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
}
