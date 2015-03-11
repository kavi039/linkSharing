<div class="table-responsive">
    <table class="table">
        <thead>
        <tr>
            <th>id</th>
            <th>userName</th>
            <th>Email</th>
            <th>FirstName</th>
            <th>LastName</th>
            <th>Active</th>
            <th>Manage</th>
        </tr>
        </thead>


        <tbody>
        <g:each in="${userList}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td id="${user.id}"><g:if test=" ${user.active}">Activated</g:if>
                <g:else>
                    Deactivated
                </g:else>
                </td>
                <td><g:if test="${user.active}">
                    <input type="button" class="setActiveOrDeactive" data-user-id="${user.id}" value="Activated">
                </g:if>
                    <g:else>
                        <input type="button" class="setActiveOrDeactive" data-user-id="${user.id}" value="Deactivated">
                    </g:else></td>

            </tr>
        </g:each>
        </tbody>
    </table>
</div>



