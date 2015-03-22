
    <g:each in="${resourceList}" var="resourceInstance">
        <g:render template="../resource/display" model="[resourceInstance: resourceInstance]"/>

    </g:each>
    <util:remotePaginate controller="resource" action="resourceListPagination" update="recentShare" total="${total}" max="${max}"/>