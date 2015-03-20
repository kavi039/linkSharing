<div class="media">
    <div class="media-left">
     <a href="${createLink(controller: 'user',action: 'user',params:[id: resourceInstance?.user?.id])}">   <img src="${createLink(controller: 'image', action: 'renderImage', params: [id: resourceInstance?.user?.id])}"
             height="100px" width="100px"/></a>
    </div>

    <div class="media-body">
        <span style="float: right">${resourceInstance.topic.name}</span>
        <span>${resourceInstance?.user?.name}</span>
        <br>
        <span>${"@${resourceInstance?.user?.firstName}"}</span>
        <br>
        <span>${resourceInstance?.description}
            <br>
            <br>
            <br>
        </span>

        <div><ls:resourceType type="${resourceInstance?.id}"/>
        <g:if test="${session['username']}">
        <ls:markAsRead type="${resourceInstance}"/>
        </g:if>
            <a href="${createLink(controller: 'resource',action: 'post',params: [resourceId:resourceInstance?.id])}">ViewPosts</a>
        </div>

    </div>
    <hr/>
</div>
