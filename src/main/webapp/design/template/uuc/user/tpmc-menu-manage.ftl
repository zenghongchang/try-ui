<#if agent??>
	<#include "agents/${agent}/home.ftl"/>
<#else>
	<#include "common/header.ftl"/>
	
	<!--对应的业务功能内容-->
	<#include "uuc/user/tpmc-menu-list.ftl"/>
	<script src="/design/static/js/app/user/menu_edit_add.js?version=${version}" type="text/javascript"></script>
	<#include "common/footer.ftl"/>
</#if>
