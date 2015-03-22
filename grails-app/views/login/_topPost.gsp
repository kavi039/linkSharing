<g:each in="${resourceList}" var="resourceInstance">
    <g:render template="../resource/display" model="[resourceInstance: resourceInstance]" />
</g:each>
<util:remotePaginate controller="resource" action="topPostAction" update="topPostDiv" total="${total}" max="${max}"/>