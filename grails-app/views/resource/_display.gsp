<div class="col-md-4">
    <img src="${resource(dir: 'images', file: 'Create.png')}"/>
</div>

<div class="col-md-8">
    <a href="#" style="display:block;">${resourceInstance.topic.name}</a>
    <p>${resourceInstance.user.name}</p>
    <p>${"@${resourceInstance.user.firstName}"}</p>
    <p>${resourceInstance.description}</p>
    <a href="#" style="display:block;">ViewPosts</a>
</div>