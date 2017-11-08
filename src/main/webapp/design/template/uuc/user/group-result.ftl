<table class="user_tab chanpin_xz_tab" attr='{"totalPages":"${pager.totalPages}","totalRecords":"${pager.totalRecords}"}' style="clear: both;" >
				<tr class="user_tr_one">
					<th><div class="td_div1"><@spring.message  "group.name"/></div>   </th>
					<th><@spring.message  "staff.level"/></th>
					<th><@spring.message  "group.code"/></th>
					<th><@spring.message  "system.remark"/></th>
					<th><@spring.message  "created.date"/></th>
					<th class="user_td"><@spring.message "operate"/></th>
				</tr>
				<tr id="tp_tr">
					<td colspan="7"></td>
				</tr>
				<#assign datas = pager.pageList!'' />
				<#if datas?size gt 0>
					<#list datas as data>
				<tr>
					<td><div class="td_div1">${data.groupName}</div></td>
					<td>${staffLevel[data.staffLevel?string!'']!''}</td>
					<td>
						${data.code}
					</td>
					<td>
						<div class="wl_record wl_note dis_14 pr2" id="wl_note">
								<input type="hidden" value="${data.sysRemark}" />
							</div><br>
					</td>
				
					<td>${data.createDate?datetime!''}</td>
					<td>		
						<@tpmcAuth name="tpmc_user_management_group_edit">
							<span class="usr_icon_box pointer"><b class="user_edit dis_14 user_icon_com"></b><a href="/user/editAddGroup?id=${data.id}"><span><@spring.message "edit"/></span></a></span>
						</@tpmcAuth>	
						<@tpmcAuth name="tpmc_user_management_group_del">
							<span onClick="deleteGroup(${ data.id})" class="usr_icon_box pointer"><b class="ml_delete user_delete dis_14 user_icon_com"></b><span><@spring.message "tpmc.del"/></span></span>
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