<div class="panel panel-default">
            <div class="panel-heading">Login</div>

            <div class="panel-body">
<form role="form" action="${createLink(controller: 'login',action: 'loginHandler')}" id="loginForm" method="post">
    <div class="form-group">
        <label for="email" >Email/UserName:</label>
        <input type="text" name="email" id="email" class="form-control" />
    </div>

    <div class="form-group">
        <label for="password" >Password:</label>
        <input type="password" name="password" id="password" class="form-control" required="true"/>
    </div>

    <input type="submit" name="submit" class="btn btn-default" value="Login"/>
</form>
<a href="${createLink (controller:'login', action:'forgetPassword')}"
   title="Forget Password">Forget Password?</a>
</div>
</div>