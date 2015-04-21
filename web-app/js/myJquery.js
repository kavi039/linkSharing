$(document).ready(function () {
    $("a[title='sendInvitation']").on('click', function () {
        $("#sendInvitation").modal();
    });
    $(document).on('click', "#sendTopicInvitation", function () {
        $.ajax({
            data: $("form#envelopForm").serialize(),
            url: sendMail
        }).always(function (data) {
            if (data == "false") {
                alert('message has not  sent');
            }
            else {
                alert('message has been sent');
            }
            $('#sendInvitationOfTopic').hide();
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

    $(document).on('click', ".isRead", function () {
        var obj = $(this);
        var url;
        var objectText = obj.text().trim();
        var resourceId = $(this).data('resource-id');
        if (objectText == "Mark as Unread") {
            url = MarkAsUnread;
            title = "mark as read only if you have subscribed the topic";
        }
        else {
            url = MarkAsRead;
            title = "mark as unread";
        }
        $.ajax({
            data: {resourceId: resourceId},
            url: url
        }).done(function (data) {
            if (data.trim() == objectText) {
                alert("subscribe topic first");
            }
            obj.text(data);
            obj.attr('title', title);

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
    $('#caret1').on('mouseenter mouseleave', function () {
        $('.dropdown-menu').slideToggle(500);
    });
});


function setSeriousness(topicId, element) {
    $.ajax({
        data: {topicId: topicId, seriousness: element.value},
        url: SubscriptionUpdate
    }).done(function (data) {
        if (data == "true") {
            var divObject = $("div#message");
            $(document).ready(function () {
                alert("seriousness has changed");
            });
        }
        else {
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
            var divObject = $("div#message");
            $(document).ready(function () {
                alert("visibility has changed");
                window.location.reload();
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
    var parentObject = object.parent().parent().parent().parent().parent();
    var editableObject = $('.editable', parentObject);
    var topicName = editableObject.data('topic-name');
    var htmlOfElement = editableObject.parent().html();
    editableObject.parent().html("<div class='editable'><input type='text' id='topicNameAdded' value=" + topicName + "><input type='button' id='myEdit' value='save'><input type='button' id='closeEdit' value='cancel'></div>");
    object.parent().html('<a href="javascript:void(0)"  class="glyphicon glyphicon-edit" ></a>');
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
        window.location.reload();
    });
}

function sendInvitation(topicId, topicName) {
    $('#sendInvitationOfTopic').modal();
    $("input#topic").val(topicName);
    $("input#topicId").val(topicId);
    $(document).on('click', "#sendMail", function () {
        $.ajax({
            data: $("form#formSendMail").serialize(),
            url: sendMail
        }).always(function (data) {
            if (data == "false") {
                alert('message has not  sent');
                $('#sendInvitationOfTopic').hide();
            }
            else {
                alert('message has been sent');
            }

        });
    });
}

$(document).on('click', '.editResource', function () {
    var modal = $(this).data('toggle');
    $("#" + modal).modal();
});

$(document).on('click', '.deleteResource', function () {
    var object = $(this);
    $('#deleteResource').modal();
    $(document).on('click', '.delete', function () {
        var resourceId = object.data('resource-id');
        $.ajax({
            data: {resourceId: resourceId},
            url: resourceDelete
        }).done(function (data) {
            $("div.resourceRating").slideUp().detach();
        });
    });
    $(document).on('click', '.cancel', function () {
        $('#deleteResource').modal('hide');
    })
});


$(document).ready(function () {
    $("form#loginForm").validate({
        errorPlacement:function(error,element){
            error.css('color','red');
            error.insertBefore(element);
        },
        rules: {
            password: {
                required: true,
                minlength: 4
            },
            email: {
                required: true
            }
        },
        messages: {
            password: {
                required: "please enter your password",
                minlength: jQuery.format("At least {0} characters required! and Maximum 10")
            },
            email: {
                required: "Your UserName Or Email Address Can not be empty"
            }
        }
    });
    $("form#registerForm").validate({
        errorPlacement:function(error,element){
            error.css('color','red');
            error.insertBefore(element);
        },
        rules: {
            password: {
                required: true,
                minlength: 4
            },
            confirmPassword: {
                required: true,
                minlength: 4
            },
            email: {
                required: true,
                email: true
            },
            username: {
                required: true
            }
        },
        messages: {
            password: {
                required: "please enter your password",
                minlength: jQuery.format("At least {0} characters required! and Maximum 10")
            },
            email: {
                required: "Your UserName Or Email Address Can not be empty",
                email: "kindly enter valid emailAddress"
            },
            username: {
                required: "Username can not be empty"
            },
            confirmPassword: {
                required: "can not be empty",
                minlength: jQuery.format("At least {0} characters required! and Maximum 10"),
            }
        }
    });
    $("form#forgetPassword").validate({
        errorPlacement:function(error,element){
            error.css('color','red');
            error.insertBefore(element);
        },
        rules: {
            email: {
                required: true
            }
        },
        messages: {
            email: {
                required: "enter valid email/username"
            }
        }
    });
});
