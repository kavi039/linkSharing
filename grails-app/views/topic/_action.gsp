<div class="row">
    <span style="float: right">

    <g:select name="seriousness" from="${com.ttn.linkShare.enums.Seriousness.values()}" value="${seriousness}" id="${topic.id}" onchange="setSeriousness(${topic.id},this)" class="seriousness" title="change seriousness here"/>
    <g:if test="${isAdminOrCreator}">
        <%flash.topic=topic.name%>
        <g:select name="visibility" from="${com.ttn.linkShare.enums.Visibility.values()}" value="${topic.visibility}" id="${topic.id}" onchange="setVisibility(${topic.id},this)" title="change visibility here"/>
    </g:if>
    <a href="javascript:void(0)" title="send invitation here" class="glyphicon glyphicon-envelope A" data-topic="${topic}" onclick="sendInvitation('${topic.id}','${topic.name}')"></a>
    <g:if test="${isAdminOrCreator}">
        <span class="anchorChange">
        <a href="javascript:void(0)"  title="Edit here" class="glyphicon glyphicon-edit" onclick="editTopic(${topic.id},this)"></a>
        </span>
        <a href="javascript:void(0)" title="delete here" class="glyphicon glyphicon-remove" onclick="deleteTopic(${topic.id})">uy</a>
    </g:if>

</div>