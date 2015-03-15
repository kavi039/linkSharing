<%--
  Created by IntelliJ IDEA.
  User: intelligrape
  Date: 15/3/15
  Time: 12:25 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login</title>
    <meta name="layout" content="header"/>
</head>

<body>
<div class="panel panel-default" style="margin: 0 auto;width: 50%">
    <div class="panel-heading">Login</div>

    <div class="panel-body">
        <g:form role="form" controller="login" action="loginShowHandler">
            <div class="form-group">
                <label for="email">Email/UserName:</label>
                <g:textField name="email" id="email" class="form-control"/>
            </div>

            <div class="form-group">
                <label for="password">Password:</label>
                <g:passwordField name="password" id="password" class="form-control"/>
            </div>

            <g:submitButton name="submit" class="btn btn-default" value="Login"/>
        </g:form>
        <a href="<g:createLink controller='login' action='changePassword'/>"
           title="change Password">Forget Password?</a>
    </div>
</div>
</body>
</html>