package com.ttn.linkShare

import com.ttn.linkShare.enums.Visibility
import grails.transaction.Transactional

@Transactional
class SearchService {
    def tagService

    def serviceMethod(String searchText, Boolean isUserLoggedIn) {
        List<Topic> topicList = isUserLoggedIn ? Topic.findAllByNameLike("%$searchText%") : Topic.findAllByNameLikeAndVisibility("%$searchText%", Visibility.PUBLIC)
        return topicList
    }

    def fetchAllResourceByNameLikeAndVisibility(String nameLike, Visibility visibility, int max, int offset) {
        List<Resource> resourceList=[]
        resourceList = Resource.createCriteria().list(max: max, offset: offset) {
            'topic' {
                eq("visibility", visibility)
                ilike("name", "%${nameLike}%")
            }
        }
       if (!resourceList) {
            resourceList = Resource.createCriteria().list(max: max, offset: offset) {
                'topic' {
                    eq("visibility", visibility)
                }
                ilike("description", "%${nameLike}%")
            }
       }
        resourceList
    }

    List<Topic> topicListByName(String name, String username) {
        println "name: $name"
        println "name: $name"
        println "name: $name"
        println "name: $name"
        List<Topic> topicList = tagService.userTopicSubscribed(username)
        println topicList*.name
        topicList.findAll {
            it?.name?.contains(name)
        }
    }

}
