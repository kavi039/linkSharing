<div class="panel panel-default">
    <div class="panel-heading">Share Link</div>
    <div class="panel-body">
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
                <label for="name">Topic</label>
                <g:select from="${com.ttn.linkShare.Topic.list().name}" name="name" />
            </div>
            <input type="reset" name="reset" value="cancel" class="btn btn-default"/>
            <g:submitButton name="submit" class="btn btn-default" value="Save"/>
        </g:uploadForm>

    </div>
</div>