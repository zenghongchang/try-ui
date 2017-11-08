<aside class="tpmc_aside_r  dis_ib">
<div class="tpmc_user_div" style="min-height: 100px;" >
				<table class="user_tab_1 tpmc_user_div_tab bc lf" border="0">
				<tr class="tpmc_xz_tr2">
					<td style="width: 17%"><@spring.message  "group.name"/></td>
					<td style="width: 17%"><@spring.message  "staff.level"/></td>
					<td style="width: 17%"><@spring.message  "group.code"/></td>
					<td style="width: 49%"><@spring.message  "created.date"/></td>
					
				</tr>
				<tr class="tpmc_xz_tr2 ">
					<td>
						<input type="text" class="xz_ml xz_input_com" name="groupName">
					</td>
					<td>
						<#assign map = staffLevel !''/>
						<select name="staffLevel" id="status" class="xz_select">
						 <option value="">---<@spring.message 'please.choose'/>---</option>
							<#list map?keys as key>
									<option  value="${key!''}">${ map[key]}</option>
							</#list>
						</select>
					</td>
					<td>
						<input type="text" class="xz_ml xz_input_com" name="code">
					</td>
					<td>
						<div class=" user_div_box">
							<span class="icon_box">
								<span class="dingwei_icon_box" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',el:'loginTime_from'})"><span class="dingwei_icon"></span></span>
								<input type="text" name="startCreateDate" class="user_div_1" id="loginTime_from">
							</span>
							<span class="dao_ml"><@spring.message  "to"/></span>
							<span class="icon_box">
								<span class="dingwei_icon_box" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',el:'loginTime_to'})"><span class="dingwei_icon"></span></span>
								<input type="text" name="endCreateDate" class="user_div_1" id="loginTime_to">
							</span>
						</div>
					</td>								
				</tr>
				<tr class="tpmc_xz_tr2 tr_add_poit dis_none">
				</tr>
				<tr class="tpmc_xz_tr" >
					<td colspan="5">
						<div class="tpmc_onload tx_c"> 
							<span class="tpmc_onload2">
								<img src="${imagesPath}fbt_xz.png">
								<span class="tp_more input_none" type="text" value="<@spring.message "pack.up.more.conditions"/>"><@spring.message "open.more.conditions"/></span>
							</span>
						</div>
					</td>
				</tr>
			</table>
			<table class="rt tab_btn">
				<tbody><tr>
					<td class="cg_xiugai_td_css"><a href="" class="lf btn68_chengse  xz_ml_div tpmc_search_button"><@spring.message "search"/></a></td>
				</tr>
				<tr>
					<td><a href="" class="lf btn68_gray tpmc_reset"><@spring.message "reset.filter"/></a></td>
				</tr>
				</tbody>
			</table>
		</div>
		<div >
			<#include "uuc/user/group-query.ftl">
		</div>
	    <section class="user_tab_box wl_guanli shang_tab_box">
	     	<#include "uuc/user/group-result.ftl">
	    </section>
	</aside>