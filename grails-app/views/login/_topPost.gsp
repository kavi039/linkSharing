
<g:each in="${resourceList}" var="resourceInstance">

    <div class="media">
        <div class="media-left">
            <a href="${createLink(controller: 'user',action: 'user',params:[id: resourceInstance?.user?.id] )}"> <img src="${createLink(controller: 'image', action: 'renderImage', params: [id: resourceInstance?.user?.id])}"
                                                                                                                      height="100px" width="100px"/></a>
        </div>
        <div class="media-body" >
            <a href="${createLink(controller: 'topic', action: 'topicShow', params: [topicName:resourceInstance?.topic?.id])}" style="display:block;">  <span  style="float: right">${resourceInstance?.topic?.name}</span></a>
            <p>${resourceInstance?.user?.name?.toUpperCase()}</p>
            <p>${"@${resourceInstance?.user?.firstName?.toLowerCase()}"}</p>
            <span style="float: right;color:#dd1144">Rating ${com.ttn.linkShare.ResourceRating.getScore(resourceInstance)}</span>
            <br>
            <p>
                ${resourceInstance?.description}
            </p>
            <br>
            <br>
            <a href="${createLink(controller: 'resource',action: 'post',params: [resourceId:resourceInstance?.id])}" style="display:block;">  <span  style="float: right">ViewPosts</span></a>

        </div>
    </div>
    <hr/>


</g:each>
<util:remotePaginate controller="resource" action="topPostAction" update="topPostDiv" total="${total}" max="${max}" />
<script>
    $(document).ready(function(){
   var object= $(".creatingOrder");
      object.on('change',function(){
        var currentValue=$(object).val();
          $.ajax({
              data:{dateOnWhichData:currentValue},
              url:"${createLink(controller: "search",action: "searchTopPostByDateCreated",absolute: true)}"
          }).done(function(data){
             // $("#topPostDiv").html(data);
          });

      });
    });
</script>