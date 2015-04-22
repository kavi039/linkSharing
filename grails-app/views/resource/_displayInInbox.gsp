<div class="media">
    <div class="media-left">
     <a href="${createLink(controller: 'user',action: 'user',params:[id: resourceInstance?.user?.id])}">   <img src="${createLink(controller: 'image', action: 'renderImage', params: [id: resourceInstance?.user?.id])}"
             height="100px" width="100px"/></a>
    </div>

    <div class="media-body">
        <span style="float: right">${resourceInstance?.topic?.name}</span>
        <span>${resourceInstance?.user?.name?.toUpperCase()}</span>
        <br>
        <span>${"@${resourceInstance?.user?.firstName?.toLowerCase()}"}</span>
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
            <a href="${createLink(controller: 'resource',action: 'post',params: [resourceId:resourceInstance?.id])}" title="details of post">ViewPosts</a>
        </div>
        <div class="fb-share-button" data-href="${createLink(controller: 'resource',action: 'post',params: [resourceId:resourceInstance?.id])}" data-layout="icon_link"></div>
    </div>
    <a href="https://plus.google.com/share?url=${createLink(controller: 'resource',action: 'post',absolute: true,params: [resourceId:resourceInstance?.id])}" onclick="javascript:window.open(this.href,
            '', 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=600,width=600');return false;"><img
            src="https://www.gstatic.com/images/icons/gplus-16.png" alt="Share on Google+"/></a>

    <hr/>
</div>
