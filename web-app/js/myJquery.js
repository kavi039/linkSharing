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
        url = MarkAsRead;
        $.ajax({
            data: {resourceId: resourceId},
            url: url
        }).done(function (data) {
            obj.parent().parent().parent().slideUp(500).detach();
        });
    });
    $(".subscription").on('click', function () {
        var text1;
        var sendData;
        var objAnchor = $(this);
        var topicId = objAnchor.data('topic-id')
        var objSelect = $('#' + topicId)
        var url;
        var seriouness = objSelect.val();
        if (objAnchor.text() == "Subscribed") {
            url = Subscription;
            text1 = "UnSubscribed";
            sendData = {topicId: topicId, seriousness: seriouness}

        }
        else {
            url = UnSubscription;
            text1 = "Subscribed";
            sendData = {topicId: topicId};

        }
        $.ajax({
            data: sendData,
            url: url
        }).done(function (data) {
            if (data == "true") {
                objSelect.val(seriouness);
                objSelect.toggle();
                objAnchor.text(text1);
            }
            else {
                alert("Subscription not possible");
            }
        });
    });
   $('.caret').on('click',function(){
      $('.dropdown-menu').toggle();
   });


});















