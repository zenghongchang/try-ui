<#--
<@tpmcAuth name="edit">
	<input type="text"/>
</@tpmcAuth>
<@spring.message "manage.product"/>vdvdfv
<@spring.message "password.length.must.be.8.to.20"/>dfvdfv

<a href="/user/index?lang=es_US">切换1</a>
<a href="/user/index?lang=es_ES">切换2</a>-->

<#if agent??>
	<#include "agents/${agent}/home.ftl"/>
<#else>
	<#include "common/header.ftl"/>
	<#include "common/main.ftl"/>
	<#include "common/footer.ftl"/>
</#if>

