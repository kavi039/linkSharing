<g:if test="${topicList}">
    <g:each in="${topicList}" var="topic">
        <g:render template="../topic/display" model="[topic: topic]"/>
    </g:each>

</g:if>