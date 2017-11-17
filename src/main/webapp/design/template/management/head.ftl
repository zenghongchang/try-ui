<#import "micro/spring.ftl" as spring/>
<#include "page/vars.ftl"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xml:lang="utf-8" xmlns="http://www.w3.org/1999/xhtml" lang="utf-8">
<head>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="author" content="t-r-y Inc. Dev Team">
    <meta name="description" content="t-r-y Inc.">
    <link type="image/x-icon" href="${imagesPath}favicon.ico" rel="shortcut icon">
    <#assign title = "Laboratory">
	<title>${title}</title>
    <link type="text/css" href="${cssPath}management/style.css?version=20171117" rel="Stylesheet">
    <script src="${jsPath}plugins/jquery/jquery.js?version=20171117" type="text/javascript"></script>
    <script src="${jsPath}plugins/jquery/jquery.mCustomScrollbar.concat.min.js?version=20171117" type="text/javascript"></script>
    <script src="${jsPath}app/management/pie.js?version=20171117" type="text/javascript"></script>
    <script src="${jsPath}app/management/serial.js?version=20171117" type="text/javascript"></script>
    <script src="${jsPath}app/management/management_main.js?version=${version}" type="text/javascript"></script>
    <script src="${jsPath}app/management/Particleground.js?version=20171117" type="text/javascript"></script>
    <script src="${jsPath}app/management/verificationNumbers.js?version=20171117" type="text/javascript"></script>
</head>