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
        if (obj.text().trim() == "Mark as Unread") {
            //   alert(obj.text()+">>"+resourceId);
            url = MarkAsUnread;
        }
        else {
            //   alert(obj.text()+">>"+resourceId);
            url = MarkAsRead;
        }
        $.ajax({
            data: {resourceId: resourceId},
            url: url
        }).done(function (data) {
            obj.text(data);
        });
    });


    //$(".isRead").on('click', function () {
    //    var obj = $(this);
    //    var url;
    //    var resourceId = $(this).data('resource-id');
    //    url = MarkAsRead;
    //    $.ajax({
    //        data: {resourceId: resourceId},
    //        url: url
    //    }).done(function (data) {
    //        if (data == "true") {
    //            obj.parent().parent().parent().slideUp(500).detach();
    //        }
    //        else {
    //            alert("Please subscribed first");
    //        }
    //    });
    //});
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
            // alert(seriouness);
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
    $('#caret1').on('click', function () {
        $('.dropdown-menu').toggle();
    });
});


function setSeriousness(topicId, element) {

    //alert(element.value+topicId);

    $.ajax({
        data: {topicId: topicId, seriousness: element.value},
        url: SubscriptionUpdate
    }).done(function (data) {
        if (data == "true") {
            object.val(element.value);
        }
        else
            alert("process fail");
    });
}
function setVisibility(topicId, element) {

    $.ajax({
        data: {topicId: topicId, visibility: element.value},
        url: TopicVisibilityUpdate
    }).done(function (data) {
        if (data == "true") {
            object.val(element.value);
        }
        else
            alert("process fail");
    });
}

//$(document).on('click', "#sendMail", function(){
//   // alert($("form#formSendMail").serialize());
//   // alert($("form").serialize());
//    $.ajax({
//       data:$("form#formSendMail").serialize(),
//        url:sendMail
//    }).done(function(){
//        alert("Invition has been send");
//    }).fail(function(){
//        alert("Invition has not send");
//    });
//});


function deleteTopic(topicId) {
    $.ajax({
        data: {topicId: topicId},
        url: deleteTopicDetail
    }).done(function (data) {
        if (data == "true") {
            window.location.reload();
        }
        else {
            alert("deletion not possible");
        }
    });
}
function editTopic(topicId,element) {
var object=$(element);
    var parentObject=object.parent().parent().parent().parent();
    var editableObject=$('.editable',parentObject);
   // alert(editableObject.text());
   var topicName=object.data('topic-name');
    editableObject.html("<input type='text' id='topicNameAdded1'  readonly value="+topicName+"><input type='button' id='myEdit' value='save'><input type='button' id='edit' value='cancel'>");

 alert($('#topicNameAdded1').val());
//});$('button#myEdit').click(function(){
//    alert("vhgvhvffhcffg");
//});
}

function sendInvitation(topicName) {
    $('#sendInvitationOfTopic').modal();
        $("input#topic").val(topicName);
    $(document).on('click', "#sendMail", function(){
    $.ajax({
       data:$("form#formSendMail").serialize(),
        url:sendMail
    }).done(function(){
        alert("Invition has been send");
    }).fail(function(){
        alert("Invition has not send");
    });
});

}





