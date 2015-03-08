package com.ttn.linkShare

import grails.transaction.Transactional
import org.springframework.web.multipart.MultipartFile

@Transactional
class DocumentResourceService {

    def save(DocumentCO documentCO,String username) {
        File newFile = null
        MultipartFile file = documentCO.document
        String name = file.getOriginalFilename()
        documentCO.topic = Topic.findByName(documentCO.name)
        documentCO.user =User.findByUsername(username)
        if (name) {
        File    newFileDir = new File("/home/intelligrape/Project/Document/${documentCO.user.username}")
            newFileDir.mkdirs()
            newFile=new File("$newFileDir/$name")
            println(newFile)
            newFile.createNewFile()
            file.transferTo(newFile)
        }
        documentCO.filePath = newFile?.canonicalFile
        documentCO.isRead = true
        println ">>>>>>>>>>>>>>>>>>>>>>>>.${name}"
        if (documentCO.validate()) {
            DocumentResource documentResource = new DocumentResource(documentCO.properties)
            return documentResource.save(failOnError: true)
        }
        else
        {
            return false
        }

    }
}

