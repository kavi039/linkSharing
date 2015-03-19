
<div class="media">
    <div class="media-left">
        <a href="${createLink(controller: 'user',action: 'user',params:[id: resourceInstance?.user?.id] )}"> <img src="${createLink(controller: 'image', action: 'renderImage', params: [id: resourceInstance?.user?.id])}"
                                                                             height="100px" width="100px"/></a>
    </div>
    <div class="media-body" >
        <a href="${createLink(controller: 'topic', action: 'topicShow', params: [topicName:resourceInstance?.topic?.name])}" style="display:block;">  <span  style="float: right">${resourceInstance?.topic?.name}</span></a>
        <p>${resourceInstance?.user?.name}</p>
        <p>${"@${resourceInstance?.user?.firstName}"}</p>
        <br>
        <p>
            ${resourceInstance?.description}
        </p>
        <br>
        <br>
            <a href="${createLink(controller: 'resource',action: 'post',params: [resourceId:resourceInstance?.id])}" style="display:block;">  <span  style="float: right">ViewPosts</span></a>

        </div>
    </div>
    <hr/>

