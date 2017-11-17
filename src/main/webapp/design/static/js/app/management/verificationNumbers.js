/**
 * 显示验证码
 * @param a
 */
function showCheck(a) {
    var c = document.getElementById("myCanvas");
    var ctx = c.getContext("2d");
    ctx.clearRect(0, 0, 1000, 1000);
    ctx.font = "80px 'Microsoft Yahei'";
    ctx.fillText(a, 0, 100);
    ctx.fillStyle = "white";
}
/**
 * 生成验证码
 */
function createCode() {
    $.ajax({
        type: "POST",
        url: "/kaptcha",
        data: {},
        dataType: "json",
        success: function (data) {
                if (data.success) {
                    showCheck(data.success);
                }
            },
            error: function () {

            }
    });
}
/**
 * 校验验证码
 * @returns {Boolean}
 */
function validate() {
    var inputCode = document.getElementById("J_codetext").value.toUpperCase();
    var codeToUp = code.toUpperCase();
    if (inputCode.length <= 0) {
        document.getElementById("J_codetext").setAttribute("placeholder", "输入验证码");
        createCode();
        return false;
    } else if (inputCode != codeToUp) {
        document.getElementById("J_codetext").value = "";
        document.getElementById("J_codetext").setAttribute("placeholder", "验证码错误");
        createCode();
        return false;
    } else {
        window.open(document.getElementById("J_down").getAttribute("data-link"));
        document.getElementById("J_codetext").value = "";
        createCode();
        return true;
    }
}