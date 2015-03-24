<g:each in="${resourceList}" var="resourceInstance">
    <g:render template="../resource/display" model="[resourceInstance: resourceInstance]" />
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