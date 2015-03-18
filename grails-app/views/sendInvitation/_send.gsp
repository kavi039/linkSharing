<%@ page import="com.ttn.linkShare.User" %>
<div class="modal fade" id="sendInvitation" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-hidden="true">×
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    Subscription
                </h4>
            </div>
            <div class="modal-body">
<form id="envelopForm" class="form-group">
<label for="email">Email</label>
<g:textField name="email" class="form-control"/>
<label for="topic">Topic</label>
<g:select name="topic" from="${com.ttn.linkShare.Subscription.findAllByUser(com.ttn.linkShare.User.findByUsername("${session['username']}")).topic.name}">
</g:select>
<a class="btn btn-default"  id="sendTopicInvitation">send</a>
</form>
</div>
</div>

            </div>
        </div>
    </div>
</div>































