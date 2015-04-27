<%@ page import="com.ttn.linkShare.User" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>User public profile</title>
    <meta name="layout" content="header"/>
</head>

<body>
<%com.ttn.linkShare.User user=com.ttn.linkShare.User.get(params.int("id"))%>
<div class="container">

    <div class="row">

        <div class="col-md-6">
            <div class="panel panel-default">
                <div class="panel-body">
                    <ls:userPublicProfile userId="${params.id}"/>
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">Topics Created By ${user?.name?.toUpperCase()}
                    %{--<div style="float: right">--}%
                        %{--<g:form name="search" class="form-group" controller="search" action="search">--}%
                            %{--<g:textField name="searchText" placeholder="search"/>--}%
                            %{--<g:submitButton name="finder" value="search"/>--}%
                        %{--</g:form>--}%
                    %{--</div>--}%
                </div>

                <div class="panel-body"  id="topicListDiv">
                    <ls:publicTopicCreatedByUser userId="${params.id}" />
                </div>
            </div>

        </div>
       <div class="col-md-6">
        <div class="panel panel-default">
            <div class="panel-heading">Posts Created By ${user?.name?.toUpperCase()}
                %{--<div style="float: right">--}%
                    %{--<g:form name="search" class="form-group" controller="search" action="search">--}%
                        %{--<g:textField name="searchText" placeholder="search"/>--}%
                        %{--<g:submitButton name="finder" value="search"/>--}%
                    %{--</g:form>--}%
                %{--</div>--}%
            </div>

            <div class="panel-body" id="publicPost" >
                <ls:publicPost userId="${params.id}" />
            </div>
        </div>

       </div>
    </div>
</div>
%{--<script> $("a.navbar-brand").click(function(){--}%
    %{--$(this).attr('href',"${createLink(controller:'login',action: 'login',absolute: true)}");--}%
%{--});</script>--}%
</body>
</html>