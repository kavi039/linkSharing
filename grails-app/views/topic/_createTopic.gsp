<div class="panel panel-default">
    <div class="panel-heading">Create Topic</div>
    <div class="panel-body">
<g:form role="form" controller="topic" action="saveTopic">
    <div class="form-group">
        <label for="name">Topic Name</label>
        <g:textField name="name" class="form-control"/>
    </div>

    <div class="form-group">
        <label for="visibility">Visibility</label>
       <g:select from="${com.ttn.linkShare.enums.Visibility.values()}" name="visibility"   class="form-control"/>
    </div>
     <input type="reset" name="reset" value="cancel" class="btn btn-default"/>
    <g:submitButton name="submit" class="btn btn-default" value="Save"/>
</g:form>

</div>
</div>