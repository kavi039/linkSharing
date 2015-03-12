<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><g:layoutTitle default="Grails"/></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <link href="${resource(dir: '/css', file: 'style.css')}" rel="stylesheet"/>

    <g:layoutHead/>


</head>

<body>
<div class="container col-md-12" style="border: solid;border-radius: 5px">
    <div class="col-md-2">
       <a href="${createLink(controller:'user',action: 'dashBoard')}"> <h1>LinkSharing</h1></a>
    </div>
    <div class="col-md-3" >
        <g:form name="search" class="form-group" controller="search" action="search">
            <g:textField name="searchText"  placeholder="search"/>
            <g:submitButton name="finder" value="search" />
        </g:form>

    </div>

    <div class="col-md-7">
        <g:if test="${session['username']}">
            <ls:isAdmin username="${session['username']}"/>
        </g:if>
    </div>





</div>
<script src="${resource(dir: "/js",file: 'jquery.min.js')}"></script>
<script src="${resource(dir: "/js",file: 'bootstrap.min.js')}"></script>
<script src="${resource(dir: "/js",file: 'bootstrap.js')}"></script>
<script src="${resource(dir: "/js",file: 'myJquery.js')}"></script>

<g:layoutBody/>
<script>
    var MarkAsRead,MarkAsUnread,ResourceByList;
   $(document).ready(function(){
      MarkAsUnread= "${createLink(controller: "readingItem", action: "markAsUnRead")}" ;
       MarkAsRead= "${createLink(controller: "readingItem", action: "markAsRead")}";
       Subscription="${createLink(controller: "topic",action: 'topicSubscription')}"
   });
</script>
</body>
</html>