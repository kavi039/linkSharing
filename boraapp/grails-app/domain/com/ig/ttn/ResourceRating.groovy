package com.ig.ttn

class ResourceRating {
    Integer score;
    User user;
    static constraints = {

        score blank:false }
static belongsTo = [resourse:Resource]
}
