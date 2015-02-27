package com.ttn.linkShare

class ReadingItem {

    User user
    Boolean isread

    static belongsTo = [resource: Resource]
}
