<div class="row">
               <div class="col-md-1">
                   id
               </div>

               <div class="col-md-2">
                   userName
               </div>

               <div class="col-md-2">
                   Email
               </div>

               <div class="col-md-1">
                   FirstName
               </div>

               <div class="col-md-2">
                   LastName
               </div>

               <div class="col-md-1">
                   Active
               </div>

               <div class="col-md-3">
                   Manage
               </div>
          </div>
<g:each in="${userList}" var="user">
    <div class="row">
               <div class="col-md-1">
                 ${user.id}
               </div>

               <div class="col-md-2">
                   ${user.username}
               </div>

               <div class="col-md-2">
                   ${user.email}
               </div>

               <div class="col-md-1">
                   ${user.firstName}
               </div>

               <div class="col-md-2">
                   ${user.lastName}
               </div>

               <div class="col-md-1" id="${user.id}">
                   ${user.active}
               </div>

               <div class="col-md-3" >
                   <g:if test="${user.active}">
                   <input type="button" class="setActiveOrDeactive" data-user-id="${user.id}"  value="Activated">
                   </g:if>
                   <g:else>
                       <input type="button" class="setActiveOrDeactive" data-user-id="${user.id}"  value="Deactivated">
                   </g:else>
               </div>
      </div>
</g:each>
