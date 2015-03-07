<%--
  Created by IntelliJ IDEA.
  User: intelligrape
  Date: 1/3/15
  Time: 2:36 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Search Result</title>
</head>

<body>
<div class="container">
<div class="panel-default">
    <div class="panel-heading">Search Result</div>
    <div class="panel-body">
    <g:each in="${resourceList}" var="resourceInstance">
            <g:render template="../resource/display" model="[resourceInstance: resourceInstance]"/>

    </g:each>

        </div>
    </div>
    </div>
</body>
</html>