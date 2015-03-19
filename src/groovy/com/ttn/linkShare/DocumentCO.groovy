package com.ttn.linkShare

import grails.validation.Validateable
import org.springframework.web.multipart.MultipartFile

@Validateable
class DocumentCO {
    Long id
    Long topicId
    String description
    User user
    String filePath
    MultipartFile document
    static constraints={
        filePath nullable: false
        id nullable: true
    }

}
