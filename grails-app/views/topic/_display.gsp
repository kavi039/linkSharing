<div class="row" style="margin-top: 20px">
    %{--<div class="row">--}%
    <div>
        <div class="col-md-3">
            <img src="${createLink(controller: 'image',action: 'renderImage',params:[id:topic.user.id])}"/>
        </div>

        <div class="col-md-3">
            <div class="row">
                <a href="#">${topic?.name}</a>
            </div>

            <div class="row">
                @${topic?.user?.firstName}
            </div>
        </div>

        <div class="col-md-3">
            <p>Subscription</p>
            <ls:subscriptionCount topic="${topic}"/>
        </div>

        <div class="col-md-3">
            <p>Post</p>
            <ls:postCount topic="${topic}"/>
        </div>
    </div>

    <div class="row">
        <div class="col-md-3"></div>

        <div class="col-md-9">
            <ls:subscriptionActions topic="${topic}"/>
        </div>
    </div>
</div>