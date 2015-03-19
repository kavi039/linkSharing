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
        <g:if test="${Topic.findByName(topicName)}">
            <div class="panel-heading">Topic<span style="color:#006dcc">(${topicName})</span></div>

            <div class="panel-body">
                <g:render template="/topic/display" model="[topic: Topic.findByName(topicName)]"></g:render>
            </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">Users<span style="color:#006dcc">(${topicName})</span></div>

                <div class="panel-body">
                    <ls:user topic="${topicName}" username="${null}"/>
                </div>
            </div>
            </div>
            <div class="col-md-7">
                <div class="panel panel-default">
                    <div class="panel-heading">Posts<span style="color:#006dcc">(${topicName})</span></div>
                    <ls:displayResourcesOfTopic topic="${topicName}"/>
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