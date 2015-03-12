<div class="media">
    <div class="media-left">
        <img src="${createLink(controller: 'image', action: 'renderImage', params: [id: topic.user.id])}" height="100px"
             width="100px"/>
    </div>

    <div class="media-body">
        <h4 class="media-heading"><a href="#">${topic?.name}</a></h4>
        <span>@${topic?.user?.firstName}</span>
        <span style="float: right"><ls:isSubscribed topic="${topic}"/></span>

        <div class="col-md-12">
            <div class="col-md-6">
                <p>Subscription</p>
                <ls:subscriptionCount topic="${topic}"/>
            </div>

            <div class="col-md-6">
                <p>Post</p>
                <ls:postCount topic="${topic}"/>
            </div>
        </div>

        <div style="float: right"><ls:subscriptionActions topic="${topic}"/></div>

    </div>
</div>
<hr>































