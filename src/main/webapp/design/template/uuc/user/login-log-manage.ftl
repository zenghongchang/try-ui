<#if agent??>
	<#include "agents/${agent}/home.ftl"/>
<#else>
	<#include "common/header.ftl"/>
	<!--对应的业务功能内容-->
	<#include "uuc/user/login-log-list.ftl"/>
	<#include "common/footer.ftl"/>
</#if>
