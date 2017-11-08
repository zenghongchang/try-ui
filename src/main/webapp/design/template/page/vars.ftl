<#--全局变量声明-->
<#include "page/format.ftl">
<#assign basePath = "/">
<#assign basePathNoTail = "">
<#--JS/CSS/图片文件路径-->
<#assign cssPath = basePath + "design/static/css/">
<#assign jsPath = basePath + "design/static/js/">
<#assign imagesPath = basePath + "design/static/images/">
<#--版权信息声明-->
<#assign copyRight = (.now?string("yyyy"))/>
<#--版本信息声明-->
<#assign version = (.now?string("yyyyMMddmmhhss"))/>