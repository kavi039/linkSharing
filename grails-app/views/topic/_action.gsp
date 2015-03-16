<div class="row">
    <span style="float: right">

    <g:select name="seriousness" from="${com.ttn.linkShare.enums.Seriousness.values()}" value="${seriousness}" id="${topic.id}" onchange="setSeriousness(${topic.id},this)" class="seriousness"/>
    <g:if test="${isAdminOrCreator}">
        <g:select name="visibility" from="${com.ttn.linkShare.enums.Visibility.values()}" value="${topic.visibility}" id="${topic.id}" onchange="setVisibility(${topic.id},this)"/>
    </g:if>
    <a href="javascript:void(0)"  class="glyphicon glyphicon-envelope" data-topic="${topic}" onclick="sendInvitation(${topic.id},${topic.name})"></a>
    <g:if test="${isAdminOrCreator}">
        <a href="javascript:void(0)"  class="glyphicon glyphicon-edit" onclick="editTopic(${topic.id})"></a>
        <a href="javascript:void(0)"  class="glyphicon glyphicon-remove" onclick="deleteTopic(${topic.id})">uy</a>
    </g:if>

</div>