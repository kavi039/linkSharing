package com.ttn.linkshare

import com.ttn.linkShare.LinkCO


class LinkResourceController {
     def linkResourceService
    def saveLink(LinkCO linkCO) {

       Boolean b= linkResourceService.save(linkCO,"${session['username']}")
        if(b)
        {
            flash.error="link resource added"
        }
        else
        {
            flash.error="link resource not added"
        }
       redirect(controller: 'user',action: 'dashBoard')
    }

}
