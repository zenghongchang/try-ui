<body>
	<!--header-->
	<header>
		<h1><img src="${imagesPath}admin_logo.png"/></h1>
		<ul class="rt_nav">
			<li>
				<a href="http://www.mycodes.net" target="_blank" class="website_icon">站点首页</a>
			</li>
			<li>
				<a href="#" class="set_icon">账号设置</a>
			</li>
			<li>
				<a href="#" class="admin_icon">${currentUser.loginName!''}</a>
			</li>
			<li>
				<a href="login.html" class="quit_icon">安全退出</a>
			</li>
		</ul>
	</header>