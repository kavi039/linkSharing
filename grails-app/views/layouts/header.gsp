<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><g:layoutTitle default="Grails"/></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <g:layoutHead/>

</head>

<body style="background-color:#1f6377;">
<nav class="navbar navbar-default" role="navigation">
    <div class="navbar-header">
        <a class="navbar-brand" href="javascript:void(0)">LinkSharing</a>
    </div>
    <ul class="nav navbar-nav">
        <li class="active"><div>
            <g:form name="search" class="form-group" controller="search" action="search">
                <g:textField name="searchText" placeholder="search"/>
                <g:submitButton name="finder" value="search"/>
            </g:form>
        </div></li>

        <g:if test="${session['username']}">
            <ls:isAdmin username="${session['username']}"/>
        </g:if>
    </ul>
</nav>
<g:if test="${session['username']}">
    <g:render template="/sendInvitation/send"></g:render>
    <g:render template="/topic/createTopic"></g:render>
    <g:render template="/topic/documentShare"></g:render>
    <g:render template="/topic/shareLink"></g:render>
    <g:render template="/topic/trendingtopic"></g:render>
    <g:render template="/sendInvitation/sendingInvitationforTopic"/>

</g:if>
</div>
<script src="${resource(dir: "/js", file: 'jquery.min.js')}"></script>
<script src="${resource(dir: "/js", file: 'bootstrap.min.js')}"></script>
<script src="${resource(dir: "/js", file: 'bootstrap.js')}"></script>
<script src="${resource(dir: "/js", file: 'myJquery.js')}"></script>

<g:layoutBody/>
<script>
    var MarkAsRead, MarkAsUnread, ResourceByList, deleteTopicDetail, TopicVisibilityUpdate,sendMail;
    $(document).ready(function () {
        MarkAsUnread = "${createLink(controller: "readingItem", action: "markAsUnRead")}";
        MarkAsRead = "${createLink(controller: "readingItem", action: "markAsRead")}";
        Subscription = "${createLink(controller: "topic",action: 'topicSubscription')}"
        UnSubscription = "${createLink(controller: "topic",action: 'topicUnSubscription')}"
        SubscriptionUpdate = "${createLink(controller: "topic",action: 'topicSubscriptionUpdate')}"
        TopicVisibilityUpdate = "${createLink(controller: "topic",action: 'topicVisibilityUpdate')}"
        deleteTopicDetail = "${createLink(controller: "topic",action: 'deleteTopic')}"
        sendMail="${createLink(controller:'sendInvitation',action:'sendEmail')}"
    });
</script>
</body>
</html>