<%@ page import="com.ttn.linkShare.TagService; com.ttn.linkShare.User" %>
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
                    <input type="email" id="email" class="form-control" required="true"/>
                    <label for="topicId">Topic</label>
                    <g:select name="topicId"
                              from="${com.ttn.linkShare.Topic.topicListSubscribedByCurrentUser(''+session['username'])}" optionKey="id" optionValue="name">
                    </g:select>
                    <a class="btn btn-default" id="sendTopicInvitation">send</a>
                </form>
            </div>
        </div>

    </div>
</div>
</div>
</div>































