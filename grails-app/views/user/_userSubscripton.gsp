<div class="media">
    <g:each in="${userList}" var="userInfo">
        <div class="media-left">
            <img src="${createLink(controller: 'image', action: 'renderImage', params: [id: userInfo?.id])}"
                 height="100px" width="100px"/>
        </div>

        <div class="media-body">
            <h4 class="media-heading"><a href="#">${userInfo?.getName()}</a></h4>
            <span>${"@${userInfo?.username}"}</span>

            <div class="col-md-12">
                <div class="col-md-6">
                    <p>Subscription</p>
                    ${com.ttn.linkShare.Subscription.countByUser(userInfo)}
                </div>

                <div class="col-md-6">
                    <p>Topic</p>
                    ${userInfo?.topics?.size()}
                </div>
            </div>

        </div>
        <hr>
    </g:each>
</div>
















