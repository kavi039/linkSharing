$(document).ready(function () {
    $("a[title='sendInvitation']").on('click', function () {
        $("#sendInvitation").modal();
    });
    $(document).on('click', "#sendTopicInvitation", function () {
        $.ajax({
            data: $("form#envelopForm").serialize(),
            url: sendMail
        }).always(function () {
            alert('message has been send');
        });
    });
    $("a[title='comment']").on('click', function () {
        $("#comment").modal();
    });
    $("a[title='document']").on('click', function () {
        $("#documentShare").modal();
    });
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
            url = MarkAsUnread;
        }
        else {
            url = MarkAsRead;
        }
        $.ajax({
            data: {resourceId: resourceId},
            url: url
        }).done(function (data) {
            obj.text(data);
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
    $.ajax({
        data: {topicId: topicId, seriousness: element.value},
        url: SubscriptionUpdate
    }).done(function (data) {
        if (data == "true") {
    var divObject=$("div#message");
            $(document).ready(function(){
        divObject.html("Seriouness has changed").css('background-color','yellow');
            $(divObject).slideToggle();
            setTimeout(function () {
                divObject.slideUp();
            }, 3000);
            });
        }
        else
        {
         alert("please subscribed first");
        }
    });
}
function setVisibility(topicId, element) {

    $.ajax({
        data: {topicId: topicId, visibility: element.value},
        url: TopicVisibilityUpdate
    }).done(function (data) {
        if (data == "true") {
            var divObject=$("div#message");
            $(document).ready(function(){
                divObject.html("Visibility has changed").css('background-color','yellow');
                $(divObject).slideToggle();
                setTimeout(function () {
                    divObject.slideUp();
                }, 3000);
            });
        }
        else
            alert("process fail");
    });
}
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
function editTopic(topicId, element) {
    var object = $(element);
    var parentObject = object.parent().parent().parent().parent();
    var editableObject = $('.editable', parentObject);
    var topicName = editableObject.data('topic-name');
    var htmlOfElement = editableObject.parent().html();
    editableObject.parent().html("<div class='editable'><input type='text' id='topicNameAdded' value=" + topicName + "><input type='button' id='myEdit' value='save'><input type='button' id='closeEdit' value='cancel'></div>");
    $(document).on('click', '#myEdit', function () {
        $.ajax({
            data: {topicId: topicId, topicName: $("#topicNameAdded").val()},
            url: topicNameUpdate
        }).done(function (data) {
            if (data == "true") {
                window.location.reload();
            }
            else {
                alert("topic name not updated");
            }
        });
    });
    $(document).on('click', '#closeEdit', function () {
        $('.editable', parentObject).parent().html(htmlOfElement);
    });
}

function sendInvitation(topicId,topicName) {
    $('#sendInvitationOfTopic').modal();
    $("input#topic").val(topicName);
    $("input#topicId").val(topicId);
    $(document).on('click', "#sendMail", function () {
        alert($("form#formSendMail").serialize());
        $.ajax({
            data: $("form#formSendMail").serialize(),
            url: sendMail
        }).always(function () {
            alert('message has been send');
        });
    });
}

$(document).on('click','.editResource',function(){
   var modal=$(this).data('toggle');
    $("#"+modal).modal();
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


