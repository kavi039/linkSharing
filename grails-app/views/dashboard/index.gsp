<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">
                    Link Sharing
                </a>
            </div>
        </div>
        <div class="search">
            <input type="image" src='./image/images4.jpeg' class="one " />
            <input type="text" placeholder="search" id="k"/>
            <input type="image"  src='./image/images5.jpeg' class="two"/>

        </div>
    </nav>

    <g:if test="${flash.error}">
        <div class="error red" role="alert">
            ${flash.error}
        </div>
    </g:if>
    <div class="row">
        <div class="col-md-7">
        </div>
        <div class="col-md-5">
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
