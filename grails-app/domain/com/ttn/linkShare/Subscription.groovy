package com.ttn.linkShare

import com.ttn.linkShare.enums.Seriousness

class Subscription {

    User user
    Seriousness seriousness

    static constraints = {
        seriousness nullable: false
    }

    static belongsTo = [topic: Topic]

}
