<div class="row">
    <g:select name="seriousness" from="${com.ttn.linkShare.enums.Seriousness.values()}" value="${seriousness}"/>
    <g:if test="${isAdminOrCreator}">
        <g:select name="visibility" from="${com.ttn.linkShare.enums.Visibility.values()}" value="${topic.visibility}"/>
    </g:if>
    <a href="#" class="glyphicon glyphicon-envelope"></a>
    <g:if test="${isAdminOrCreator}">
        <a href="#" class="glyphicon glyphicon-edit" onclick="editTopic(${topic.resources.id})"></a>
        <a href="#" class="glyphicon glyphicon-remove">uy</a>
    </g:if>
</div>