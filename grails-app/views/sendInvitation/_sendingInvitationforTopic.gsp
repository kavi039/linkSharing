<div class="modal fade" id="sendInvitationOfTopic" tabindex="-1" role="dialog"
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
                <form id="formSendMail" class="form-group">
                    <label for="email">Email</label>
                    <g:textField  name="email" class="form-control" required="true"/>
                    <label for="topic">Topic</label>
                    <g:hiddenField name="topicId" />
                    <input type="text" name="topic"  id="topic" readonly/>
                    <a href="javascript:void(0)"  class="btn btn-default"  id="sendMail">send</a>
                </form>
            </div>
        </div>

    </div>
</div>
</div>
</div>

