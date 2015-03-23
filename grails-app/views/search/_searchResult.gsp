<g:each in="${resourceList}" var="resourceInstance">
    <g:render template="../resource/displayInInbox" model="[resourceInstance: resourceInstance]"/>
</g:each>
<util:remotePaginate controller="search" action="searchPaginationOntext" update="topicResourceDiv" total="${total}" max="${max}" params="[searchText:searchText]"/>
