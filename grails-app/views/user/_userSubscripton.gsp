<div class="media">
    <div class="media-left">
        <img src="${createLink(controller: 'image',action: 'renderImage',params:[id:userInfo.user?.id])}" height="100px" width="100px"/>
    </div>
    <div class="media-body" >
        <h4 class="media-heading"><a href="#">${userInfo?.user?.getName()}</a></h4>
        <span>${"@${userInfo?.user?.username}"}</span>
        <div class="col-md-12">
            <div class="col-md-6">
                <p>Subscription</p>
                ${userInfo?.totalSubscription}
            </div>

            <div class="col-md-6">
                <p>Topic</p>
                ${userInfo?.totalTopic}
            </div>
        </div>

    </div>
</div>
<hr>

















