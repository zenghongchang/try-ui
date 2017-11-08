$(function() {
	$(document).on('click', '.agree', function() {
		$(".lg_checkbox").toggleClass("lg_positon");
	})

	if ($("#upass_tip").html().trim() != "") {
		$('#upass_tip').show();
		$('#upass_tip').css("color", "#e94470");
		$('#upass_tip').css("display", "block");
		$('#bar_pass').css("backgroundColor", "#e94470");
	}
	if ($("#upass_tip2").html().trim() != "") {
		$('#upass_tip2').show();
		$('#upass_tip2').css("color", "#e94470");
		$('#upass_tip2').css("display", "block");
		$('#bar_pass2').css("backgroundColor", "#e94470");
	}

});

function indexHeight() {
	var bodyh = document.documentElement.clientHeight;
	var indexCbbodyh = bodyh - 253;
	$("#ys_box,.ys_div").css({
		"height" : indexCbbodyh + "px"
	});
}
indexHeight();

function changeKaptcha() {
	document.getElementById('kaptcha').src = "/kaptcha?t=" + Math.random();
}
var isNotError = true;
//用户名
function validName() {
	if ($("#uname").val().trim() == "") {
		$('#uname_tip').show();
		$('#uname_tip').text("请输入用户名");
		$('#uname').css("color", " #e94470");
		$('#bar_name').css("backgroundColor", " #e94470");
		isNotError = false;
	} else {
		$('#uname_tip').text("");
		$('#uname').css("color", " #383e40");
		$('#bar_name').css("backgroundColor", " #383e40");
		isNotError = true;
	}
}
//密码
function validCodee() {
	if ($("#upass").val().trim() == "") {
		$("#upass_tip").text("请输入密码");
		$('#upass_tip').css("color", "#e94470");
		$('#upass_tip').show();
		$('#bar_pass').css("backgroundColor", "#e94470");
		isNotError = false;
	} else {
		$("#upass_tip").text("");
		$('#upass_tip').css("color", "#6f7e83");
		$('#upass_tip').hide();
		$('#bar_pass').css("backgroundColor", "#6f7e83");
		isNotError = true;
	}
}

//验证码
function validAuthCode() {
	if ($("#upass2").val().trim() == "") {
		$("#upass_tip2").text("请输入验证码");
		$('#upass_tip2').css("color", "#e94470");
		$('#upass_tip2').show();
		$('#bar_pass2').css("backgroundColor", "#e94470");
		isNotError = false;
	} else {
		$("#upass_tip2").text("");
		$('#upass_tip2').css("color", "#6f7e83");
		$('#upass_tip2').hide();
		$('#bar_pass2').css("backgroundColor", "#6f7e83");
		isNotError = true;
	}
}

//登录按钮 验证
function validateAuthcode() {
	validAuthCode();
	if (isNotError) {
		validName()
		if (isNotError) {
			validCodee();
			if (isNotError) {
				$("#loginForm").submit();
			}
		}
	}
}

function valiAndlogin(e) {
	var eobj = window.event || e;
	if (eobj.keyCode == '13') {
		validateAuthcode();
	}
}