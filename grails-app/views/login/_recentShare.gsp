<div class="row">
                <div class="header">
                    <h4>Recent shares</h4>

<g:each in="${resourceList}" var="res">
    <div class="col-md-4">
        <img src="${resource(dir:'images', file:'Create.png')}"/>
    </div>

    <div class="col-md-8">
        <a href="#" style="display:block;">${res.topic.name}</a>
        ${res.description}

        <a href="#" style="display:block;">ViewPosts</a>
    </div>
</g:each>
</div>

