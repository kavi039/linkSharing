<li><a href="javascript:void(0)" title="comment"><span class="glyphicon glyphicon-comment"></span></a></li>
<li><a href="javascript:void(0)" title="document"><span class="glyphicon glyphicon-file"></span></a></li>
<li><a href="javascript:void(0)" title="linkresource"><span class="glyphicon glyphicon-paperclip"></span></a></li>
<li><a title="sendInvitation" href="javascript:void(0)"><span class="glyphicon glyphicon-envelope"></span></a></li>
<li><a href="javascript:void(0)" title="trendingTopic"><span class="glyphicon glyphicon-file"></span></a></li>
<li><a href="javascript:void(0)" title="user Profile"><span class="glyphicon glyphicon-user"></span></a></li>
<li>
<a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown">
    ${session['username']}
    <b class="caret" id="caret1"></b>
</a>
<ul class="dropdown-menu">
    <li><a href="${createLink(controller: 'user', action: 'editProfilePage')}">Profile</a></li>
    <g:if test="${isAdmin}">
        <li><a href="${createLink(controller: 'user', action: 'listOfUser')}">Users</a></li>
        <li><a href="${createLink(controller: 'topic', action: 'subscription')}">Topics</a></li>
        <li><a href="#">Posts</a></li>
    </g:if>
    <li><a href="${createLink(controller: 'login', action: 'logout')}" title="logout">Logout</a></li>

</ul>
</li>
