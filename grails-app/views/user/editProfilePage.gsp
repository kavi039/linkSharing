

<%@ page import="com.ttn.linkShare.User" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>EditProfilePage</title>
        <meta name="layout" content="header"/>
</head>

<body>
<div class="container">

    <div class="row" style="margin-top:10%">

        <span style="color:red"><g:message message="${flash.error}"></g:message></span>

        <div class="col-md-5">
            <div class="panel panel-default">
                <div class="panel-body">
                    <ls:user/>
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">Topic
                    <div style="float: right">
                        <g:textField name="search" placeholder="search"/>
                        <input type="button" id="finder" value="search">
                    </div>
                </div>

                <div class="panel-body">
                    <ls:topicCreatedByUSer/>
                </div>
            </div>
        </div>

        <div class="col-md-7">
            <div class="panel panel-default">
                <div class="panel-heading">Edit Profile
                </div>

                <div class="panel-body">
                    <g:uploadForm name="editProfile" controller="user" action="updateUserProfile">
                        <div class="form-group">
                            <label for="firstName">First Name:</label>
                            <g:textField name="firstName" class="form-control"/>
                        </div>

                        <div class="form-group">
                            <label for="lastName">Last Name:</label>
                            <g:textField name="lastName" class="form-control"/>
                        </div>

                        <div class="form-group">
                            <label for="username">Username:</label>
                            <g:textField name="username" class="form-control"/>
                        </div>

                        <div class="form-group">
                            <label for="photo">Upload Photo:</label>
                            <g:field type="file" name="photo" class="form-control"/>
                        </div>
                        <g:submitButton name="submit" class="btn btn-default" value="Update"/>

                    </g:uploadForm>
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">ChangePassword
                </div>
                <span style="color: blue"><g:message message="${flash.message}"/></span>
            <div class="panel-body">
                <g:form name="editProfile" controller="user" action="updateUserPassword">

                    <div class="form-group">
                        <label for="password">Password:</label>
                        <g:passwordField name="password" class="form-control"/>
                    </div>


                    <div class="form-group">
                        <label for="confirmPassword">ConfirmPassword:</label>
                        <g:passwordField name="confirmPassword" class="form-control"/>
                    </div>

                    </div>
                    <g:submitButton name="submit" class="btn btn-default" value="Update"/>

                </g:form>

            </div>
        </div>
    </div>
</div>
</body>
</html>