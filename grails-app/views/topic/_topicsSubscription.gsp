<g:if test="${topicList}">
    <g:each in="${topicList}" var="topic">

        <p>
            <a href="javascript:void(0)" class="topicToResource" data-topic-id="${topic.id}"
               data-topic-name="${topic.name}">
                ${topic?.name}(${topic?.visibility})
            </a>

        </p>

        <g:render template="../topic/display" model="[topic: topic]"/>

    </g:each>
    <util:remotePaginate controller="topic" action="topicList" update="topicListDiv" total="${total}" max="${max}"/>

</g:if>