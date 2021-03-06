<div class="media">
    <div class="media-left">
        <a href="${createLink(controller: 'user', action: 'user', params: [id: topic?.user?.id])}"><img
                src="${createLink(controller: 'image', action: 'renderImage', params: [id: topic?.user?.id])}"
                height="100px"
                width="100px"/></a>
    </div>

    <div class="media-body">
        <h4 class="media-heading"><a
                href="${createLink(controller: 'topic', action: 'topicShow', params: [topicName: topic?.id])}"
                title="click here to show topic"   class="editable" data-topic-name="${topic.name}">${topic?.name}</a>
        </h4>
        <span>@${topic?.user?.firstName?.toLowerCase()}</span>
        <g:if test="${session['username']}">
            <span style="float: right"><ls:isSubscribed topic="${topic}"/></span>
        </g:if>

        <div class="col-md-12">
            <div class="col-md-6">
                <p>Subscription</p>

                <div class="subscriptionCount">
                    ${com.ttn.linkShare.Subscription?.countByTopic(topic)}
                </div>
            </div>

            <div class="col-md-6">
                <p>Post</p>
                ${topic?.resources?.size()}

            </div>
        </div>
        <g:if test="${session['username']}">
            <div style="float: right"><ls:subscriptionActions topic="${topic}"/></div>
        </g:if>

    </div>
</div>
<hr>































