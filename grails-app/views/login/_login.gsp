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
<a href="${createLink (controller:'login', action:'forgetPassword')}"
   title="Forget Password">Forget Password?</a>
</div>
</div>