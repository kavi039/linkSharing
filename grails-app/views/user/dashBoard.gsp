<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>

    <meta name="layout" content="header"/>
    <title>Dashboard</title>
</head>

<body>
<div class="container">
    <!--left side-->
    <div class="row" style="margin-top:10%">

        <span style="color:red"><g:message message="${flash.error}"></g:message></span>

        <div class="col-md-5">
            <div class="panel panel-default">
                <div class="panel-body">
                    <ls:user/>
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">Subscription
                    <a href="${createLink(controller: 'topic',action: 'subscription')}" style="float: right">View All</a>
                </div>

                <div class="panel-body">
                    <ls:userSubscription/>
                </div>
            </div>
        </div>

        <div class="col-md-7">
            <div class="panel panel-default">
                <div class="panel-heading">Inbox
                    <div style="float: right">
                        <g:form name="search" class="form-group" controller="search" action="search">
                            <g:textField name="searchText" placeholder="search"/>
                            <g:submitButton name="finder" value="search"/>
                        </g:form>
                    </div>
                </div>

                <div class="panel-body">
                    <ls:inbox/>
                </div>
            </div>

        </div>

    </div>
</div>

</body>
</html>