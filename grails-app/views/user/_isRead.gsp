
<g:if test="${type}">
<a href="javascript:void(0)" data-resource-id="${resourceId}" class="isRead" title="mark as unread">Mark as Unread</a>
    </g:if>
<g:else>
    <a href="javascript:void(0)" data-resource-id="${resourceId}" class="isRead" title="mark as read only if you have subscribed the topic">Mark as read</a>
</g:else>

