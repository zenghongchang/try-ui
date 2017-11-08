<#include "page/vars.ftl"/>
<#include "page/header.ftl"/>
<#include "page/left-menu.ftl"/>
<!--对应的业务功能内容-->
<aside class="fbtShang_aside_r dis_ib">
<div class="middles" id="content" >
	<div class="content-header" style="visibility: visible;">
	    <table cellspacing="0">
	        <tbody>
	            <tr>
	                <td>
	                    <h3 id="icon-head">
		                    <@spring.message "download.prefecture"/>
		                    <#if showHelp??>  
		      					<#include "../../page/html/main-content/help.ftl"/>
							</#if>
	                    </h3>
	                </td>
	                <td>
	                </td>
	            </tr>
	        </tbody>
	    </table>
	</div>
	<table cellspacing="1" cellpadding="0" border="0" style="width: 100%;" class="tableborder">
		<thead>
			<tr>
				<th><@spring.message "download.39.barcode"/></th>
			</tr>
		</thead>
		<tbody>
			<tr class="td-odd">
				<td style="padding: 5px;">
				   
					<a href="${basePath}download/barcode/3OF9_NEW.TTF">
						<span style="color:red"><@spring.message "click.download.39.barcode"/></span>
					</a>
					<div style="margin-top:5px;">
					    <img src="${imagesPath}/icons/notice-light.gif">
					    <@spring.message "download.39.barcode.note"/>
					</div>
				</td>
			</tr>
		</tbody>
	</table>
	<br>
	<iframe name="iframe_smtOrder" width="80%" height="1000" frameborder="0"></iframe>
</div>
</aside>
<#include "page/footer.ftl"/>