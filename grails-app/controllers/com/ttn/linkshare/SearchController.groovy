package com.ttn.linkshare

import com.ttn.linkShare.Resource
import com.ttn.linkShare.enums.Visibility

class SearchController {

    def searchService

    def search(String searchText) {
        Visibility visibility = session.getAttribute("username") ? null : Visibility.PUBLIC
        List<Resource> resourceList = searchService.fetchAllResourceByNameLikeAndVisibility(searchText, visibility, params?.max ?: 10, params?.offset ?: 0)
        render view: "search", model: [resourceList: resourceList]
    }
}
