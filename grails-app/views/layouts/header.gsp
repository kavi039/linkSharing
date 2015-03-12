<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><g:layoutTitle default="Grails"/></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <g:layoutHead/>

</head>

<body style="background-color:#1f6377;">
<nav class="navbar navbar-default" role="navigation" >
    <div class="navbar-header">
        <a class="navbar-brand" href="${createLink(controller: 'user', action: 'dashBoard')}">LinkSharing</a>
    </div>
        <ul class="nav navbar-nav">
            <li class="active"><div>
<g:form name="search" class="form-group" controller="search" action="search">
<g:textField name="searchText"  placeholder="search"/>
<g:submitButton name="finder" value="search" />
</g:form>
            </div></li>

<g:if test="${session['username']}">
<ls:isAdmin username="${session['username']}"/>
</g:if>
        </ul>
</nav>
<g:if test="${session['username']}">
<div id="showPop" style="display: none;height: 400px;width: 400px;margin: 0 auto;">

    <g:render template="/sendInvitation/send"></g:render>
</div>

<div id="createTopic" style="display: none;height: 400px;width: 400px;margin: 0 auto">
    <g:render template="/topic/createTopic"></g:render>
</div>

<div id="documentShare" style="display: none;height: 400px;width: 400px;margin: 0 auto">
    <g:render template="/topic/documentShare"></g:render>
</div>

<div id="linkShare" style="display: none;width: 500px;margin: 0 auto;">
    <g:render template="/topic/shareLink"></g:render>
</div>

<div id="trendingTopic" style="display: none;width: 600px;margin: 0 auto;background-color:#ebebeb;border-radius: 5%">
    <ls:trendingTopic/>
</div>
</g:if>





















%{--<div class="container col-md-12" style="border: solid;border-radius: 5px">--}%
%{--<div class="col-md-2">--}%
%{--<a href="${createLink(controller:'user',action: 'dashBoard')}"> <h1>LinkSharing</h1></a>--}%
%{--</div>--}%
%{--<div class="col-md-3" >--}%
%{--<g:form name="search" class="form-group" controller="search" action="search">--}%
%{--<g:textField name="searchText"  placeholder="search"/>--}%
%{--<g:submitButton name="finder" value="search" />--}%
%{--</g:form>--}%

%{--</div>--}%

%{--<div class="col-md-7">--}%
%{--<g:if test="${session['username']}">--}%
%{--<ls:isAdmin username="${session['username']}"/>--}%
%{--</g:if>--}%
%{--</div>--}%





</div>
<script src="${resource(dir: "/js", file: 'jquery.min.js')}"></script>
<script src="${resource(dir: "/js", file: 'bootstrap.min.js')}"></script>
<script src="${resource(dir: "/js", file: 'bootstrap.js')}"></script>
<script src="${resource(dir: "/js", file: 'myJquery.js')}"></script>

<g:layoutBody/>
<script>
    var MarkAsRead, MarkAsUnread, ResourceByList;
    $(document).ready(function () {
        MarkAsUnread = "${createLink(controller: "readingItem", action: "markAsUnRead")}";
        MarkAsRead = "${createLink(controller: "readingItem", action: "markAsRead")}";
        Subscription = "${createLink(controller: "topic",action: 'topicSubscription')}"
        UnSubscription = "${createLink(controller: "topic",action: 'topicUnSubscription')}"
    });
</script>
</body>
</html>