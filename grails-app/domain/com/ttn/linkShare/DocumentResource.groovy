package com.ttn.linkShare

class DocumentResource extends Resource {

    String filePath

    static constraints = {
        filePath blank: false
    }

}
