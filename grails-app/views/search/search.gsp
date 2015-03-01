<%--
  Created by IntelliJ IDEA.
  User: intelligrape
  Date: 1/3/15
  Time: 2:36 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="header"/>
    <title>Search Result</title>
</head>

<body>
<div>
    <div class="header">
        <h4>Search Result</h4>
    </div>
    <g:each in="${resourceList}" var="resourceInstance">
        <div class="row">
            <g:render template="../resource/display" model="[resourceInstance: resourceInstance]"/>
        </div>
    </g:each>
</div>
</body>
</html>