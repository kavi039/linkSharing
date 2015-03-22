<g:each in="${resourceList}" var="resourceInstance">
    <g:render template="../resource/displayInInbox" model="[resourceInstance: resourceInstance]" />
</g:each>
<util:remotePaginate controller="resource" action="resourceListOfSubscribedTopic" update="topicResourceDiv" total="${total}" max="${max}"/>