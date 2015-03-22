<g:each in="${resourceList}" var="resourceInstance">
    <g:render template="../resource/displayInInbox" model="[resourceInstance: resourceInstance]" />
</g:each>
<util:remotePaginate controller="resource" action="resourceList" update="postDiv" total="${total}" max="${max}" params="[topicId:topicId]"/>
