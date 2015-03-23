package com.ttn.linkshare

import com.ttn.linkShare.Resource
import com.ttn.linkShare.Topic
import com.ttn.linkShare.User
import com.ttn.linkShare.enums.Visibility

class SearchController {
    def searchService

    def searchPaginationOntext() {
        String searchText = params.searchText
        println ">>>>>>>>>>>>>>$searchText in search ch"
        Visibility visibility = Visibility.PUBLIC
        List<Resource> resourceList = searchService.fetchAllResourceByNameLikeAndVisibility(searchText, visibility, params?.int("max") ?: 5, params?.int("offset") ?: 0)
        render(template: "/search/searchResult", model: [resourceList: resourceList, total: resourceList.totalCount, searchText: searchText])
    }

    def search(String searchText) {
        println ">>>>>>>>>>>>>>$searchText"
        render(view: "/search/search", model: [searchText: searchText])
    }

    def topicListByName(String name) {
        List<Topic> topicList = searchService.topicListByName(name, "" + session['username'])
        render template: '../topic/topicSubscription', model: [topicList: topicList]
    }

    def findUserList(String userStatus, String searchByName, String arrange) {
        arrange = arrange.trim()
        if (arrange.equals("Manage")) {
            arrange = "id"
        }
        List<User> userList
        if (userStatus.equals('Alluser')) {
            userList = searchByName ? User.findAllByUsernameIlike("%${searchByName}%", [sort: arrange]) : User.list(sort: arrange)
        } else {
            Boolean b = userStatus.equals('Active')
            userList = searchByName ? User.findAllByActiveAndUsernameIlike(b, "%${searchByName}%", [sort: arrange]) : User.findAllByActive(b, [sort: arrange])
        }
        render template: "/user/userInfo", model: [userList: userList, total: User.count, max: 10]
    }

    def resourceListByTopicName(Long topicId) {
        List<Resource> resourceList = Resource.findAllByTopic(Topic.get(topicId))
        render(template: '/topic/topicSubscribedPost', model: [resourceList: resourceList, total: resourceList.size()])
    }

}
