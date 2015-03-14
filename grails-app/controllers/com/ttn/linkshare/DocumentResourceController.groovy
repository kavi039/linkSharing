package com.ttn.linkshare

import com.ttn.linkShare.DocumentCO

class DocumentResourceController {
    def documentResourceService

    def saveDocument(DocumentCO documentCO) {
     Boolean b= documentResourceService.save(documentCO,"${session['username']}")
        if(b)
        {
            flash.message="document added"
        }
        else
        {
            flash.error="document not added"
        }
        redirect(controller: 'user',action: 'dashBoard')
    }

}
