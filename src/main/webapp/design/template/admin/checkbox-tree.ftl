<#assign tree = apiTreeList>
<tr>
	<td>
		<div class="f-left">
			<#--	
			    <div id="main-system-firefox" style="display:none;">
			        <span >
			            <@spring.message "select.group.main.system"/>:&nbsp;&nbsp;
			        </span>
			        <#list tree as mainTreeLevel>
				        <#list mainTreeLevel['children'] as mainTreeTitle>
					        <input id="group.main.system_${mainTreeLevel['number']}" name="mainSystems" type="checkbox"  value="${mainTreeLevel['number']}" />
							<a hidefocus="on">
					        	<span unselectable="on"><@spring.message "${mainTreeTitle['title']}"/></span>
					        </a>
						</#list>
			        </#list>
			    </div>         
			   	<div id="use-firefox-notice" style="display:none;"><@spring.message "use.firefox.for.group.main.system.message"/>!</div>         -->
		    <div class="tree x-tree" id="resource-tree">
		        <ul id="ext-gen5" class="x-tree-root-ct x-tree-lines">
		            <div class="x-tree-root-node">
		                <li class="x-tree-node">
		                	<#list tree as firstTreeLevel>
		                	    <#list firstTreeLevel['children'] as firstTreeLevelTitle>
				                    <div class="x-tree-node-el  x-tree-node-collapsed">
				                        <span class="x-tree-node-indent"></span>
				                        <img src="${imagesPath}tree/spacer.gif" class="x-tree-ec-icon x-tree-elbow-plus">
				                        <img src="${imagesPath}tree/spacer.gif" class="x-tree-node-icon" unselectable="on">
				                        <input type="checkbox" ${firstTreeLevelTitle['checked']?string("checked=1", "")}  class="l-tcb group-system form-element" value="${firstTreeLevelTitle['value']}" name="${firstTreeLevelTitle['name']}">
				                           <span unselectable="on"><@spring.message "${firstTreeLevelTitle['title']}"/></span>
				                    </div>
				                     
				                    <#list firstTreeLevelTitle['children'] as secondTreeLevelTitle>
							             <ul class="x-tree-node-ct" style="display:none;">
							                <li class="x-tree-node">
							                    <div class="x-tree-node-el  x-tree-node-expanded">
							                        <span class="x-tree-node-indent">
							                            <img src="${imagesPath}tree/spacer.gif" class="x-tree-icon">
							                        </span>
							                    	<img src="${imagesPath}tree/spacer.gif" class="x-tree-ec-icon x-tree-elbow">
							                        <img src="${imagesPath}tree/spacer.gif" class="x-tree-node-icon" unselectable="on">
							                        <input type="checkbox" class="l-tcb" name="groupPermissions" value="${secondTreeLevelTitle['ormClass']}" <#if entity??><#if entity.apiGroupResourcesMap?? && (entity.apiGroupResourcesMap.size() > 0)> ${secondTreeLevelTitle['checked']?string("checked=1", "")} </#if></#if>/>
							                        <span unselectable="on"><@spring.message "${secondTreeLevelTitle['lang']}"/></span>
							                    </div>
							                </li>
							              </ul>
       						        </#list>
		    					</#list>
		                     </#list>
		                </li>
		            </div>    
		        </ul>
		    </div>
		</div>
	</td>
</tr>
<script>
    document.observe("dom:loaded", function() {
        $$('img.x-tree-ec-icon').each(function(current) {
            current.observe("click", function() {
                var up_div = current.up("div.x-tree-node-el");
                up_div.toggleClassName("x-tree-node-expanded");
                up_div.toggleClassName("x-tree-node-collapsed");
                up_div.nextSiblings().each(function(ul) {
                    if (ul.tagName == 'UL') {
                        ul.toggle();
                    } else {
                        throw $break;
                    }
                });
                current.toggleClassName("x-tree-elbow-plus");
                if (current.hasClassName("x-tree-elbow-end-minus")) {
                    current.toggleClassName("x-tree-elbow-end-minus");
                } else {
                    current.toggleClassName("x-tree-elbow-minus");
                }
            });
        });
        $$('input.l-tcb').each(function(current) {
            current.observe("click", function() {
                var sibling_checked = false;
                current.ancestors().each(function(ul) {
                    if (ul.tagName == 'UL') {
                        if (ul.previous("div")) {
                            var div = ul.previous("div");
                            if (div.hasClassName('x-tree-node-el')) {
                                div.nextSiblings().each(function(li_ul) {
                                    if (li_ul.tagName != 'UL') {
                                        throw $break;
                                    }
                                    li_ul.select('input.l-tcb').each(function(li_ul_cb) {
                                        if (li_ul_cb.checked) {
                                            sibling_checked = true;
                                            throw $break;
                                        }
                                    });
                                });
                                div.select('input.l-tcb').each(function(div_cb) {
                                    if (sibling_checked) {
                                        div_cb.checked = 1;
                                    } else {
                                        div_cb.checked = current.checked;
                                    }
                                });
                            }
                        }
                    }
                });
                $(this.parentNode).nextSiblings().each(function(ul){
                    if (ul.tagName != 'UL') {
                        throw $break;
                    }
                    ul.select("input.l-tcb").each(function(cb) {
                        cb.checked = current.checked;
                    });
                });
                var selectedSystems = $A();
                $$('.group-system').each(function(current) {
                    if (current.checked) {
                        selectedSystems.push(current.value);
                    }
                });
            });
        });
      	
    });

</script>
