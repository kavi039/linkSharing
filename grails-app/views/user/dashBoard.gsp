<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="header"/>
    <title>Dashboard</title>
</head>

<body>
<div class="container">
    <!--left side-->
    <div class="row">
    <g:if test="${flash.error}"><script>alert("${flash.error}");</script></g:if>
    <g:if test="${flash.message}"><script>alert("${flash.message}");</script></g:if>
        <div class="col-md-6">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="media">
                    <ls:user/>
                        </div>
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">Subscription
                    <a href="${createLink(controller: 'topic', action: 'subscription')}"
                       style="float: right">View All</a>
                </div>

                <div class="panel-body" >
                    <ls:userSubscription/>
                </div>
            </div>
        </div>

        <div class="col-md-6">
            <div class="panel panel-default">
                <div class="panel-heading">Inbox
                    %{--<div style="float: right">--}%
                        %{--<g:form name="search" class="form-group" controller="search" action="search">--}%
                            %{--<g:textField name="searchText" placeholder="search"/>--}%
                            %{--<g:submitButton name="finder" value="search"/>--}%
                        %{--</g:form>--}%
                    %{--</div>--}%
                </div>

                <div class="panel-body" id="inboxDiv" style="overflow-y: scroll;height:500px " >
                    <ls:inbox/>
                </div>
            </div>

        </div>

    </div>
</div>
<script>
    %{--$("a.navbar-brand").click(function(){--}%
        %{--$(this).attr('href',"${createLink(controller:'login',action: 'login',absolute: true)}");--}%
    %{--});--}%
</script>
</body>

</html>