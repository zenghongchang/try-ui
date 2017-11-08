<#include "page/vars.ftl"/>

<#function toggleInfo title info>
    <#local result = '<span class="window-position"><a title="click to see detail" style="position:relative;" onclick="showInfo(this);return false;">' + title + '</a><div class="window-info window-info-height" style="display: none;"><div style="clear:both">' + info + '</div></div></span>' >

    <#return result>
</#function>

<#function toggleMoreConfirmActions title>
    <#local result = '<a title="click to see more actions" style="position:relative;" onclick="showInfo(this);return false;">' + title + '</a><div class="hided-info" style="display: none;"><div style="clear:both">' + title + '</div></div>' >

    <#return result>
</#function>

<#function buildSelect options defaultValue style option="">
    <#local result = '<select ' + style + '>'>
    <#if option != "">
        <#local result = result + '<option value="' + option + '"></option>'>
    </#if>
    <#list options.keySet() as optionKey>
        <#if (defaultValue?? && optionKey?string == defaultValue?string)>
            <#assign selected = 'selected="selected"'>
        <#else>
            <#assign selected = ''>
        </#if>
        <#local result = result + '<option ' + selected + ' value="' + optionKey + '">' + options.get(optionKey) + '</option>' >
    </#list>
    <#local result = result + '</select>'>

    <#return result>
</#function>

<#function buildCheckbox options checkedValue id>
    <#local result = ''>
	    <#list options.keySet() as optionKey>
	     		<#assign checked = ''>
	     		<#if (checkedValue?trim) != ''>
	    		<#list checkedValue as defaultAreaIds>
	    			<#if defaultAreaIds?string == optionKey?string>
	    				<#assign checked = 'checked="checked"'>
	    			</#if>
	    		</#list>
	    		</#if>
	    	<#local result = result + '<input '+checked+' '+id+' type=checkbox value="'+optionKey +'">'+options.get(optionKey)>
	    </#list>
    <#return result>
</#function>

<#function productImageUrl url>
    <#if (url?index_of("http") == -1)>
        <#local url = basePathNoTail + url>
    </#if>
    <#return url>
</#function>

<#function tomtopcomcnImageUrl url>
    <#if (url?index_of("http") == -1)>
        <#local url = tomtopcomcnBaseUrlNoTail + url>
    </#if>
    <#return url>
</#function>

<#function skuColorByStock product stockId>
    <#local colorSku = product.sku>
    <#assign titleSku = "">
	<#if product?? && product.productStockMaps?? && (product.productStockMaps?size > 0)>
		<#list product.productStockMaps as productStock>
            <#if productStock.stockId == stockId>
                <#assign assignedCount = productStock.stockCount - productStock.assignedCount>
                <#assign title = "available:" + assignedCount + " due out:" + productStock.dueoutCount + " on way count:" + productStock.onWayCount + " quality testing:" + productStock.qtCount>
               <#if (assignedCount < (productStock.dueoutCount!0))>
                    <#if (assignedCount + productStock.qtCount>= productStock.dueoutCount!0)> <#-- 可用库存 + 在途 + 质检 < 待发 -->
                        <#local colorSku =  '<span title="' + title + '"><font color="deepskyblue">' + product.sku + '</font></span>'>
                    <#elseif (assignedCount + productStock.onWayCount>= productStock.dueoutCount!0) ><#-- 可用库存 +  质检 >= 待发 -->
                        <#local colorSku =  '<span title="' + title + '"><font color="orange">' + product.sku + '</font></span>'>
                    <#elseif (assignedCount + productStock.onWayCount + productStock.qtCount >= productStock.dueoutCount!0) ><#-- 可用库存 +  质检 >= 待发 -->
                        <#local colorSku =  '<span title="' + title + '"><font color="tomato">' + product.sku + '</font></span>'>
                    <#else>
                        <#local colorSku =  '<span title="' + title + '"><font color="red">' + product.sku + '</font></span>'>
                    </#if>
                <#else> <#-- 可用库存 > 待发 -->
                    <#local colorSku = '<span title="' + title + '">' +  product.sku + '</span>' >
                </#if>
                <#local titleSku = '<b> SKU <img src = "' + imagesPath + 'icons/saleStatus/' + productStock.saleStatus + '.gif"> : </b>'>
			</#if>			
		</#list>
        <#local colorSku = titleSku + colorSku />
		
		<#return colorSku>
	</#if>
    <#return product.sku>
</#function>

<#function saleStatusIcon product stockId>
	<#if product?? && product.productStockMaps?? && (product.productStockMaps?size > 0)>
		<#list product.productStockMaps as productStock>
            <#if productStock.stockId == stockId>
                <#local titleSku = '<img src = "' + imagesPath + 'icons/saleStatus/' + productStock.saleStatus + '.gif">'>
		        <#return titleSku>
			</#if>
		</#list>
    </#if>
		
	<#return "">
</#function>

<#function skuColorByProductStockMap productStockMaps sku stockId>
    <#local colorSku = sku>
    <#assign titleSku = "">
    ${productStockMaps}
	<#if productStockMaps?? && (productStockMaps?size > 0)>
		<#list productStockMaps as productStock>
            <#if productStock.get("stockId") == stockId>
                <#assign assignedCount = productStock.get("stockCount") - productStock.get("assignedCount")>
                <#assign title = "available:" + assignedCount + " due out:" + productStock.get("dueoutCount") + " on way count:" + productStock.get("onWayCount")>
                <#if (assignedCount < (productStock.dueoutCount!0))>
                    <#if ((assignedCount + productStock.get("qtCount")!0) >= (productStock.get("dueoutCount")!0))> <#-- 可用库存 + 在途 + 质检 < 待发 -->
                        <#local colorSku =  '<span title="' + title + '"><font color="deepskyblue">' + sku + '</font></span>'>
                    <#elseif ((assignedCount + productStock.get("onWayCount")) >= (productStock.get("dueoutCount")!0)) ><#-- 可用库存 +  质检 >= 待发 -->
                        <#local colorSku =  '<span title="' + title + '"><font color="orange">' + sku + '</font></span>'>
                    <#elseif ((assignedCount + productStock.get("onWayCount") + productStock.get("qtCount")!0) >= (productStock.get("dueoutCount")!0)) ><#-- 可用库存 +  质检 >= 待发 -->
                        <#local colorSku =  '<span title="' + title + '"><font color="tomato">' + sku + '</font></span>'>
                    <#else>
                        <#local colorSku =  '<span title="' + title + '"><font color="red">' + sku + '</font></span>'>
                    </#if>
                <#else> <#-- 可用库存 > 待发 -->
                    <#local colorSku = '<span title="' + title + '">' +  sku + '</span>' >
                </#if>
                <#local titleSku = '<b> SKU <img src = "' + imagesPath + 'icons/saleStatus/' + productStock.get("saleStatus") + '.gif"> : </b>'>
			</#if>
						
		</#list>
				
        <#local colorSku = titleSku + colorSku />
		
		<#return colorSku>
	</#if>
    <#return sku>
</#function>

<#function getOrderInfo typeTag typeValue defaultTitle="">
	<#if typeTag?? && typeValue??>
        <#local linkStirng  = "">
        <#if defaultTitle =="">
            <#local defaultTitle = typeValue>
        </#if>
        <#if typeTag == "buyerId">     
			<#local linkString = '<a target="_blank" href="/order/searchOrderByArgs?buyerId=' + typeValue + '">' + defaultTitle + '</a>'>
        <#elseif typeTag == "orderId">
			<#local linkString = '<a target="_blank" href="/order/searchOrder?id=' + typeValue + '">' + defaultTitle + '</a>'>
        <#elseif typeTag == "itemId">
			<#local linkString = '<a target="_blank" href="/order/searchOrderByArgs?itemId=' + typeValue + '">' + defaultTitle + '</a>'>
        <#elseif typeTag == "sku">
			<#local linkString = '<a target="_blank" href="/product/viewProduct?id=' + typeValue + '">' + defaultTitle + '</a>'>
        <#else>
            <#return linkString>
        </#if>
        <#return linkString>
    <#else>
        <#return "">
        
	</#if>
</#function>

<#function inPlaceEditor id value url formId param>
    <#local html = "">
    <#local html = "<div style='font-size: 14px;font-style: italic;' id='" + id + "'>" + value + "</div><span style='color: green;' id='" + id + "_result'></span> <script type='text/javascript'> helper.editor('" + id + "', '" + url + "', '" + formId + "', " + param + ", [], '');</script>">

    <#return html>
</#function>

<#function inPlaceEditorOption id value url formId param collections>
    <#local html = "">
    <#local html = "<div style='font-size: 14px;font-style: italic;' id='" + id + "'>" + value + "</div><span style='color: green;' id='" + id + "_result'></span> <script type='text/javascript'> helper.editor('" + id + "', '" + url + "', '" + formId + "', " + param + ", " + collections + ", '');</script>">

    <#return html>
</#function>

<#function uploadForm formId iframeName productCertificationId sku url buttonName>
    <#local html = "">
    <#local html = html + "<form id='" + formId + "' name='form_uploadPicture' method='post' action='' enctype='multipart/form-data' target='" + iframeName + "'>">
    <#local html = html + "<input type='hidden' name='uploadPictureId' value='" + productCertificationId + "'/>">
    <#local html = html + "<input type='hidden' name='sku' value='" + sku + "'/>">
    <#local html = html + "<input type='file' multiple='' id='uploadId_" + productCertificationId + "' name ='upload' theme='simple'/>">
    <#local html = html + "<button type='button' class='scalable' onclick='return helper.upload(\"" + formId + "\",\"" + url + "\",\"" + productCertificationId + "\" );'>">
    <#local html = html + "<span>" + buttonName + "</span>">
    <#local html = html + "</button>">
    <#local html = html + "<iframe height='50px' width='190px'; frameborder=0 name='" + iframeName + "'></iframe>">
    <#local html = html + "</form>">
    <#return html>
</#function>

<#macro moreActions actions>
<div class="menu">
  <ul>
    <li ><a class="hide" href=""><@spring.message "action"/></a>
      <ul>
        <li>${actions}</li>
      </ul>
    </li>
  </ul>
</div>
</#macro>
