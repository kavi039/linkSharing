<li><a href="#" title="comment"><span class="glyphicon glyphicon-comment"></span></a></li>
<li><a href="#" title="document"><span class="glyphicon glyphicon-file"></span></a></li>
<li><a href="#" title="linkresource"><span class="glyphicon glyphicon-paperclip"></span></a></li>
<li><a title="sendInvitation" href="#"><span class="glyphicon glyphicon-envelope"></span></a></li>
<li><a href="#" title="trendingTopic"><span class="glyphicon glyphicon-file"></span></a></li>
<li><a href="#" title="user Profile"><span class="glyphicon glyphicon-user"></span></a></li>
<li>
<a href="#" class="dropdown-toggle" data-toggle="dropdown">
    ${session['username']}
    <b class="caret"></b>
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
