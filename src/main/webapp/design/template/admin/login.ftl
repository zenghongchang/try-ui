<#include "common/vars.ftl"/>
<#import "micro/spring.ftl" as spring/>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="author" content="t-r-y Inc. Dev Team">
    <meta name="description" content="t-r-y Inc.">
    <#assign title = "HNUST">
	<title>${title}</title>
    <link type="text/css" href="${cssPath}common/materialize.min.css" rel="Stylesheet">
    <link type="text/css" href="${cssPath}common/font-awesome.min.css" rel="Stylesheet">
    <link type="text/css" href="${cssPath}app/home_page.css?version=${version}" rel="Stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="${jsPath}plugins/jquery/jquery-1.11.1.min.js?version=${version}" type="text/javascript"></script>
</head>
<body style="background-color: rgba(255, 255, 240, 0.44); width: 1519px; height: 276px; margin-top: -60px;">
	<div id="app">
		<div class="hello container" id="container" data-v-549a8a80="">
			<div class="row" data-v-549a8a80="">
				<div style="height: 338px;" class="col s12 row" id="bg-pic" data-v-549a8a80="">
					<img class="center-align height-fix" src="design/static/images/cover_1.8027e65.png" data-v-549a8a80="">
				</div>
			</div>
			<div style="position: relative;" class="row" data-v-549a8a80="">
				<form style="height: 138px;" class="col s4 " id="code-input" data-v-549a8a80="">
					<div class="row" data-v-549a8a80="">
						<div class="input-field col s12" data-v-549a8a80="">
							<i class="material-icons prefix" data-v-549a8a80="">loyalty</i><input class="validate" id="icon_prefix" placeholder="请输入图片提取码～" data-v-549a8a80="" type="text"><label class="active" for="icon_prefix" data-v-549a8a80="">提取码</label>
						</div>
					</div>
					<a class="" id="send-code" href="#" data-v-549a8a80=""><i class="material-icons" data-v-549a8a80="">navigation</i></a>
				</form>
				<div class="col s12 center-align" id="author" data-v-549a8a80="">
					<span data-v-549a8a80="">—&nbsp;</span> QMeiZi
				</div>
			</div>
		</div>
	</div>
</body>
</html>