<g:each in="${resourceList}" var="resourceInstance">
    <g:render template="../resource/displayInInbox" model="[resourceInstance: resourceInstance]" />
</g:each>
<util:remotePaginate controller="user" action="inboxPagination" update="inbox" total="78" max='5' offset="0"/>