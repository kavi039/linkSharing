
<g:if test="${type}">
<a href="${createLink(controller:"resource",action: "downloadAction",params: [resourceId:resourceId])}"  title="resource type">Downloads</a>
</g:if>
<g:else>
<a href="${createLink(controller: "resource",action: "viewFullSite",params: [resourceId: resourceId])}" target="_blank"  title="resource type">ViewFull site</a>
</g:else>