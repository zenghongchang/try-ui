<#if agent??>
	<#include "agents/${agent}/home.ftl"/>
<#else>
	<#include "common/header.ftl"/>
	<#--对应的业务功能内容-->
	<link rel="stylesheet" href="${jsPath}plugins/tree/ztree_css/demo.css?version=${version}" type="text/css">
	
	<#-- ace styles -->
	<link type="text/css" href="${cssPath}user/tpmc_user_manage_xzhk.css?version=${version}" rel="Stylesheet">

	<script src="${jsPath}app/user/group.js?version=${version}"></script>

	<#-- ztree start -->
	<link rel="stylesheet" href="${jsPath}plugins/tree/ztree_css/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="${jsPath}plugins/tree/ztree_js/jquery.ztree.core.js"></script>
	<script type="text/javascript" src="${jsPath}plugins/tree/ztree_js/jquery.ztree.excheck.js"></script>
	
	<#include "uuc/user/edit-add-group-result.ftl"/>
	<#include "common/footer.ftl"/>
</#if>

