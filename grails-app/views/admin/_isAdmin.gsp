<a href="#" title="comment"><span class="glyphicon glyphicon-comment"></span></a>
<a  href="#" title="document"><span class="glyphicon glyphicon-file"></span></a>
<a href="#" title="linkresource"><span class="glyphicon glyphicon-paperclip"></span></a>
<a title="sendInvitation"  href="#" ><span class="glyphicon glyphicon-envelope"  ></span></a>
<a  href="#" title="trendingTopic"><span class="glyphicon glyphicon-file"></span></a>
<a href="#" title="user Profile"><span class="glyphicon glyphicon-user"></span></a>
<label class="user">${session['username']}</label>

<div class="mylist" style="display: inline-block">

    <a href="#">Profile</a>
    <g:if test="${isAdmin}">
        <a href="${createLink(controller: 'user',action: 'listOfUser')}">Users</a>
        <a href="${createLink(controller:'topic',action: 'subscription')}">Topics</a>
        <a href="#">Posts</a>
    </g:if>
    <a href="${createLink(controller: 'login', action: 'logout')}" title="logout">Logout</a>
</div>






    </div>
</div>