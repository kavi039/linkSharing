<g:if test="${topicList}">
<g:each in="${topicList}" var="topic">
    <div class="panel-body">
        <p>
            <a href="javascript:void(0)" class="topicToResource" data-topic-id="${topic.id}" data-topic-name="${topic.name}">
                ${topic?.name}(${topic?.visibility})
            </a>

        </p>

        <g:render template="../topic/display" model="[topic: topic]"/>

    </div>
</g:each>
</g:if>