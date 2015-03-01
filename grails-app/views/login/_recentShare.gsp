<div class="header">
    <h4>Recent shares</h4>

    <g:each in="${resourceList}" var="resourceInstance">
        <g:render template="../resource/display" model="[resourceInstance: resourceInstance]"/>
    </g:each>
</div>