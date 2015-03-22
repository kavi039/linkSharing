<g:each in="${resourceList}" var="resourceInstance">
    <g:render template="../resource/display" model="[resourceInstance: resourceInstance]" />
</g:each>
<util:remotePaginate controller="resource" action="topPost" update="topPost" total="${total}" max="${max}"/>