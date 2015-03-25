package com.ttn.linkShare

import grails.transaction.Transactional
import org.springframework.web.multipart.MultipartFile

@Transactional
class DocumentResourceService {
    def grailsApplication

    def save(DocumentCO documentCO, String username) {
        DocumentResource documentResource
        ReadingItem readingItem
        File newFile = null
        MultipartFile file = documentCO.document
        String name = file.getOriginalFilename()
        documentCO.user = User.findByUsername(username)
        if (name) {
            String filePath = grailsApplication.config.documentFolderPath + documentCO.user.username
            File newFileDir = new File(filePath)
            newFileDir.mkdirs()
            newFile = new File("$newFileDir/$name")
            println(newFile)
            newFile.createNewFile()
            file.transferTo(newFile)
        }
        documentCO.filePath = newFile?.canonicalFile
        if (documentCO.validate()) {
            if (documentCO.id != null) {
                documentResource = DocumentResource.get(documentCO.id)
                documentResource.properties = [description: documentCO.description, user: documentCO.user, topic: documentResource.topic, filePath: documentCO.filePath]
                readingItem = ReadingItem.findOrCreateByResourceAndUser(documentResource, documentCO.user)
                readingItem.properties = [isRead: false]
            } else {
                Topic topic = Topic.get(documentCO.topicId)
                documentResource = new DocumentResource(description: documentCO.description, user: documentCO.user, topic: topic, filePath: documentCO.filePath)
                readingItem = new ReadingItem(resource: documentResource, isRead: false, user: documentCO.user)
            }
            (documentResource.save(failOnError: true) != null) && (readingItem.save(flush: true) != null)
        } else {
            documentCO.errors.allErrors.each {
                println it
            }
            return false
        }

    }
}

