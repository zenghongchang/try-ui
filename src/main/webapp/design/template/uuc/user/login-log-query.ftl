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
<div class="tpmc_user_div" style="min-height: 100px;" >
		<table class="user_tab_1 tpmc_user_div_tab bc lf" border="0">
				<tr class="tpmc_xz_tr2">
                    <td ><@spring.message  "user.name"/></td>
					<td ><@spring.message  "ip.address"/></td>
					<td style="width: 49%"><@spring.message  "login.time"/></td>
				</tr>
				<tr class="tpmc_xz_tr2 ">
				    <td>
						<input type="text" class="xz_ml xz_input_com" name="loginName">
					</td>
					<td>
						<input type="text" class="xz_ml xz_input_com" name="ipAddress">
					</td>
					<td>
						<div class=" user_div_box">
							<span class="icon_box">
								<span class="dingwei_icon_box" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',el:'loginTime_from'})"><span class="dingwei_icon"></span></span>
								<input type="text" name="loginTime_from" class="user_div_1" id="loginTime_from">
							</span>
							<span class="dao_ml"><@spring.message  "to"/></span>
							<span class="icon_box">
								<span class="dingwei_icon_box" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',el:'loginTime_to'})"><span class="dingwei_icon"></span></span>
								<input type="text" name="loginTime_to" class="user_div_1" id="loginTime_to">
							</span>
						</div>
					</td>								
				</tr>
				<tr class="tpmc_xz_tr2 tr_add_poit user_ml dis_none" >
					<td colspan="2"><@spring.message  "online.time"/></td>
					<td ><@spring.message  "logout.time"/></td>
				</tr>
				<tr class="tpmc_xz_tr2 tr_add_poit dis_none">
					<td colspan="2">
						<input type="text" class="xz_ml xz_input_com" name="duration_from" style="width:32%"><@spring.message  "hour"/>
                        <span class="dao_ml"><@spring.message  "to"/></span>
                        &nbsp; &nbsp; &nbsp;
                        <input type="text" class="xz_ml xz_input_com" name="duration_to" style="width:32%"><@spring.message  "hour"/>
					</td>
					<td>
						<div class=" user_div_box">
							<span class="icon_box">
								<span class="dingwei_icon_box"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',el:'logoutTime_from'})" ><span class="dingwei_icon"></span></span>
							    <input type="text" class="user_div_1" name="logoutTime_from" id="logoutTime_from">
							</span>
							<span class="dao_ml"><@spring.message  "to"/></span>
							<span class="icon_box">
								<span class="dingwei_icon_box"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',el:'logoutTime_to'})"><span class="dingwei_icon"></span></span>
								<input type="text" class="user_div_1" name="logoutTime_to" id="logoutTime_to">
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
				<tbody>
				    <@tpmcAuth name="tpmc_user_login_log_search">
						<tr>
							<td class="cg_xiugai_td_css"><a href="javascript:void(0);" class="lf btn68_chengse tpmc_search_button  xz_ml_div"><@spring.message "search"/></a></td>
						</tr>
					</@tpmcAuth>
					<tr>
						<td><a href="" class="lf btn68_gray tpmc_reset"><@spring.message "reset.filter"/></a></td>
					</tr>
				</tbody>
		</table>
</div>
<div style="clear: both;"></div>