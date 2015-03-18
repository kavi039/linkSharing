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
<div class="col-md-6">
    <div class="panel panel-default">
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
</div>

<div class="col-lg-6">
    <div class="panel panel-default">
        <div class="panel-heading">Register</div>

        <div class="panel-body">
            <g:uploadForm role="form" controller="user" action="registerHandler">
                <div class="form-group">
                    <label for="firstName">First Name:</label>
                    <g:textField name="firstName" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="lastName">Last Name:</label>
                    <g:textField name="lastName" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="email">Email address:</label>
                    <g:textField name="email" id="email" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="username">Username:</label>
                    <g:textField name="username" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="password">Password:</label>
                    <g:passwordField name="password" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="confirmPassword">Confirm Password:</label>
                    <g:passwordField name="confirmPassword" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="photo">Upload Photo:</label>
                    <g:field type="file" name="photo" class="form-control"/>
                </div>
                <g:submitButton name="submit" class="btn btn-default" value="SignUp"/>

            </g:uploadForm>
        </div>
    </div>
</div>
</body>
</html>