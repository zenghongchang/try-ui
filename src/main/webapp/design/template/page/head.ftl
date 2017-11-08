<#import "micro/spring.ftl" as spring/>
<#include "page/vars.ftl"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xml:lang="utf-8" xmlns="http://www.w3.org/1999/xhtml" lang="utf-8">
<head>
	<#assign title = "HNUST">
    <#assign lang = "cn">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="author" content="t-r-y Inc. Dev Team">
    <meta name="description" content="t-r-y Inc.">
    <link type="image/x-icon" href="${imagesPath}icons/favicon.ico" rel="shortcut icon">
    <title>${title}</title>
    <#--全局css规则设置-->	
	<link type="text/css" href="${cssPath}common/main.css" rel="Stylesheet">
	<#--全局js规则设置-->
	<script src="${jsPath}plugins/jquery/jquery-1.11.1.min.js?version=${version}" type="text/javascript"></script>
	<script src="${jsPath}plugins/jquery/jquery.nicescroll.js?version=${version}" type="text/javascript"></script>
	<script src="${jsPath}plugins/art-dialog/dialog.js?version=${version}" type="text/javascript"></script>
    <script src="${jsPath}package/package_${lang}.js?version=${version}" type="text/javascript"></script>
    <script src="${jsPath}plugins/My97DatePicker/WdatePicker.js?version=${version}" type="text/javascript"></script>
    <script src="${jsPath}app/page.js?version=${version}" type="text/javascript"></script>
	<script src="${jsPath}plugins/layer-v3.0.1/layer.js?version=${version}" type="text/javascript"></script>
	<script src="${jsPath}app/user/userOnlineTimer.js?version=${version}" type="text/javascript"></script>	
</head>