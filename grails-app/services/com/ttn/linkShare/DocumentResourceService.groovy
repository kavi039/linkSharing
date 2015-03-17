package com.ttn.linkShare

import grails.transaction.Transactional
import org.springframework.web.multipart.MultipartFile

@Transactional
class DocumentResourceService {

    def save(DocumentCO documentCO,String username) {
        File newFile = null
        MultipartFile file = documentCO.document
        String name = file.getOriginalFilename()
        documentCO.user =User.findByUsername(username)
        documentCO.topic = Topic.findByNameAndUser(documentCO.name,documentCO.user)
        if (name) {
        File    newFileDir = new File("/home/intelligrape/Project/Document/${documentCO.user.username}")
            newFileDir.mkdirs()
            newFile=new File("$newFileDir/$name")
            println(newFile)
            newFile.createNewFile()
            file.transferTo(newFile)
        }
        documentCO.filePath = newFile?.canonicalFile
        println ">>>>>>>>>>>>>>>>>>>>>>>>.${name}"
        if (documentCO.validate()) {
            DocumentResource documentResource = new DocumentResource(documentCO.properties)
            ReadingItem readingItem=new ReadingItem(resource:documentResource,isRead: false,user:documentCO.user)
            (documentResource.save(failOnError: true)!=null)&&(readingItem.save(flush:true)!=null)
        }
        else
        {
            return false
        }

    }
}

