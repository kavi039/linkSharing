<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><g:layoutTitle default="Grails"/></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <g:layoutHead/>
</head>

<body style="background-color: #31b0d5 ">
<div id="fb-root"></div>
<script>(function (d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s);
    js.id = id;
    js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.3";
    fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
<nav class="navbar navbar-default" role="navigation" >
    <div class="navbar-header">
        <a class="navbar-brand" href="javascript:void(0)"  onclick="clickEventOnHeader(this)"><h2 style="margin: 0 auto;color: #550000">LinkSharing</h2></a>
    </div>
    <ul class="nav navbar-nav" style="float: right" >

        <g:if test="${session['username']}">
            <ls:isAdmin username="${session['username']}"/>
        </g:if>
        <li class="active" ><div>
            <g:form name="search" class="navbar-form navbar-right" controller="search" action="search" style="float: right" >
                <g:textField name="searchText" placeholder="search here"
                             title="only public topic and its posts are searchable"/>
                <g:submitButton name="finder" value="search"/>
            </g:form>
        </div></li>
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
<div class="alert alert-warning" style="display: none">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Success!</strong>
</div>
<script src="${resource(dir: "/js", file: 'jquery.min.js')}"></script>
<script src="${resource(dir: "/js", file: 'jquery.validate.min.js')}"></script>
<script src="${resource(dir: "/js", file: 'bootstrap.min.js')}"></script>
<script src="${resource(dir: "/js", file: 'bootstrap.js')}"></script>
<script src="${resource(dir: "/js", file: 'myJquery.js')}"></script>

<g:layoutBody/>

<script>
    var MarkAsRead, MarkAsUnread, ResourceByList, deleteTopicDetail, TopicVisibilityUpdate, sendMail, topicNameUpdate, resourceRatingUpdate, emailUniquenessCheck;
    $(document).ready(function () {
        MarkAsUnread = "${createLink(controller: "readingItem", action: "markAsUnRead")}";
        MarkAsRead = "${createLink(controller: "readingItem", action: "markAsRead")}";
        Subscription = "${createLink(controller: "topic",action: 'topicSubscription')}";
        UnSubscription = "${createLink(controller: "topic",action: 'topicUnSubscription')}";
        SubscriptionUpdate = "${createLink(controller: "topic",action: 'topicSubscriptionUpdate')}";
        TopicVisibilityUpdate = "${createLink(controller: "topic",action: 'topicVisibilityUpdate')}";
        deleteTopicDetail = "${createLink(controller: "topic",action: 'deleteTopic')}";
        sendMail = "${createLink(controller:'sendInvitation',action:'sendEmail')}";
        topicNameUpdate = "${createLink(controller:'topic',action:'updateTopicName')}";
        resourceRatingUpdate = "${createLink(controller: 'resource',action: 'resourceRating')}";
        resourceDelete = "${createLink(controller: 'resource',action: 'deleteResource')}";
        dashboard = "${createLink(controller: 'user',action: 'dashBoard',absolute: true)}";
        documentController = "${createLink(controller:'documentResource' ,action:'saveDocument')}";
        emailUniquenessCheck = "${createLink(controller: 'user',action:'uniqueEmailCheckerOrUsername')}";

        $("form#registerForm").validate({
            errorPlacement:function(error,element){
                error.css('color','red');
                error.insertBefore(element);
            },
            rules: {
                password: {
                    required: true,
                    minlength: 4
                },
                confirmPassword: {
                    required: true,
                    minlength: 4
                },
                email: {
                    required: true,
                    email: true,
                    remote:{
                        url:emailUniquenessCheck
                    }
                },
                username: {
                    required: true,
                    remote:{
                        url:emailUniquenessCheck
                    }
                }
            },
            messages: {
                password: {
                    required: "please enter your password",
                    minlength: jQuery.format("At least {0} characters required! and Maximum 10")
                },
                email: {
                    required: "Your UserName Or Email Address Can not be empty",
                    email: "kindly enter valid emailAddress",
                    remote:"this email address is already taken"

                },
                username: {
                    required: "Username can not be empty",
                    remote:"this username is already taken"
                },
                confirmPassword: {
                    required: "can not be empty",
                    minlength: jQuery.format("At least {0} characters required! and Maximum 10")
                }
            }
        });


    });
    function clickEventOnHeader(element){
        var sessionAttribute="${session.getAttribute('username')}";
     if(sessionAttribute!=null)
     window.location.replace("${createLink(controller: 'user',action: 'dashBoard',absolute: true)}");
        else
         window.location.replace("${createLink(controller: 'login',action: 'login',absolute: true)}");
    }

</script>
</body>
</html>