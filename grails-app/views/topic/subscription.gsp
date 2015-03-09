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
            <ls:subscriptionTopic/>
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

        </div>
    </div>
</div>
<script>

    $(document).on('click', '.topicToResource', function () {
        var topicId = jQuery(this).data('topic-id');
        var topicName = jQuery(this).data('topic-name');

//        alert("topicId - " + topicId);
        jQuery.ajax({
            data: {id: topicId},
            url: "${createLink(controller: "topic", action: "resourceListByTopic")}"
        }).done(function (data) {
            jQuery('#topicName').html(topicName);
            jQuery('#topicResourceDiv').html(data);
        });
    });

    $(document).ready(function () {
        jQuery('.topicToResource:first').click();
    });

    $(document).on('click', '#topicFindSubmitButton', function () {
        var searchKey = jQuery('#topicResult').val();
        jQuery.ajax({
            data: {name: searchKey},
            url: "${createLink(controller: "search", action: "topicListByName")}"
        }).done(function (data) {
            jQuery('#topicListDiv').html(data);
        });
    });



</script>
</body>
</html>