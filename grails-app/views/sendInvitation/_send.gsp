<%@ page import="com.ttn.linkShare.enums.Visibility" %>

<div class="panel panel-default">
       <div class="panel-heading">Subscription</div>
       <div class="panel-body">


<g:form controller="sendInvitation" action="sendEmail" class="form-group">
    <label for="email">Email</label>
<g:textField name="email" class="form-control"/>
<label for="topic">Topic</label>
    <g:select name="topic" from="${com.ttn.linkShare.Topic.findAll().name}">
        </g:select>
    <g:submitButton class="btn btn-default" value="Send" name="send"/>
</g:form>
           </div>
</div>