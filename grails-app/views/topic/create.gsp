<%--
  Created by IntelliJ IDEA.
  User: intelligrape
  Date: 5/3/15
  Time: 2:06 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Topic Create</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>

<body>
<div class="col-md-7"></div>
<div class="col-md-5">
<div class="panel panel-default">
    <div class="panel-heading">Create Topic</div>
    <div class="panel-body">
        <g:form role="form" controller="topic" action="saveTopic">
            <div class="form-group">
                <label for="email">Email address:</label>
                <g:textField name="email" id="email" class="form-control"/>
            </div>

            <div class="form-group">
                <label for="password">Password:</label>
                <g:passwordField name="password" id="password" class="form-control"/>
            </div>

            <g:submitButton name="submit" class="btn btn-default" value="Login"/>
        </g:form>

    </div>
</div>
</div>
</body>
</html>