<%@ page contentType="text/html;charset=UTF-8" %>
<%
def myService = grailsApplication.mainContext.getBean("tagService");
%>
<html>
<head>
    <title>Posts</title>
    <meta name="layout" content="header"/>
</head>

<body>
<div class="col-md-6 resourceRating">
    <div class="panel panel-default">

        <div class="panel-body">
            <div class="media">
                <div class="media-left">
                    <img src="${createLink(controller: 'image', action: 'renderImage', params: [id: resourceInstance?.user?.id])}"
                         height="100px" width="100px"/>
                </div>

                <div class="media-body">
                    <a href="${createLink(controller: 'topic', action: 'topicShow', params: [topicName: resourceInstance?.topic?.name])}"><span
                            style="float: right">${resourceInstance?.topic?.name}</span></a>

                    <span>${resourceInstance?.user?.name}</span>
                    <br>
                    <span>${"@${resourceInstance?.user?.firstName}"}</span>
                    <span style="float: right"><ls:dateFormat type="${resourceInstance?.dateCreated}"/></span>

                    <div class="rating-select parent" data-resource-Id="${resourceInstance.id}">
                        <a href="javascript:void(0)" class="rating" data-rating="1"><span
                                class="glyphicon glyphicon-star-empty"></span></a>
                        <a href="javascript:void(0)" class="rating" data-rating="2"><span
                                class="glyphicon glyphicon-star-empty"></span></a>
                        <a href="javascript:void(0)" class="rating" data-rating="3"><span
                                class="glyphicon glyphicon-star-empty"></span></a>
                        <a href="javascript:void(0)" class="rating" data-rating="4"><span
                                class="glyphicon glyphicon-star-empty"></span></a>
                        <a href="javascript:void(0)" class="rating" data-rating="5"><span
                                class="glyphicon glyphicon-star-empty"></span></a>
                    </div>
                    <br>
                    <br>
                    <span>${resourceInstance?.description}
                        <br>
                        <br>
                        <br>
                    </span>

                    <div><ls:resourceType type="${resourceInstance?.id}"/>
                    <ls:markAsRead type="${resourceInstance}"/>
                    <g:if test="${session['username']}">
                        <ls:adminOrCreatorOfResource resourceId="${resourceInstance?.id}"/>
                    </g:if>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
<div class="col-md-6">
    <g:if test="${session['username']}">
        <div class="panel panel-default" style="overflow-y: scroll;height: 500px">
              <div class="panel-heading" >TrendingTopic</div>

              <div class="panel-body">
        <ls:trendingTopic/>
        </div>
        </div>
        </g:if>
        <g:else>
          <g:render template="/login/login"></g:render>
            <g:render template="/login/register"></g:render>
        </g:else>
<g:render template="/resource/deleteResource"></g:render>

    </div>
<script>
    $("a.navbar-brand").click(function () {
        $(this).attr('href', "${createLink(controller:'user',action: 'dashBoard',absolute: true)}");
    });
    jQuery(document).ready(function () {
        %{--ratingFun(${com.ttn.linkShare.ResourceRating.findByResourse(resourceInstance).score});--}%
        ratingFun(${myService.getScore(resourceInstance)});
    })
    function ratingFun(score) {

        var object = $('a.rating');
        var i = 0;
        for(i=0;i<5;i++){
            $(object[i]).css('color',(i<score?'red':'blue'));
        }

    }
    $(document).on('click','.rating',function(){
        if( ${session['username']!=null}){
      var currentObject=$(this);
        var score=currentObject.data('rating');
        var resourceId=$(currentObject).parent().attr('data-resource-Id');
        $.ajax({
           data:{resourceId:resourceId,score:score} ,
            url: resourceRatingUpdate
        }).done(function(data){
    ratingFun(score);
        });}

    });
    $(document).on('click','.deleteResource',function(){
        var object=$(this);
       $('#deleteResource').modal();
        $(document).on('click','.delete',function(){
            var resourceId=object.data('resource-id');
            $.ajax({
                data:{resourceId:resourceId},
                url:  resourceDelete
            }).done(function(data){
                $("div.resourceRating").slideUp().detach();
            });
        })
        $(document).on('click','.cancel',function(){
            $('#deleteResource').modal('hide');
        })
    });

</script>
</body>
</html>