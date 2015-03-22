<g:each in="${resourceList}" var="resourceInstance">
    <g:render template="../resource/displayInInbox" model="[resourceInstance: resourceInstance]" />
</g:each>
<util:remotePaginate controller="resource" action="publicResourceListCreatedByUser" update="publicPost" total="${total}" max="${max}" params="[userId:userId]"/>