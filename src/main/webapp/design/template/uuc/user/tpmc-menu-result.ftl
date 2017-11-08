<table class="user_tab chanpin_xz_tab" attr='{"totalPages":"${pager.totalPages}","totalRecords":"${pager.totalRecords}"}' style="clear: both;" >
				<tr class="user_tr_one">
					<th width="16%"><@spring.message  "menu.name"/></th>
					<th width="10%"><@spring.message  "address"/>(url)</th>
					<th width="10%"><@spring.message  "internationalization"/>key</th>
					<th width="10%"><@spring.message  "parent.menu"/></th>
					<th width="10%" class="shp_td_width"><@spring.message "creator"/></th>
					<th width="10%"><@spring.message  "created.date"/></th>
					<th width="10%"><@spring.message "operate"/></th>
				</tr>
				<tr id="tp_tr">
					<td colspan="7"></td>
				</tr>
				<#assign datas = pager.pageList!'' />
				<#if datas?size gt 0>
					<#list datas as data>
				<tr>
					<td>
						${data.menuName}
					</td>
					<td>
							${data.url}
					</td>
					<td title="${data.i18nKey}">
							<#assign i18nKey = data.i18nKey!'' />
							<@spring.message i18nKey/>
					</td>
					<td <#if parentNames??>title="${ parentNames[data.id?string]!''}"</#if>>
							<#if parentNames??>
							<#assign pname =  parentNames[data.id?string]!'' />
								<@spring.message pname/>
							</#if>
					</td>
					<td>
						<#if userMap??>
								${userMap[data.creater?string]}
								<div class="wl_record wl_note dis_14 pr2" id="wl_note">
								<input type="hidden" value="${data.sysRemark}" />
							</div><br>
							<#else>
								${data.creater}
								<div class="wl_record wl_note dis_14 pr2" id="wl_note">
								<input type="hidden" value="${data.sysRemark}" />
							</div><br>
						 </#if></td> 
					<td>
							<#assign createTime = data.createDate?datetime!'' />
							<#assign times = createTime?split(" ") />
							<div>${times[0]!''} ${times[1]!''}</div>
					</td>
					<#-- <td class="pr">
							<div class="pr caozuo_div">
								<a class="wl_caozuo"><@spring.message "operate"/></a> 
								<b class="sanjiao"></b>
								<b class="guanli_line"></b>
								<ul class="wl_caozuo_pop dis_none">
									<li><a href="/user/editAddMenu?type=copy&id=${data.id}"><b class="dis_14  gl_com gl_price"></b><@spring.message "edit"/></a></li>
									<li><a href="/product/editAddMaterial?type=copy&id=${data.id}"><b class="dis_14  gl_com gl_copy"></b><@spring.message "delete"/></a></li>
									<li><b class="dis_14  gl_com gl_set"></b><@spring.message "编辑按钮"/></li>
									<li><b class="dis_14  gl_com gl_copy"></b><@spring.message "新增按钮"/></li>
								</ul>
							</div>
						</td>-->	
						<td>
						    <@tpmcAuth name="tpmc_user_center_menu_management_edit">
								<div style="height: 25px;"><span class="usr_icon_box pointer"><b class="user_edit dis_14 user_icon_com"></b><a href="/user/editAddMenu?id=${data.id}"><span><@spring.message "edit"/></span></a></span></div>
						    </@tpmcAuth>			
						      <@tpmcAuth name="tpmc_user_center_menu_management_edit">
							<div style="height: 25px;" ><span class="usr_icon_box pointer"><b class="user_edit user_copy dis_14 user_icon_com" style="margin-left: 0"></b><a href="/user/editAddMenu?id=${data.id}&&type=1"><span><@spring.message "create.sub.menu"/></span></a></span></div>
						    </@tpmcAuth>
						      <@tpmcAuth name="tpmc_user_center_menu_management_del">
							<div style="height: 25px;" onclick="deleteMenu('${data.id}')"><span class="usr_icon_box pointer"><b class="ml_delete user_delete dis_14 user_icon_com" style="margin-left: 0"></b><span><@spring.message "remove"/></span></span></div>		
						    </@tpmcAuth>		
						</td>
				</tr>
				</#list>
				</#if>
			</table>
			
			<script type="text/javascript">
    $(function(){
			$('.wl_record').on('click', function() {
			var msg = $(this).find("input").val();
            var d = dialog({
                quickClose: true,
                content: msg,
                follow: this,
            });
            d.show();
        });
        });
 </script>