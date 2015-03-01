<div class="row">
<g:select name="seriousness" from="${com.ttn.linkShare.enums.Seriousness.values()}"/>
<g:if test="${isAdminOrCreator}">
    <g:select name="visibility" from="${com.ttn.linkShare.enums.Visibility.values()}" value="${topic.visibility}"/>
</g:if>
<a href="#" class="glyphicon glyphicon-envelope"></a>
<g:if test="${isAdminOrCreator}">
    <a href="#" class="glyphicon glyphicon-edit"></a>
    <a href="#" class="red glyphicon glyphicon-trash"></a>
</g:if>
</div>