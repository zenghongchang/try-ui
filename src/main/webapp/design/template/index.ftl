<#if agent??>
	<#include "agents/${agent}/home.ftl"/>
<#else>
	<#include "page/header.ftl"/>
	<#include "page/main.ftl"/>
	<#include "page/footer.ftl"/>
</#if>
