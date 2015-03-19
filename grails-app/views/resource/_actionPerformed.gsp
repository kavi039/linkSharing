<%@ page import="com.ttn.linkShare.DocumentResource" %>
<g:if test="${adminOrCreator}">
    <a href="javascript:void(0)" class="deleteResource" data-resource-id="${resource?.id}">Delete</a>
    <g:if test="${resource.getClass().equals(DocumentResource)}">
    <a href="javascript:void(0)" data-toggle="documentShare" class="editResource">Edit</a>
        </g:if>
    <g:else>
        <a href="javascript:void(0)" data-toggle="linkShare" class="editResource">Edit</a>
        </g:else>

    </g:if>