<%--
  Created by IntelliJ IDEA.
  User: intelligrape
  Date: 28/2/15
  Time: 11:55 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><g:layoutTitle default="Grails"/></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

    <link href="${resource(dir:'/css',file: 'style.css' )}" rel="stylesheet"/>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <g:layoutHead/>
</head>

<body>
<div class="container col-md-12" style="border: solid;border-radius: 5px">
    <div class="col-md-2">
        <h1>LinkSharing</h1>
        </div>
    <div class="col-md-3">
<g:form name="search" class="form-group">
    <g:textField name="text" class="form-control" placeholder="search"/>
    <g:submitButton name="finder" value="search" class="btn btn-default"/>
</g:form>
</div>

   <div class="col-md-7">
               <g:if test="${session['username']}">
          <a href="#"  title="Create Topic"><img src="${resource(dir:'images', file:"Create.png")}" ></a>
          <a href="#" title="Add Document"><img src="${resource(dir: 'images', file: "addDo.png")}"></a>
          <a href="#" title="Attach linkresource"><img src="${resource(dir: 'images', file: "Attachment.png")}"></a>
            <a href="#" title="send invitation"><img src="${resource(dir: 'images', file: "send.png")}"></a>
            <a href="#" title="user Profile"><img src="${resource(dir: 'images', file: "User.png")}"></a>
                   <label class="user">${session['username']}</label>
           <div class="mylist" style="display: inline-block">

            <a href="#">Profile</a>
            <a href="#">Users</a>
            <a href="#">Topics</a>
            <a href="#">Posts</a>
            <a href="${createLink(controller:'login',action: 'logout')}" title="logout">Logout</a>
           </div>

    </div>
    </g:if>
</div>



</div>
<g:layoutBody/>
</body>
</html>