<g:if test="${topicList}">
    <g:each in="${topicList}" var="topic">
        <g:render template="../topic/display" model="[topic: topic]"/>
    </g:each>
    <util:remotePaginate controller="topic" action="topicCreatedByUser" update="dataDiv" total="${total}" max="${max}"/>
</g:if>