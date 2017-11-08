<style>
#page_number{
    text-align: center;
    width: 24px;
    margin-top: 2px;
    border: none;
    outline: 0;
    height: 25px;
    line-height: 25px;
    border-radius: 0;
}
</style>
<aside class="tpmc_aside_r  dis_ib">
		<div class="tpmc_user_div" style="min-height: 100px;" >
				<table class="user_tab_1 tpmc_user_div_tab bc lf" border="0">
				<tr class="tpmc_xz_tr2">
					<td style="width: 17%"><@spring.message "fbt.login.name" /></td>
					<td style="width: 17%"><@spring.message "user.name" /></td>
					<td style="width: 17%"><@spring.message "user.group" /></td>
					<td style="width: 49%"><@spring.message "created.date" /></td>
				</tr>
				<tr class="tpmc_xz_tr2 ">
					<td>
						<input type="text" name="loginName" class="xz_ml xz_input_com"  style="color:black">
					</td>
					<td>
						<input type="text" name="userName" class="xz_ml xz_input_com"  style="color:black">
					</td>
					<td>
						<select name="groupId"  class="xz_select"  style="color:black">
						<option value=""></option>
						<#if groups??> 
							<#list groups?keys as key>
								<option value="${key }">${groups[key] }</option>
							</#list>
						</#if>
						</select>
					</td>
					<td>
						<div class=" user_div_box">
							<span class="icon_box">
								<span class="dingwei_icon_box"><span class="dingwei_icon"></span></span>
								<input type="text" style="color:black"  name="startCreateDate" class="user_div_1" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
							</span>
							<span class="dao_ml"><@spring.message "to" /></span>
							<span class="icon_box">
								<span class="dingwei_icon_box"><span class="dingwei_icon"></span></span>
								<input type="text"  style="color:black" name="endCreateDate" class="user_div_1" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
							</span>
						</div>
					</td>								
				</tr>
				<tr class="tpmc_xz_tr2 tr_add_poit user_ml dis_none" >
					<td><@spring.message "mobile.phone" /></td>
					<td><@spring.message "user.statu" /></td>
					<td><@spring.message "email" /></td>
				</tr>
				<tr class="tpmc_xz_tr2 tr_add_poit dis_none">
					<td>
						<input type="text" name="mobilePhone"  style="color:black"  class="xz_ml xz_input_com" style="color:black">
					</td>
					<td>
						<select name="state" id="" class="xz_select">
						<option value="" > </option>
							<#if userStatu??>
							<#list userStatu?keys as key>
								<option value="${key }" 
									<#if user.state?? && user.state == key>
										selected = "selected"
									</#if>	 >
								 ${userStatu[key] }</option>
							</#list>
						</#if>
						</select>
					</td>
					<td>
						<input type="text" style="color:black"  name="email" class="xz_ml xz_input_com"  style="color:black">
					</td>
				</tr>
				<tr class="tpmc_xz_tr" >
					<td colspan="5">
						<div class="tpmc_onload tx_c"> 
							<span class="tpmc_onload2">
								<img src="${imagesPath }fbt_xz.png">
								<span class="tp_more input_none" type="text"  ><@spring.message "open.more.conditions" /></span>
							</span>
						</div>
					</td>
				</tr>
			</table>
			<table class="rt tab_btn">
				<tbody>
				<@tpmcAuth name="tpmc_user_manager_search">
					<tr>
						<td class="cg_xiugai_td_css">
						<a href="" class="lf btn68_chengse  xz_ml_div tpmc_search_button" ><@spring.message "search" /></a></td>
					</tr>
				</@tpmcAuth>
				<tr>
					<td><a href="" class="lf btn68_gray tpmc_reset"><@spring.message "reset.filter" /></a></td>
				</tr>
				</tbody>
			</table>
		</div>
		<div style="clear: both;"></div>
		 <@spring.page pager=pager  toURL="${toURL}"/>
		<ul class="view_log_container2 page  right_float">
		 	<@tpmcAuth name="tpmc_user_manager_add">
				<li class="right_float">
					<a class="fbt_btn68_green user_search" href="addUser" type="button">
						<@spring.message "new.save" />
					</a>
				</li>
			 </@tpmcAuth>
		</ul>
		<section class="user_tab_box shang_tab_box wl_guanli">
			<#include "uuc/user/manage-user-list.ftl"/>
		</section>			
	</aside>