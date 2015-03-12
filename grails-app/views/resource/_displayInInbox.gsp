<div class="media">
    <div class="media-left">
        <img src="${createLink(controller: 'image',action: 'renderImage',params:[id:resourceInstance.user.id])}" height="100px" width="100px"/>
    </div>
    <div class="media-body" >
        <h4 class="media-heading"><a href="#">${resourceInstance.topic.name}</a></h4>
        <span>${resourceInstance.user.name}</span>
        <span>${"@${resourceInstance.user.firstName}"}</span>
        <span>${resourceInstance.description}
            <br>
            <br>
            <br>
            </span>
       <div><ls:resourceType type="${resourceInstance.id}" />
     <ls:markAsRead type="${resourceInstance.id}"/>
      <a href="#">ViewPosts</a>
           </div>

    </div>
</div>
<hr>
