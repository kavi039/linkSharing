<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="header"/>
		<title>Homepage</title>

</head>

<body>
<div class="container" >


    <g:if test="${flash.error}">
        <div class="error red" role="alert">
            ${flash.error}
        </div>
    </g:if>
    <div class="row" style="margin-top: 10%">
        <div class="col-md-7">
            <%--recentshare--%>
            <div class="row">
                <div class="header">
                    <h4>Recent shares</h4>
                </div>

                    <div class="col-md-3">
                        <img src="${resource(dir: "images/image" ,file: "")}" />
                        </div>
                    <div class="col-md-4">
                        <a href="#" STYLE="display: block;">GRAILS</a>
                        <p>
                            fdbkjbk
                            dgz
                            cvbc

                            </p>
                        <a href="#" STYLE="display: block;">ViewPosts</a>
                    </div>

        </div> <%--recentshare--%>
        <%--toppost--%>
            <div class="row">
                <div class="header">
                    <h4>Top Post</h4>


                </div>

                <div class="col-md-3">
                    <img src="${resource(dir: "images/image" ,file: "")}" />
                </div>
                <div class="col-md-4">
                    <a href="#" STYLE="display: block;">GRAILS</a>
                    <p>
                        fdbkjbk
                        dgz
                        cvbc

                    </p>
                    <a href="#" STYLE="display: block;">ViewPosts</a>
                </div>

            </div> <%--toppost--%>
            </div>
        <div class="col-md-5">
            <div class="header">
                <h4>Login</h4>
            </div>
            <g:form role="form" controller="login" action="loginHandler">
                <div class="form-group">
                    <label for="email">Email address:</label>
                    <g:textField name="email" id="email" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <g:passwordField name="password" id="password" class="form-control" />
                </div>

                <g:submitButton name="submit" class="btn btn-default" value="Login"/>
            </g:form>




        %{--<div class="col-md-5">--}%
            <g:uploadForm role="form" controller="login" action="registerHandler" >
                <div class="header">
                    <h4>Register</h4>
                </div>
                <div class="form-group">
                    <label for="firstName">First Name:</label>
                    <g:textField name="firstName" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="lastName">Last Name:</label>
                    <g:textField name="lastName" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="email">Email address:</label>
                    <g:textField name="email" id="email" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="username">Username:</label>
                    <g:textField name="username" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <g:textField name="password" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="confirmPassword">Confirm Password:</label>
                    <g:textField name="confirmPassword" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="photo">Confirm Password:</label>
                    <g:field type="file" name="photo" class="form-control" />
                </div>
                <g:submitButton name="submit" class="btn btn-default" value="SignUp"/>
            </g:uploadForm>
        </div>
    </div>
%{--</div>--}%
</div>
</body>
</html>
