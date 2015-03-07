package com.ttn.linkShare

import com.ttn.linkShare.enums.Visibility
import grails.transaction.Transactional

@Transactional
class SearchService {

    def serviceMethod(String searchText, Boolean isUserLoggedIn) {
        List< Topic> topicList = isUserLoggedIn ? Topic.findAllByNameLike("%$searchText%") : Topic.findAllByNameLikeAndVisibility("%$searchText%", Visibility.PUBLIC)
        return topicList
    }

    def fetchAllResourceByNameLikeAndVisibility(String nameLike, Visibility visibility, Long max = 10, Long offset = 0) {
        List<Resource> resourceList
        if(visibility) {
            resourceList = Resource.createCriteria().list(max: max, offset: offset) {
                'topic' {
                    eq("visibility", visibility)
                }
                ilike("description", "%${nameLike}%")
            }
        } else {
            resourceList = Resource.findAllByDescriptionIlike("%${nameLike}%")
        }
        resourceList
    }
}
