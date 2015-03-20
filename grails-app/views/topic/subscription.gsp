<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Subscription</title>
    <meta name="layout" content="header">
</head>

<body>
<div class="col-md-5">
    <div class="panel panel-default">

        <div class="panel-heading">
            %{--Topic"${topic.name}"--}%
            Topics
            <div style="float: right">
                <g:textField name="searchText" placeholder="search" id="topicResult"/>
                <input type="button" name="finder" value="search" id="topicFindSubmitButton"/>
            </div>
        </div>

        <div id="topicListDiv">
            <ls:subscribedTopicInAlphabeticalOrder/>
        </div>
    </div>
    </div>


<div class="col-md-7">
    <div class="panel panel-default">

        <div class="panel-heading">
            Posts <span id="topicName"></span>

            <div style="float: right">
                <g:form name="search" class="form-group" controller="search" action="search">
                    <g:textField name="searchText" placeholder="search"/>
                    <g:submitButton name="finder" value="search"/>
                </g:form>
            </div>
        </div>

        <div class="panel-body" id="topicResourceDiv">
       <ls:topicSubscribedPost/>
        </div>
    </div>
</div>

</body>
</html>