<div class="col-md-4">
    <img src="${resource(dir: 'images', file: '')}"/>
</div>

<div class="col-md-8">
    <a href="#" style="display:block;">${resourceInstance.topic.name}</a>

    <p>${resourceInstance.user.name}</p>

    <p>${"@${resourceInstance.user.firstName}"}</p>

    <p>${resourceInstance.description}</p>

    <ls:resourceType type="${resourceInstance.id}"/>
    <ls:markAsRead type="${resourceInstance.id}"/>
    <a href="#" style="display:inline-block;">ViewPosts</a>
    <hr/>
</div>