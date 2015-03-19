<div class="media">
    <div class="media-left">
        <a href="${createLink(controller: 'user', action: 'user', params: [id: userPublicProfileDTO?.user?.id])}"><img
                src="${createLink(controller: 'image', action: 'renderImage',params: [id: userPublicProfileDTO?.user?.id])}"
                height="100px" width="100px"/></a>
    </div>

    <div class="media-body">
        <h4 class="media-heading"><a href="#">${userPublicProfileDTO?.user?.getName()}</a></h4>
        <span>${"@${userPublicProfileDTO?.user?.username}"}</span>

        <div class="col-md-12">
            <div class="col-md-6">
                <p>Subscription</p>
                ${userPublicProfileDTO?.subscriptionCount}
            </div>

            <div class="col-md-6">
                <p>Topic</p>
                ${userPublicProfileDTO?.publicTopicCreated}
            </div>
        </div>

    </div>
    <hr>
</div>


