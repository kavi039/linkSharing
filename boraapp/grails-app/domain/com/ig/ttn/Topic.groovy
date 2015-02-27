package com.ig.ttn

import enums.Visibility


class Topic {
      String name
    Date dateCreated
    Date  dateUpdated

    Visibility visibility
    static constraints = {
        name blank: false,unique:true
        visibility blank:false

    }
static hasMany = [subsciptions:Subsciption,resources:Resource];
  static belongsTo = [createdBy:User]
}
