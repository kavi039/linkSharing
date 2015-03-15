<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="header"/>
    <title>Homepage</title>

</head>

<body>

<div class="container">
    <div class="row" >
        <g:if test="${flash.error}"><script>alert("${flash.error}");</script></g:if>
        <g:if test="${flash.message}"><script>alert("${flash.message}");</script></g:if>
        <div class="col-md-7">
            <%--recentshare--%>
            <div class="panel panel-default">
                <div class="panel-heading">RecentShare</div>

                <div class="panel-body">
                    <ls:recentShare/>
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">TopPost
                    <select name="date" style="margin-left: 87%; margin-top: -2%;">
                        <option>Today</option>
                        <option>1week</option>
                        <option>1year</option>
                        <option>1month</option>
                    </select></div>

                <div class="panel-body">
                    <ls:topPost/>
                </div>

</div>
        </div>

        <div class="col-md-5">
            <div class="panel panel-default">
                <div class="panel-heading">Login</div>

                <div class="panel-body">
                    <g:form role="form" controller="login" action="loginHandler">
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
    </div>
</div>
</body>
</html>
