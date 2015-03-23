
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Search Result</title>
    <meta name="layout" content="header"/>
</head>

<body>
<div class="col-md-5">
    <div class="panel panel-default">

        <div class="panel-heading">
            Trending Topics   <span class="topicName"></span>
        </div>

        <div style="overflow-y: scroll;height:500px ">
            <ls:trendingTopic/>
        </div>
    </div>

    <div class="panel panel-default">

        <div class="panel-heading">
            TopPosts   <span class="topicName"></span>
        </div>

        <div id="topPostDiv" style="overflow-y: scroll;height:500px ">
            <ls:topPost/>
        </div>
    </div>
</div>


<div class="col-md-7">
    <div class="panel panel-default">

        <div class="panel-heading">
            Posts <span class="topicName"></span>
        </div>
        <%"<<<<<<<<<<"+searchText%>
        <div class="panel-body" id="topicResourceDiv" style="overflow-y: scroll;height:500px ">

            <ls:searchResult text="${searchText}"/>
        </div>
    </div>
</div>
</body>
</html>