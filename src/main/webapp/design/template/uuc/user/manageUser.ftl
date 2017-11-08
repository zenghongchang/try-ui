<#if agent??>
<#include "agents/${agent}/home.ftl"/>
<#else>
<#assign isHomePage = "true"/>
<#include "common/header.ftl"/>
<#include "common/left-menu.ftl"/>


<link type="text/css" href="${cssPath}user/tpmc_user_manage_xzhk.css?version=${version}" rel="Stylesheet">
<!--对应的业务功能内容-->
<#include "uuc/user/manage-user-search.ftl"/>
<script src="${jsPath}app/user/manageUser.js?version=${version}" type="text/javascript"></script>
<#include "common/footer.ftl"/>
</#if>
