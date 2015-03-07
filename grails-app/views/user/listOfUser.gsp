

<%@ page contentType="text/html;charset=UTF-8" %>
<head >
    <meta name="layout" content="header"/>
    <title>UserDetails</title>
</head>
<html>
<head>
  <title></title>
</head>
<body>
<div class="col-md-12">
<div  class="panel-default">
    <div class="panel-heading">
        Users
        <div style="margin-left:50%; margin-top: -2%;display: inline-block">
        <g:form controller="user" action="show">
        <g:select name="user" from="['Alluser','Active','Deactive']"  ></g:select>
            <g:submitButton name="search" value="search"></g:submitButton>
            </g:form>
        </div>
        <div style="float: right">
            <g:form name="search" class="form-group" controller="search" action="search">
                <g:textField name="searchText"  placeholder="search"/>
                <g:submitButton name="finder" value="search"/>
            </g:form>

        </div>

    </div>
    </div>
    </div>
</body>
</html>