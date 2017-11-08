<#if agent??>
	<#include "agents/${agent}/home.ftl"/>
<#else>
	<#include "common/header.ftl"/>
	
	<!--对应的业务功能内容-->
	<#include "uuc/user/group-list.ftl"/>
	<script src="${jsPath}app/user/group.js?version=${version}" type="text/javascript"></script>
	<#include "common/footer.ftl"/>
</#if>
