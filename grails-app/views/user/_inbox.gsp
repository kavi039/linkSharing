<g:each in="${resourceList}" var="resourceInstance">
    <g:render template="../resource/displayInInbox" model="[resourceInstance: resourceInstance]" />
</g:each>
<util:remotePaginate controller="user" action="inboxPagination" update="inboxDiv" total="${total}" max="${max}"/>