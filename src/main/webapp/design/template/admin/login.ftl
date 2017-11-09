<#include "page/vars.ftl"/>
<#import "micro/spring.ftl" as spring/>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="utf-8">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <meta name="author" content="t-r-y Inc. Dev Team">
	    <meta name="description" content="t-r-y Inc.">
	    <#assign title = "demo">
		<title>${title}</title>
	    <link type="text/css" href="${cssPath}app/index.css?version=${version}" rel="Stylesheet">
	    <script src="${jsPath}plugins/jquery/jquery-1.11.1.min.js?version=${version}" type="text/javascript"></script>
		<script>
			$('#login-button').click(function (event) {
				event.preventDefault();
				$('form').fadeOut(500);
				$('.wrapper').addClass('form-success');
			});
		</script>
	</head>
	<body>
		<div class="htmleaf-container">
			<div class="wrapper">
				<div class="container">
					<h1>Welcome</h1>
					<form class="form" action="login" method="post">
						<input type="text" name="username" autocomplete="off" placeholder="用户名">
						<input type="password" name="password" autocomplete="off" placeholder="密码">
						<button type="submit" id="login-button">登陆</button>
					</form>
				</div>
				<ul class="bg-bubbles">
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
				</ul>
			</div>
		</div>
	</body>
</html>