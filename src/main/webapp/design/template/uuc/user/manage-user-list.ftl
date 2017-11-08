<#include "common/vars.ftl"/> 
<table class="user_tab chanpin_xz_tab" style="clear: both;"  attr='{"totalPages":"${pager.totalPages}","totalRecords":"${pager.totalRecords}"}'>
	<tr class="user_tr_one">
		<th><div class="td_div1"><@spring.message "fbt.login.name" /></div> </th>
		<th><@spring.message "user.name" />  </th>
		<th><@spring.message "user.what.group" />  </th>
		<th><@spring.message "status" /> </th>
		<th><@spring.message "mobile.phone" />  </th>
		<th><@spring.message "sys.remark" />          </th>
		<th><@spring.message "created.date" />  </th>
		<th class="user_td"><@spring.message "operate" /></th>
	</tr>
	<#if pager?? && pager.pageList?? >
		<#assign datas = pager.pageList!'' />
	 	<#if datas?? && datas?size gt 0> 
			<#list datas as data>
				<tr id="tp_tr">
					<td colspan="7"></td>
				</tr>
				<tr>
					<td><div class="td_div1">${data.loginName!'' }</div></td>
					<td>${data.userName!'' }</td>
					<td>
						<#if maxGroup??>
							 ${ maxGroup[data.id?string] !''}
						</#if>
					</td>
					<td>
					<#if userStatu??>
						<#assign key = data.state?string />
						${ userStatu[key] }
					</#if> 
					</td>
					<td>${data.mobilePhone!'' }</td>
					<td>
						<img src="${imagesPath }hx_beizhu.png" onclick="showInfo('${data.sysRemark}','${data_index }')">
						<div id="result_remark_${data_index }" >
						
						</div>
				    </div>
				    </td>
					<td>${data.createDate?datetime!''}</td>
					<td>	
						<@tpmcAuth name="tpmc_user_manager_edit">					
							<span class="usr_icon_box pointer"><b class="user_edit dis_14 user_icon_com"></b><a href="editUser?id=${ data.id}"><span><@spring.message "edit" /></span></a></span>
						</@tpmcAuth>
						<@tpmcAuth name="tpmc_user_manager_del">
							<span onClick="deleteUser(${ data.id})" class="usr_icon_box pointer"><b class="ml_delete user_delete dis_14 user_icon_com"></b><span><@spring.message "delete" /></span></span>
						</@tpmcAuth>
					</td>
				</tr>
				</#list>
				</#if>	
				</#if>
			</table>
<script>		
	function showInfo(content,index){
		var d = dialog({
			content: content,
			quickClose: true// 点击空白处快速关闭
		});
		d.show(document.getElementById('result_remark_'+index));
	}
</script>