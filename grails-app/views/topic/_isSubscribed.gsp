<g:if test="${isSubscribed}">
<a class="subscription" data-topic-id="${topicId}">UnSubscribe</a>
    </g:if>
<g:else>
    <a class="subscription" data-topic-id="${topicId}">Subscribe</a>
    </g:else>