<#import "micro/spring.ftl" as spring/>
<#include "common/vars.ftl"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xml:lang="utf-8" xmlns="http://www.w3.org/1999/xhtml" lang="utf-8">
    <#assign  version='1.0.3'/>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="author" content="Tomtop Inc. Dev Team">
    <meta name="description" content="Tomtop Inc.">
    <link type="image/x-icon" href="${imagesPath}icons/favicon.ico" rel="shortcut icon">
    <link type="text/css" href="${cssPath}common/common_color.css?version=${version}" rel="Stylesheet">
    <link type="text/css" href="${cssPath}common/header_common2.css?version=${version}" rel="Stylesheet">
	<link type="text/css" href="${cssPath}common/tpmc_common.css?version=${version}" rel="Stylesheet">
	<link type="text/css" href="${cssPath}common/validate.css?version=${version}" rel="Stylesheet">
	<link type="text/css" href="${cssPath}user/tpmc_user_manage.css?version=${version}" rel="Stylesheet">
    <#assign title = "TPMC System" >
    <#assign lang = "cn" >
	<title>${title}</title>
	<script src="${jsPath}plugins/jquery/jquery-1.11.1.min.js?version=${version}" type="text/javascript"></script>
	<script src="${jsPath}plugins/jquery/jquery.nicescroll.js?version=${version}" type="text/javascript"></script>
	<script src="${jsPath}plugins/art-dialog/dialog.js?version=${version}" type="text/javascript"></script>
    <script src="${jsPath}package/package_${lang}.js?version=${version}" type="text/javascript"></script>
    <script src="${jsPath}plugins/My97DatePicker/WdatePicker.js?version=${version}" type="text/javascript"></script>
    <script src="${jsPath}app/page.js?version=${version}" type="text/javascript"></script>
	<script src="${jsPath}plugins/layer-v3.0.1/layer.js?version=${version}" type="text/javascript"></script>
	<script src="${jsPath}app/user/userOnlineTimer.js?version=${version}" type="text/javascript"></script>
	
</head>
