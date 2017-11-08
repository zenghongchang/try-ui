<#include "common/head.ftl">
<body>
	<header class="tpmc_header">
		<div class="tpmc_head_div"><a href="/"><img src="${imagesPath}tpmc_tomtop.png " alt=""></a></div><ul class="head_ul">
			<li class="lf  "> </li>	

			<li class="rt tpmc_li_else"><a href="/logout"><b class="tpmc_fold dis_16_b"></b></a></li>
			<li class="rt"><span class="tongtuo tpmc_color_bai"><@spring.message  "tomtop.com"/></span><b class="tpmc_down dis_16_b12"></b></li>
			<li class="rt head_li  ">
				<img class="header_img" src="${imagesPath}leader.png">
			</li>
			<!--li class="rt  head_li head_li_else">
				<input type="text" placeholder="Search" class="input240 search">
				<b class="tpmc_search dis18"></b>
			</li-->
		</ul>
	</header>
    <!--左边菜单按钮-->
    <#include "common/left-menu.ftl"/>	