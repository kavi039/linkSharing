$(document).ready(function () {
    $("a[title='sendInvitation']").on('click', function () {
        $("#sendInvitation").modal();
    });
    $("a[title='comment']").on('click', function () {
        $("#comment").modal();
    })
    $("a[title='document']").on('click', function () {
        $("#documentShare").modal();
    })
    $("a[title='linkresource']").on('click', function () {
        $("#linkShare").modal();
    });
    $("a[title='trendingTopic']").on('click', function () {
        $("#trendingTopic").modal();
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
            if (data == "true") {
                obj.parent().parent().parent().slideUp(500).detach();
            }
            else {
                alert("Please subscribed first");
            }
        });
    });
    $(".subscription").on('click', function () {
        var text1;
        var sendData;
        var objAnchor = $(this);
        var nextDiv = objAnchor.parent().next();
        var subscriptionCount = nextDiv.find('div.subscriptionCount')
        var topicId = objAnchor.data('topic-id');
        var objSelect = $('#' + topicId);
        var url;
        var seriouness = objSelect.val();
        if (objAnchor.text() == "Subscribe") {
            url = Subscription;
            text1 = "UnSubscribe";
            sendData = {topicId: topicId, seriousness: seriouness}

        }
        else {
            url = UnSubscription;
            text1 = "Subscribe";
            sendData = {topicId: topicId};
        }
        $.ajax({
            data: sendData,
            url: url
        }).done(function (data) {
            objSelect.val(seriouness);
            objAnchor.text(text1);
            subscriptionCount.text(data.count);
            window.location.reload();

        });
    });
    $('.caret').on('click', function () {
        $('.dropdown-menu').toggle();
    });

});


function editTopic(topicId) {
    alert(topicId);
}











