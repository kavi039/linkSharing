<%@ page import="com.ttn.linkShare.User" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>EditProfilePage</title>
    <meta name="layout" content="header"/>
</head>

<body>
<div class="container">

    <div class="row">
            <g:if test="${flash.error}"><script>alert("${flash.error}");</script></g:if>
        <g:if test="${flash.message}"><script>alert("${flash.message}");</script></g:if>

        <div class="col-md-5">
            <div class="panel panel-default">
                <div class="panel-body">
                    <ls:user username="${session['username']}" topic="${null}"/>
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">Topic
                    %{--<div style="float: right">--}%
                        %{--<g:textField name="search" placeholder="search"/>--}%
                        %{--<input type="button" id="finder" value="search">--}%
                    %{--</div>--}%
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
                  <%  User user=User.findByUsername("${session['username']}")%>
                    <g:uploadForm name="editProfile" controller="user" action="updateUserProfile">
                        <div class="form-group">
                            <label for="firstName">First Name:</label>
                            <g:textField name="firstName" class="form-control" value="${user?.firstName}"/>
                        </div>

                        <div class="form-group">
                            <label for="lastName">Last Name:</label>
                            <g:textField name="lastName" class="form-control" value="${user?.lastName}"/>
                        </div>

                        <div class="form-group">
                            <label for="username">Username:</label>
                            <g:textField name="username" class="form-control" value="${user?.username}"/>
                        </div>

                        <div class="form-group">
                            <label for="photo">Upload Photo:</label>
                            <g:field type="file" name="photo" class="form-control" />
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
                        <label for="oldPassword">OldPassword:</label>
                        <g:passwordField name="oldPassword" class="form-control"/>
                    </div>

                        <g:hiddenField name="username" class="form-control" value="${session['username']}"/>


                    <div class="form-group">
                        <label for="password">NewPassword:</label>
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