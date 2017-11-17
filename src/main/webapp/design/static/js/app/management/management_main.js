$(document).ready(function () {
    //粒子背景特效
    $('body').particleground({
        dotColor: '#5cbdaa',
        lineColor: '#5cbdaa'
    });
    //验证码
    createCode();
});
$(document).on('click', '.submit_btn', function () {
    $("#loginForm").submit();
});