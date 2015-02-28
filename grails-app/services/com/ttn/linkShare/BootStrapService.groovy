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
        List<ReadingItem> readingItemList = createReadingItem(resourceList)
        readItem()
        createResourceRating()
    }

    List<User> createUsers() {
        List<User> users = []
        User user
        2.times {
            user = new User(username: "kavita${it}", email: "kavita${it}@gmail.com ", password: "1234", firstName: "kavita $it", lastName: "bora", admin: true, active: true, photo: "kavita${it}.jpeg")
//            user.confirmPassword = "1234"
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
                topic = new Topic(name: "${it}${user.id}Groovy", visibility: Visibility.PUBLIC, user: user.id)
                topic.save(failOnError: true)
                topics.add(topic)
                //  println user.id
            }
        }
        return topics
    }

    List<Subscription> createSubscription(List<Topic> topicList) {
        List<Subscription> subscriptions = []
        Subscription subscription
        topicList.each { Topic topic ->
            subscription = new Subscription(seriousness: Seriousness.VERYSERIOUS, topic: topic.id, user: topic.user.id)
            subscription.save()
            subscriptions.add(subscription)
        }
        return subscriptions
    }

    List<Resource> createResources(List<Topic> topicList) {
        List<Resource> resources = []
        List<DocumentResource> documentResources = []
        List<LinkResource> linkResources = []
        LinkResource linkResource
        DocumentResource documentResource
        topicList.each { Topic topic ->
            2.times {
                linkResource = new LinkResource(description: "linkResource is created  by user name${topic.user.username}", user: topic.user.id, topic: topic.id,
                        url: "http://www.contentquality.com/mynewtester/cynthia.exe?Url1=http://domain.tld/&rptmode=2")
                documentResource = new DocumentResource(description: "DocumentResource is createdby${topic.user.username}", user: topic.user.id, topic: topic.id, filePath: "/file/kavita/bora")
                linkResource.save(failOnError: true)
                documentResource.save(failOnError: true)
                linkResources.add(linkResource);
                documentResources.add(documentResource)
            }
        }
        return (resources << documentResources << linkResources)
    }

    List<ReadingItem> createReadingItem(List<Resource> resourceList) {
        List<ReadingItem> readingItems = []
        ReadingItem readItem
        resourceList.each {
            it.each {
                readItem = new ReadingItem(user: it.user.id, resource: it.id, isread: false)
                readItem.save()
                readingItems.add(readItem)
            }
        }
        return readingItems
    }

    void readItem() {
        List<Subscription> subscriptions = Subscription.getAll();
        List<Long> list = []
        subscriptions.each {
            list.add(it.user.id)
        }

        list = list.unique()
        list.each {
            List<ReadingItem> readingItems = ReadingItem.findAll("from ReadingItem  where user_id=$it  order by rand()", [max: 3])
            readingItems.each { ReadingItem readingItem ->
                readingItem.isread = true
                readingItem.save(flush: true)
            }
        }
    }

    void createResourceRating() {
        List<ReadingItem> readingItems = ReadingItem.findAllByIsread(true)

        readingItems.each { ReadingItem readingItem ->
            new ResourceRating(score: 21, user: readingItem.user.id, resource: readingItem.resource.id).save(failOnError: true)
        }
    }
}
