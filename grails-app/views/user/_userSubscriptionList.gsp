
<g:each in="${userList}" var="user">
 <g:render template="/user/userSubscripton" model="[userInfo:user]"/>
</g:each>
<util:remotePaginate controller="user" action="userList" update="userInfoDiv" total="${total}" max="${max}" params="[topicId:topicId]"/>
