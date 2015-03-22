<g:if test="${topicList}">
    <g:each in="${topicList}" var="topic">
        <g:render template="../topic/display" model="[topic: topic]"/>
    </g:each>
    <util:remotePaginate controller="topic" action="publicTopicCreatedByUser" update="topicListDiv" total="${total}"
                         max="${max}" params="[userId: userId]"/>
</g:if>