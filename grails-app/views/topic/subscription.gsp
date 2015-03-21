<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Subscription</title>
    <meta name="layout" content="header">
</head>

<body>
<div class="col-md-5">
    <div class="panel panel-default" >

        <div class="panel-heading">
            Topics   <span class="topicName"></span>
            %{--<div style="float: right">--}%
            %{--<g:textField name="searchText" placeholder="search" id="topicResult"/>--}%
            %{--<input type="button" name="finder" value="search" id="topicFindSubmitButton"/>--}%
            %{--</div>--}%
        </div>

        <div id="topicListDiv" style="overflow-y: scroll;height:500px " >
            <ls:subscribedTopicInAlphabeticalOrder/>
        </div>
    </div>
</div>


<div class="col-md-7">
    <div class="panel panel-default">

        <div class="panel-heading">
            Posts <span class="topicName"></span>
            %{--<div style="float: right">--}%
            %{--<g:form name="search" class="form-group" controller="search" action="search">--}%
            %{--<g:textField name="searchText" placeholder="search"/>--}%
            %{--<g:submitButton name="finder" value="search"/>--}%
            %{--</g:form>--}%
            %{--</div>--}%
        </div>

        <div class="panel-body" id="topicResourceDiv" style="overflow-y: scroll;height:500px " >
            <ls:topicSubscribedPost/>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
        $(document).on('click', '.topicToResource', function () {
            var object = $(this);
            var topicId = object.data('topic-id');
            var topicName = object.data('topic-name');
            $.ajax({
                data: {topicId: topicId},
                url:"${createLink(controller: 'search',action: 'resourceListByTopicName')}"
            }).done(function(data){
               $(".topicName").html(topicName);
                $("#topicResourceDiv").html(data);
            });
        });
    });
</script>
</body>
</html>


