package com.ig.ttn

class ReadingItem {
User user;
    Boolean isread;

    static constraints = {

    }
    static  belongsTo = [resource:Resource]
}
