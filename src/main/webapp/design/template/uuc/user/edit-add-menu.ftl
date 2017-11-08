<#if agent??>
	<#include "agents/${agent}/home.ftl"/>
<#else>
	<#include "common/header.ftl"/>
	
	<link type="text/css" href="${cssPath}user/tpmc_user_manage_xzhk.css?version=${version}" rel="Stylesheet">
	<link type="text/css" href="${cssPath}product/tpmc_wuliao_xinzeng.css?version=${version}" rel="Stylesheet">
	<!--对应的业务功能内容-->
	<#include "uuc/user/edit-add-menu-result.ftl"/>
	<#include "common/footer.ftl"/>
</#if>

