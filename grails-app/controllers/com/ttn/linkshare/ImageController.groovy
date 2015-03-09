package com.ttn.linkshare

import com.ttn.linkShare.User


class ImageController {

    def renderImage() {
        User user=User.get(params.getLong('id'))
        File photo=new File(user.photoPath)
       response.setHeader("Content-disposition", "attachment; filename=${photo.name}")
        response.setContentType("application/png")
        response.outputStream << photo.bytes
        response.outputStream.flush()


    }

}
