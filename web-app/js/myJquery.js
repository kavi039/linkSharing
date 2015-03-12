$(document).ready(function () {
    $("a[title='sendInvitation']").on('click', function () {
        $("#showPop").toggle()
    });
    $("a[title='comment']").on('click', function () {
        $("#createTopic").toggle()
    })
    $("a[title='document']").on('click', function () {
        $("#documentShare").toggle();
    })
    $("a[title='linkresource']").on('click', function () {
        $("#linkShare").toggle();
    });
    $("a[title='trendingTopic']").on('click', function () {
        $("#trendingTopic").toggle();
    });


    $(".isRead").on('click', function () {
        var obj = $(this);
        var url;
        var resourceId = $(this).data('resource-id');
            url=MarkAsRead;
        $.ajax({
            data: {resourceId: resourceId},
            url: url
        }).done(function (data) {
            obj.parent().parent().parent().slideUp(500).detach();
        });
    });
    $(".subscription").on('click',function(){
        var objAnchor=$(this);
        var topicId=objAnchor.data('topic-id')
        var objSelect=$('#'+topicId)
        var url=Subscription;
        var seriouness=objSelect.val()
        //alert(">>>>>>>"+topicId+">>>>"+seriouness+">>>>"+url);
        //$.ajax({
        //    data:{topicId:topicId,seriousness:seriouness},
        //    url:url
        //}).done(function(data){
        //    if(!data=="false")
        //    {
        //     alert(data)
        //    }
        //});
    });


});















