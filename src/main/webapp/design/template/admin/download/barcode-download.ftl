<#include "page/vars.ftl"/>
<#include "page/header.ftl"/>
<#include "page/left-menu.ftl"/>
<!--对应的业务功能内容-->
<aside class="fbt_aside_r dis_ib " id="fbt_xia_r">
			<div class="resolute_div1 div_else44">
				<ul class="shang_head_ul head_ul44 head_ml">
					<li class="resolute_selete resolute_seleted"><span><@spring.message "download.39.barcode"/></span></li>
					
				</ul>
			</div>
			<section class="fbt_geren_box">
				<div class="fbt_xiazai_div">
					<a href="${basePath}download/barcode/3OF9_NEW.TTF" class="btn180_gray tiaoxing  "><@spring.message "click.download.39.barcode"/></a>
					<div>
						<#--  说明：有些电脑没有安装39条形码，不能打印条形码，因此需要安装条形码之后才能使用。安装方式：下载39条形码，打开条形码，点击左上角“安装”按钮即可。-->
					</div>
				</div>
						<div class="fbt_xiazai_div2" style="color: #737b83;margin:auto 30px;"><@spring.message "download.39.barcode.note2"/></div>
			</section>
</aside>
	
	<link type="text/css" href="${cssPath}new/fbt_shangpingl.css?version=${version}" rel="Stylesheet">
	<link type="text/css" href="${cssPath}new/fbt_chanpin_piliang_xz_2.css?version=${version}" rel="Stylesheet">
	<link type="text/css" href="${cssPath}new/fbt_geren_xiazai.css?version=${version}" rel="Stylesheet">
<#include "page/footer.ftl"/>