package com.ig.ttn

import enums.Seriousness

class Subsciption {
    User user;
    Date dateCreated;
    Seriousness seriousness;
    static constraints = {
   seriousness nullable:false
    }
    static belongsTo = [topic:Topic];
}
