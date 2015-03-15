package com.ttn.linkshare

import com.ttn.linkShare.Resource
import com.ttn.linkShare.Topic
import com.ttn.linkShare.User
import com.ttn.linkShare.enums.Visibility

class SearchController {

    def searchService

    def search(String searchText) {
        Visibility visibility = session.getAttribute("username") ? null : Visibility.PUBLIC
        List<Resource> resourceList = searchService.fetchAllResourceByNameLikeAndVisibility(searchText, visibility, params?.max ?: 10, params?.offset ?: 0)
        render view: "search", model: [resourceList: resourceList]
    }

    def topicListByName(String name) {
        List<Topic> topicList = searchService.topicListByName(name, session['username'])
        render template: '../topic/topicSubscription', model: [topicList: topicList]
    }

    def findUserList(String userStatus, String searchByName,String arrange) {
        arrange=arrange.trim()
        if(arrange.equals("Manage"))
        {
            arrange="id"
        }
        List<User> userList
        if (userStatus.equals('Alluser')) {
            userList = searchByName ? User.findAllByUsernameIlike("%${searchByName}%",[sort:arrange]) : User.list(sort:arrange)
        } else {
            Boolean b = userStatus.equals('Active')
            userList = searchByName ? User.findAllByActiveAndUsernameIlike(b, "%${searchByName}%",[sort:arrange]) : User.findAllByActive(b,[sort:arrange])
        }

        println "*"
        println "*"
        println "*"
        println "*"
        println "*"
        println "*"
        println userList*.username
        render template: "/user/userInfo", model: [userList: userList]
    }

}
