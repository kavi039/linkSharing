<%@ page contentType="text/html;charset=UTF-8" %>
<head>
    <meta name="layout" content="header"/>
    <title>UserDetails</title>
</head>
<html>
<head>
    <title></title>
</head>

<body>
<div class="col-md-12">
    <div class="panel-default">
        <div class="panel-heading">
            Users
            <div style="float: right">
                <g:select name="user" from="['Alluser', 'Active', 'Deactive']" id="userStatus"></g:select>
                <g:textField name="searchText" placeholder="search" id="searchByName"/>
                <input type="button" name="finder" value="search" id="userFindButton"/>
            </div>
        </div>

        <div id="data">

        </div>
        %{--<ul class="pagination">--}%
            %{--<li><a href="#">&laquo;</a></li>--}%
            %{--<li class="active"><a href="#">1</a></li>--}%
            %{--<li class="disabled"><a href="#">2</a></li>--}%
            %{--<li><a href="#">3</a></li>--}%
            %{--<li><a href="#">4</a></li>--}%
            %{--<li><a href="#">5</a></li>--}%
            %{--<li><a href="#">&raquo;</a></li>--}%
        %{--</ul>--}%

    </div>
</div>

<script>
    $(document).on('click', '#userFindButton', function () {
        var userStatus = $('#userStatus').val();
        var searchByName = $('#searchByName').val();
        //  alert(userStatus + " --- " + searchByName)

        jQuery.ajax({
            data: {userStatus: userStatus, searchByName: searchByName},
            url: "${createLink(controller: 'search',action:"findUserList")}"
        }).done(function (data) {
            //  alert(data);
            $('#data').html(data);
        });
    });
//    $(document).ready(function () {
//        $('').click(function () {
//
//        })
//    });


    $(document).on('click', '.setActiveOrDeactive', function () {
        var userId = jQuery(this).data('user-id');
        var obj = $(this)
        // alert(">>>>>>>>>>>>>>>>"+userId+"____"+userStatus);
        jQuery.ajax({
            data: {userId: userId},
            url: "${createLink(controller: 'user',action:"updateUserByActivation")}"
        }).done(function (data) {
            if (data == "true") {
                obj.val('Deactivated');
                obj.parent().prev().html("Activated");
            }
            else {
                obj.val('Activated');
               obj.parent().prev().html("Deactivated");
            }

        });
    });
</script>
</body>
</html>