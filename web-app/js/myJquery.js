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


    $(".isRead").on('click', function () {
        var obj = $(this);
        var url;
        var resourceId = $(this).data('resource-id');
      //  if (obj.text() == "Mark as Unread") {
           // url = MarkAsUnread;
      //  }
       // else {
            url=MarkAsRead;
       // }
        $.ajax({
            data: {resourceId: resourceId},
            url: url
        }).done(function (data) {
            //$('#inbox').html(data)
            obj.parent().parent().slideUp(500).detach();
           // alert(data);
           // obj.text(data);
        });
    });


});















