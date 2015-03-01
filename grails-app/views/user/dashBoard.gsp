<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>

    <meta name="layout" content="header"/>
    <title>Dashboard</title>
</head>

<body>
<div class="container" >
    <!--left side-->
    <div class="col-md-5" style="border: solid ;margin-top: 5%">
        <div class="row">
            <ls:user/>
        </div>
        <div class="row">
            <div class="header">
                <h4>Subscription</h4>
            </div>
                <g:each in="${topicList}" var="topic">
                    <g:render template="../topic/display" model="[topic: topic]" />
                </g:each>
        </div>
    </div>


</div>
    </div>
    <!--left side-->
    <div class="col-md-7">
    </div>
</div>
</body>
</html>