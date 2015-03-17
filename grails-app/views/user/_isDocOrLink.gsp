
<g:if test="${type}">
<a href="${createLink(controller:"resource",action: "downloadAction",params: [resourceId:resourceId])}">Downloads</a>
</g:if>
<g:else>
<a href="${createLink(controller: "resource",action: "viewFullSite",params: [resourceId: resourceId])}" target="_blank">ViewFull site</a>
</g:else>