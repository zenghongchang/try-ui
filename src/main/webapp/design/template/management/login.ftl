<#include "page/vars.ftl"/>
<#import "micro/spring.ftl" as spring/>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="utf-8">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <meta name="author" content="t-r-y Inc. Dev Team">
	    <meta name="description" content="t-r-y Inc.">
	    <link type="image/x-icon" href="${imagesPath}favicon.ico" rel="shortcut icon">
	    <#assign title = "Laboratory">
		<title>${title}</title>
	    <link type="text/css" href="${cssPath}management/style.css?version=20171117" rel="Stylesheet">
	    <script src="${jsPath}plugins/jquery/jquery.js?version=20171117" type="text/javascript"></script>
	    <script src="${jsPath}app/management/management-main.js?version=${version}" type="text/javascript"></script>
	    <script src="${jsPath}app/management/Particleground.js?version=20171117" type="text/javascript"></script>
	    <script src="${jsPath}app/management/verificationNumbers.js?version=20171117" type="text/javascript"></script>
		<script>
		    $(document).ready(function () {
		        //粒子背景特效
		        $('body').particleground({
		            dotColor: '#5cbdaa',
		            lineColor: '#5cbdaa'
		        });
		        //验证码
		        createCode();
		        //测试提交，对接程序删除即可
		        $(".submit_btn").click(function () {
		            location.href = "index.html";
		        });
		    });
		</script>
	</head>
	<body>
		<dl class="admin_login">
			<dt>
			  <strong>后台管理系统</strong>
			  <em>Management System</em>
		 	</dt>
			<dd class="user_icon">
				<input type="text" placeholder="账号" class="login_txtbx" />
			</dd>
			<dd class="pwd_icon">
				<input type="password" placeholder="密码" class="login_txtbx" />
			</dd>
			<dd class="val_icon">
				<div class="checkcode">
					<input type="text" id="J_codetext" placeholder="验证码" maxlength="4" class="login_txtbx">
					<canvas class="J_codeimg" id="myCanvas" onclick="createCode()">对不起，您的浏览器不支持canvas，请下载最新版浏览器!</canvas>
				</div>
				<input type="button" value="验证码核验" class="ver_btn" onClick="validate();">
			</dd>
			<dd>
				<input type="button" value="立即登录" class="submit_btn" />
			</dd>
			<dd>
				<p>© ${copyRight}-${copyRight} Henry 版权所有</p>
				<p></p>
			</dd>
		</dl>
	</body>
</html>
