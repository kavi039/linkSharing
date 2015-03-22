<%@ page import="com.ttn.linkShare.Topic" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>TopicShow</title>
    <meta name="layout" content="header"/>
</head>

<body>

<div class="container">
    <div class="row">

    <div class="col-md-5">
    <div class="panel panel-default">
        <g:if test="${topic}">
            <div class="panel-heading">Topic<span style="color:#006dcc">(${topic.name})</span></div>

            <div class="panel-body">
                <g:render template="/topic/display" model="[topic:topic]"></g:render>
            </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">Users<span style="color:#006dcc">(${topic.name})</span></div>

                <div class="panel-body" >
                    <div class="media" >
                        <div id="userInfoDiv">
                    <ls:userList topic="${topic}" />
                            </div>
                </div>
                </div>
            </div>
            </div>
            <div class="col-md-7">
                <div class="panel panel-default">
                    <div class="panel-heading">Posts<span style="color:#006dcc">(${topic.name})</span></div>
                    <div id="postDiv">
                    <ls:displayResourcesOfTopic topic="${topic}"/>
                        </div>
                </div>
            </div>
        </g:if>
    </div>
</div>
<script>
    $("a.navbar-brand").click(function () {
        $(this).attr('href', "${createLink(controller:'user',action: 'dashBoard',absolute: true)}");
    });
</script>
</body>
</html>