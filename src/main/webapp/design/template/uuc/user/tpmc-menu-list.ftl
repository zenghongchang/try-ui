<aside class="tpmc_aside_r  dis_ib">
<div class="tpmc_user_div" style="min-height: 100px;" >
				<table class="user_tab_1 tpmc_user_div_tab bc lf" border="0">
				<tr class="tpmc_xz_tr2">
					<td style="width: 14%"><@spring.message  "menu.name"/></td>
					<td style="width: 14%"><@spring.message  "address"/>(url)</td>
					<td style="width: 14%"><@spring.message  "internationalization"/>key</td>
					<td style="width: 14%"><@spring.message "creator"/></td>
				</tr>
				<tr class="tpmc_xz_tr2 ">
					<td>
						<input type="text" class="xz_ml xz_input_com" name="menuName">
					</td>
					<td>
						<input type="text" class="xz_ml xz_input_com" name="url">
					</td>
					<td>
						<input type="text" class="xz_ml xz_input_com" name="i18nKey">
					</td>
					<td>
						<select name="creater" id="" class="xz_select">
						   <option value="">---<@spring.message  "please.choose"/>---</option>
						   <#list userMap?keys as key >
						     <option value="${key!''}">${userMap[key]!''}</option>
						   </#list>
						</select>
					</td>
				</tr>
				<tr class="tpmc_xz_tr2 tr_add_poit  user_ml dis_none" >
					<td><@spring.message  "parent.menu"/></td>
					<td><@spring.message  "created.date"/></td>
				</tr>
				<tr class="tpmc_xz_tr2 tr_add_poit dis_none">
				<td>
						<select name="parent" id="" class="xz_select">
						   <option value="">---<@spring.message  "please.choose"/>---</option>
						   	<#if allMenus?size gt 0>
							<#list allMenus as menu>
								 <option value=${menu.id}>
								 	<#assign i18nKey = menu.i18nKey!'' />
									<@spring.message i18nKey/>
								 </option>
							</#list>
							</#if>
						</select>
					</td>
				<td>
				
						<div class=" user_div_box">
							<span class="icon_box">
								<span class="dingwei_icon_box"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',el:'logoutTime_from'})" ><span class="dingwei_icon"></span></span>
							    <input type="text" class="user_div_1" name="logoutTime_from" id="logoutTime_from">
							</span>
							<span class="dao_ml"><@spring.message  "to"/></span>
							<span class="icon_box">
								<span class="dingwei_icon_box"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',el:'logoutTime_to'})"><span class="dingwei_icon"></span><input type="text" class="user_div_1" name="logoutTime_to" id="logoutTime_to"></span>
								
							</span>
						</div>
					</td>
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
			<#include "uuc/user/tpmc-menu-query.ftl">
		</div>
	    <section class="user_tab_box wl_guanli shang_tab_box">
	     	<#include "uuc/user/tpmc-menu-result.ftl">
	    </section>
	</aside>