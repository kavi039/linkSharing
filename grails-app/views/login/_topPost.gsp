<g:each in="${resourceList}" var="res">
<div class="col-md-4">
    <img src="${resource(dir: "images", file:'')}"/>
</div>

<div class="col-md-8">
    <a href="#" STYLE="display: block;">${res.topic.name}</a>
${res.description}

    <a href="#" STYLE="display: block;">ViewPosts</a>
</div>
</g:each>
</div>