package com.ttn.linkShare

import grails.validation.Validateable
import org.springframework.web.multipart.MultipartFile

@Validateable
class DocumentCO {
    String name
    String description
    User user
    Boolean isRead
    Integer score
    String filePath
    Topic topic
    MultipartFile document
    static constraints={
        filePath nullable: false
    }

}
