<div class="row">
    <span style="float: right">

    <g:select name="seriousness" from="${com.ttn.linkShare.enums.Seriousness.values()}" value="${seriousness}" id="${topic.id}" onchange="setSeriousness(${topic.id})" />
    <g:if test="${isAdminOrCreator}">
        <g:select name="visibility" from="${com.ttn.linkShare.enums.Visibility.values()}" value="${topic.visibility}" id="${topic.id}" onchange="setVisibility(${topic.id})"/>
    </g:if>
    <a href="#" class="glyphicon glyphicon-envelope"></a>
    <g:if test="${isAdminOrCreator}">
        <a href="#" class="glyphicon glyphicon-edit" onclick="editTopic(${topic.id})"></a>
        <a href="#" class="glyphicon glyphicon-remove">uy</a>
    </g:if>

</div>