<script>
    $(document).on('click', ".sort", function () {
        var object = $(this).parent();
        var userStatus = $('#userStatus').val();
        var searchByName = $('#searchByName').val();
        var sortBy = object.text().toString();
        jQuery.ajax({
            data: {userStatus: userStatus, searchByName: searchByName, arrange: sortBy},
            url: "${createLink(controller: 'search',action:"findUserList")}"
        }).done(function (data) {
            $('#data').html(data);
        });
    });

</script>

<div class="table-responsive">
    <table class="table">
        <thead>
        <tr>
            <th>id  <b class="caret sort"></b></th>
            <th>username  <b class="caret sort"></b></th>
            <th>email  <b class="caret sort"></b></th>
            <th>firstName  <b class="caret sort"></b></th>
            <th>lastName  <b class="caret sort"></b></th>
            <th>active  <b class="caret sort"></b></th>
            <th>Manage  <b class="caret sort"></b></th>
        </tr>
        </thead>


        <tbody>
        <g:each in="${userList}" var="user">
            <tr>
                <td>${user?.id}</td>
                <td>${user?.username}</td>
                <td>${user?.email}</td>
                <td>${user?.firstName}</td>
                <td>${user?.lastName}</td>
                <td id="${user?.id}"><g:if test="${user?.active}">Activated</g:if>
                <g:else>
                    Deactivated
                </g:else>
                </td>
                <td><g:if test="${user?.active}">
                    <input type="button" class="setActiveOrDeactive" data-user-id="${user.id}" value="Deactivated">
                </g:if>
                    <g:else>
                        <input type="button" class="setActiveOrDeactive" data-user-id="${user.id}" value="Activated">
                    </g:else></td>

            </tr>
        </g:each>
        </tbody>
    </table>
</div>



