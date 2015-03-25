
    %{--<g:each in="${userList}" var="userInfo">--}%
        <div class="media-left">
      <a href="${createLink(controller: 'user',action: 'user', params: [id: userInfo?.id])}">     <img src="${createLink(controller: 'image', action: 'renderImage', params: [id: userInfo?.id])}"
                 height="100px" width="100px"/></a>
        </div>

        <div class="media-body">
            <h4 class="media-heading"><a href="${createLink(controller: 'user', action: 'user', params: [id:userInfo?.id])}">${userInfo?.getName()?.toUpperCase()}</a></h4>
            <span>${"@${userInfo?.username?.toLowerCase()}"}</span>

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
    %{--</g:each>--}%


















