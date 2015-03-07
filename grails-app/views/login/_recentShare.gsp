
    <g:each in="${resourceList}" var="resourceInstance">
        <g:render template="../resource/display" model="[resourceInstance: resourceInstance]"/>

    </g:each>
