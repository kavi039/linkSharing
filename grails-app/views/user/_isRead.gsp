
<g:if test="${type}">
    <%println type%>
<a href="javascript:void(0)" data-resource-id="${resourceId}" class="isRead">Mark as Unread</a>
    </g:if>
<g:else>
    <a href="javascript:void(0)" data-resource-id="${resourceId}" class="isRead">Mark as read</a>
</g:else>

