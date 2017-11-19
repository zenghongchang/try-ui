<#macro pagination formId>
	<#assign currentPage = pager['currentPage'] >
	<#assign totalPages = pager['totalPages'] >
	<#assign pageLimit = pager['pageLimit'] >
	<#assign totalRecords = pager['totalRecords']>
	<#assign showPages = 10 >
	<#assign pageSizeList = [20,40,60,80,100]>  
	<form>
		<#if currentPage == 1>
	        <a href="#"><@spring.message "first.page"/></a>
	        <a href="#">&laquo;</a>
	    <#else>
	        <a href="javascript:void(0);" onclick="turnPage('0','${formId}','1')"><@spring.message "first.page" /></a>
	    	<a href="javascript:void(0);" onclick="turnPage('-1','${formId}','${currentPage}')">&laquo;</a>
	    </#if>
	    <#if currentPage - showPages / 2 gt 0>  
	        <#assign start = currentPage - (showPages - 1) / 2/>  
	        <#if showPages gt totalPages>  
	            <#assign start = 1/>  
	        </#if>  
	    <#else>  
	        <#assign start = 1/>  
	    </#if>		         
	    <#if totalPages gt showPages>  
	        <#assign end = (start+showPages - 1)/>  
	        <#if end gt totalPages>  
	            <#assign start = totalPages - showPages + 1/>  
	            <#assign end = totalPages/>  
	        </#if>  
	    <#elseif totalPages == 0>
	        <#assign end = 1/>
	    <#else>  
	        <#assign end = totalPages/>  
	    </#if>		          
	    <#assign pages = start..end/>  
	    <#list pages as page>  
	        <#if page == currentPage>  
	            <a href="javascript:void(0);" onclick="turnPage('0','${formId}','${page}')">${page}</a>
	        <#else>  
	            <a href="javascript:void(0);" onclick="turnPage('0','${formId}','${page}')">${page}</a>
	        </#if>  
	    </#list>
	    <#if currentPage == totalPages || totalPages == 0>  
	    	<a href="#">&raquo;</a>
	    	<a href="#"><@spring.message "last.page"/></a>
	    <#else>
	        <a href="javascript:void(0);" onclick="turnPage('1','${formId}','${currentPage}')">&raquo;</a>
	        <a href="javascript:void(0);" onclick="turnPage('0','${formId}','${totalPages}')"><@spring.message "last.page" /></a>
	    </#if>
	   	<span><@spring.message "show"/></span>
	   	<select id="pageLimit" onchange="turnPage('0','${formId}','1')" style="width:50px;">     
	   		<#list pageSizeList as pageSize>
	             <#if pageLimit == pageSize>
	                  <option selected="selected" value="${pageSize}">${pageSize}</option>
	             <#else>
	                  <option value="${pageSize}">${pageSize}</option>
	             </#if>
	        </#list>
	   	</select>
	   	<@spring.message "row"/>
	   	<span class="separator"></span>
	   	<span><@spring.message "total"/></span> <span id="totalPages">${totalPages!'0'}</span> <span><@spring.message "page"/></span> 
	   	<span class="separator">|</span>
	   	<span id="totalRecords">${totalRecords!'0'}</span><span><@spring.message "x.records"/></span>  
	</form>
</#macro>
<script type="text/javascript">
    function goToPage(event, formId) {
        var e = event ? event : window.event;
        if (e.keyCode == 13) {
            var currentPage = $("#currentPage").val();
            var totalPages = $("#totalPages").html().trim();
            if (!currentPage || isNaN(currentPage) || currentPage < 1) {
                currentPage = 1
            } else if (currentPage > totalPages) {
                currentPage = totalPages;
            } else {
                currentPage = parseInt(currentPage);
            }
            var pageLimit = $("#pageLimit").val();
            changePage(formId, currentPage, pageLimit);
        }
    };

    function turnPage(flag, formId, currentPage) {
        var pageLimit = $("#pageLimit").val();
        currentPage = parseInt(currentPage) + parseInt(flag);
        changePage(formId, currentPage, pageLimit);
    };

    function changePage(formId, currentPage, pageLimit) {
        if (!formId) {
            return false;
        }
        var formObj = document.getElementById(formId);
        var pageNoInput = document.createElement("input");
        pageNoInput.type = "hidden";
        pageNoInput.name = "currentPage";
        pageNoInput.value = currentPage;

        var pageSizeInput = document.createElement("input");
        pageSizeInput.type = "hidden";
        pageSizeInput.name = "pageLimit";
        pageSizeInput.value = pageLimit;

        formObj.appendChild(pageNoInput);
        formObj.appendChild(pageSizeInput);
        formObj.submit();
    };
</script>