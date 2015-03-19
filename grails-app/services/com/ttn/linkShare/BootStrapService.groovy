package com.ttn.linkShare

import com.ttn.linkShare.enums.Seriousness
import com.ttn.linkShare.enums.Visibility
import grails.transaction.Transactional

@Transactional
class BootStrapService {

    def bootStrap() {
        List<User> userList = createUsers();
        List<Topic> topicList = createTopic(userList);
        List<Subscription> subscriptionList = createSubscription(topicList)
        List<Resource> resourceList = createResources(topicList);
        List<ReadingItem> readingItemList = readingItem(resourceList)
        ratingScore(readingItemList)

    }

    List<User> createUsers() {
        List<User> users = []
        User user
        2.times {
            user = new User(username: "kavita${it}", email: "kavita${it}@gmail.com ", password: "1234", firstName: "kavita $it", lastName: "bora", admin: (it % 2 == 0 ), active:true , photoPath: "kavita${it}.jpeg")
            if (user.save(failOnError: true)) {
                users.add(user)
            } else {
                println "not created"
            }
        }
        return users
    }

    List<Topic> createTopic(List<User> userList) {
        List<Topic> topics = []
        Topic topic
        userList.each { User user ->
            5.times {
                topic = new Topic(name: "${it}${user.id}Groovy", visibility: (it % 2 ? Visibility.PRIVATE : Visibility.PUBLIC), user: user)
                topic.save(failOnError: true)
                topics.add(topic)
                //  println user.id
            }
        }
        return topics
    }

    List<Subscription> createSubscription(List<Topic> topicList) {
        List<Subscription> subscriptions = []
        int i = 0;
        Subscription subscription
        topicList.each { Topic topic ->
            subscription = new Subscription(seriousness: (i % 2 == 0 ? Seriousness.VERYSERIOUS : Seriousness.CASUAL), topic: topic, user: topic.user)
            i++
            subscription.save()
            subscriptions.add(subscription)
        }
        return subscriptions
    }

    List<Resource> createResources(List<Topic> topicList) {
        List<Resource> resources = []
        List<DocumentResource> documentResources = []
        List<LinkResource> linkResources = []
        Resource linkResource
        DocumentResource documentResource
        int i = 0
        topicList.each { Topic topic ->
            2.times {
                linkResource = new LinkResource(description: "linkResource is created  by user name${topic.user.username}", user: topic.user, topic: topic,
                        url: "http://www.contentquality.com/mynewtester/cynthia.exe?Url1=http://domain.tld/&rptmode=2")
                linkResource.save(failOnError: true)
                documentResource = new DocumentResource(description: "DocumentResource is createdby${topic.user.username}", user: topic.user, topic: topic, filePath: "/file/kavita/bora")
                documentResource.save(failOnError: true)
                linkResources.add(linkResource);
                documentResources.add(documentResource)
            }
        }
        return (resources << documentResources << linkResources)
    }

    List<ReadingItem> readingItem(List<Resource> resourceList) {
        int i = 0
        List<ReadingItem> readingItemList = []
        resourceList.each {resourceType->
            resourceType.each {
            ReadingItem readingItem = new ReadingItem(resource: it, isRead: (i % 2 == 0), user: it.user)
            readingItem.save(flush: true)
            readingItemList.add(readingItem)
            i++
        }}
        return readingItemList
    }

    void ratingScore(List<ReadingItem> readingItemList) {
        readingItemList.each {
            ResourceRating resourceRating = new ResourceRating(resourse: it.resource, score:1, user: it.user)
            resourceRating.save(flush: true)

        }
    }

}