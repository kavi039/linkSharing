$(document).ready(function() {
$("a[title='sendInvitation']").click(function(){
    $("#showPop").toggle()})
    $("a[title='comment']").click(function(){
       $("#createTopic").toggle()
    })
    $("a[title='document']").click(function(){
        $("#documentShare").toggle()
    })
    $("a[title='linkresource']").click(function(){
        $("#linkShare").toggle()
    })
});















//.animate({
//    opacity: 0.25,
//    left: "+=50",
//    height: "toggle"
//}, 5000