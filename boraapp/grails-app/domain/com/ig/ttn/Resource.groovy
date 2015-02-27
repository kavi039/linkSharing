package com.ig.ttn

abstract class Resource {
  String discription;
    Date datecreated;
    Date lastUpdated;
    User user;
    static constraints = {
        discription nullable:true

    }
    static  hasMany = [readingItems:ReadingItem]
    static belongsTo = [topic:Topic]



}
