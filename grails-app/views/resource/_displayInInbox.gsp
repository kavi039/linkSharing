<div class="media">
    <div class="media-left">
        <img src="${createLink(controller: 'image', action: 'renderImage', params: [id: resourceInstance?.user?.id])}"
             height="100px" width="100px"/>
    </div>

    <div class="media-body">
        <span style="float: right">${resourceInstance.topic.name}</span>
        <span>${resourceInstance.user.name}</span>
        <span>${"@${resourceInstance.user.firstName}"}</span>
        <span>${resourceInstance.description}
            <br>
            <br>
            <br>
        </span>
<%%>
        <div><ls:resourceType type="${resourceInstance?.id}"/>

        <ls:markAsRead type="${resourceInstance}"/>
            %{--<g:if test="${resourceInstance.isRead}">--}%
                %{--<a href="javascript:void(0)" data-resource-id="${resourceInstance.id}" class="isRead">Mark as Unread</a>--}%
            %{--</g:if>--}%
            %{--<g:else>--}%
                %{--<a href="javascript:void(0)" data-resource-id="${resourceInstance.id}" class="isRead">Mark as read</a>--}%
            %{--</g:else>--}%

            <a href="#">ViewPosts</a>
        </div>

    </div>
    <hr/>
</div>
