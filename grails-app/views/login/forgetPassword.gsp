<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Forget Password</title>
    <meta name="layout" content="header"/>
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
<div class="col-lg-5">
<form role="form" action="${createLink(controller:'login', action:'forgetPasswordAction')}" id="forgetPassword">
    <div class="form-group">
        <label for="email">Email/UserName:</label>
        <g:textField name="email" id="email" class="form-control" />
    </div>
    <g:submitButton name="submit" class="btn btn-default" value="Reset"/>
    </form>
    </div>

    </div>
</div>
<script>
    $("a.navbar-brand").click(function(){
        $(this).attr('href',"${createLink(controller:'user',action: 'dashBoard',absolute: true)}");
    });
</script>
</body>
</html>
