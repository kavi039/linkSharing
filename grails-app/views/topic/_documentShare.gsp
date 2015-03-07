<div class="panel panel-default">
    <div class="panel-heading">Share Document</div>
    <div class="panel-body">
        <g:uploadForm role="form" controller="documentResource" action="saveDocument" name="documentAdd">
            <div class="form-group">
                <label for="document">Document</label>
                <g:field type="file" name="document" class="form-control"/>
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