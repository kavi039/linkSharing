<g:if test="${isSubscribed}">
<a class="subscription" data-topic-id="${topicId}">UnSubscribed</a>
    </g:if>
<g:else>
    <a class="subscription" data-topic-id="${topicId}">Subscribed</a>
    </g:else>