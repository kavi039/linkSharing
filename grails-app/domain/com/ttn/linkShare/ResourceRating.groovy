package com.ttn.linkShare

class ResourceRating {

    Integer score;

    User user

    static constraints = {
    }
    static belongsTo = [resourse: Resource]
    static   Float getScore(Resource resourceInstance) {
        Float score = createCriteria().get {
            projections {
                avg('score')
            }
            eq('resourse', resourceInstance)

        }
        return score
    }
}
