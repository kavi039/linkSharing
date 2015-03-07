

        <div class="col-md-4" >
            <img src="${resource(dir: "images", file: "")}">
        </div>

        <div class="col-md-8">
            <p>

            <h1>${userInfo?.user?.getName()}</h1></p>
            <p>${"@${userInfo?.user?.username}"}</p>

            <div class="col-md-4">
                <p>Subscription</p>

                <p>${userInfo?.totalSubscription}</p>
            </div>

            <div class="col-md-4">

                <p>Topic</p>

                <p>${userInfo?.totalTopic}</p>
            </div>


    </div>
