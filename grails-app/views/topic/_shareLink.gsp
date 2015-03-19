


<div class="modal fade" id="linkShare" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-hidden="true">×
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    Share Link
                </h4>
            </div>
            <div class="modal-body">
                <g:uploadForm role="form" controller="linkResource" action="saveLink" name="linkAdd">
                    <div class="form-group">
                        <label for="url">Link</label>
                        <g:textField  name="url" class="form-control"/>
                    </div>

                    <div class="form-group">
                        <label for="description">Description</label>
                        <g:textArea name="description" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="topicId">Topic</label>
                        <g:select from="${com.ttn.linkShare.Topic.list()}" name="topicId" optionKey="id" optionValue="name"/>
                    </div>
                    <g:if test="${resourceInstance}">
                        <input type="hidden" name="id" value="${resourceInstance?.id}">
                    </g:if>
                    <input type="reset" name="reset" value="cancel" class="btn btn-default"/>
                    <g:submitButton name="submit" class="btn btn-default" value="Save"/>
                </g:uploadForm>
            </div>
        </div>

    </div>
</div>
</div>
</div>
