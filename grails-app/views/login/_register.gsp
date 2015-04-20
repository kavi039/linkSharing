<div class="panel panel-default">
    <div class="panel-heading">Register</div>

    <div class="panel-body">
        <form enctype="multipart/form-data" role="form" action="${createLink(controller:"user" ,action:"registerHandler" )}" id="registerForm" method="post">
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

        </form>
    </div>
    <div>
        </div>
</div>