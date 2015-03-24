package com.ttn.linkshare

import com.ttn.linkShare.Resource
import com.ttn.linkShare.Topic
import com.ttn.linkShare.User
import com.ttn.linkShare.enums.Visibility

class SearchController {
    def searchService, tagService

    List<Resource> searchPaginationOnText() {
        String searchText = params.searchText
        Visibility visibility = Visibility.PUBLIC
        List<Resource> resourceList = searchService.fetchAllResourceByNameLikeAndVisibility(searchText, visibility, params?.int("max") ?: 5, params?.int("offset") ?: 0)
        render(template: "/search/searchResult", model: [resourceList: resourceList, total: resourceList.totalCount, searchText: searchText])
    }

    def search(String searchText) {
        render(view: "/search/search", model: [searchText: searchText])
    }

    List<Topic> topicListByName(String name) {
        List<Topic> topicList = searchService.topicListByName(name, "" + session['username'])
        render template: '../topic/topicSubscription', model: [topicList: topicList]
    }

    List<User> findUserList(String userStatus, String searchByName, String arrange) {
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

    List<Resource> resourceListByTopicName(Long topicId) {
        List<Resource> resourceList = Resource.findAllByTopic(Topic.get(topicId))
        render(template: '/topic/topicSubscribedPost', model: [resourceList: resourceList, total: resourceList.size()])
    }

    List<Resource> searchTopPostByDateCreated(String dateOnWhichData) {
        Date date = new Date()
        if (dateOnWhichData.equals("1week"))
            date = date - 7
        else if (dateOnWhichData.equals(" 1month"))
            date = date - 30
        else
            date = date - 365
//        List<Object> objectList = tagService.topPost(0, 5,new Date())
//        List<Resource> resourceList = objectList.collect() { it[0] }
       // out << render(template: "/login/topPost", model: [resourceList: resourceList, total: objectList.totalCount, max: 5])

        //render d
    }

    def index() {

    }


}
