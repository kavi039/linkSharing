package com.ttn.linkShare

import com.ttn.linkShare.enums.Visibility

class Topic {

    String name
    Visibility visibility
    Date dateCreated
    Date lastUpdated

    static hasMany = [subscriptions: Subscription, resources: Resource]
    static belongsTo = [user: User]

    static constraints = {
        name blank: false
        visibility blank: false
    }
}
