<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="header"/>
    <title>Homepage</title>

</head>

<body>

<div class="container">
    <div class="row">
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
            <g:render template="/login/login"></g:render>
            <g:render template="/login/register"></g:render>

        </div>
    </div>
</div>

</body>
</html>
