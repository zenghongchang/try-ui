
	<#if agent??>
	<#include "agents/${agent}/home.ftl"/>
	<#else>
	<#assign isHomePage = "true"/>
	<#include "common/vars.ftl"/> 
	<#include "common/header.ftl"/>
	<link type="text/css" href="/design/static/css/user/tpmc_user_manage_xzhk.css?version=${version}" rel="Stylesheet">
	<script type="text/javascript" src="/design/static/js/plugins/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
    <style type="text/css">
		 .sel_checkbox   option{
	     padding: 0;
	    margin:0;
	    height: 26px;
	    padding-top: 10px;/*当时解决输入框光标顶满input框的问题是这么解决的 如果设置了行高就会顶满没有行高的话光标高度=文字的font-size */
	    border: none;
	    outline: none;
	    padding-left: 20px;
	    color:#6d6d6d;
	    -webkit-appearance:none; /*去除系统默认的样式*/
	    -webkit-tap-highlight-color: rgba(0, 0, 0, 0);   /* 点击去除高亮的颜色*/
	    background-color: #f7fafc;/*当input框禁止输入的时候会有一个灰色的底色 项目需要我设置了 白色底 跟页面背景一个颜色。*/
	    /*color: red;*/
	}
	 .sel_checkbox   option:checked{
	    color: yellow;
	    background-color: red;
	}
	.input_init {
    color: gray;
    font-style: italic;
}

.input_normal {
    color: black;
}
</style>
	
    <script src="/design/static/js/app/user/manageUser.js?version=${version}" type="text/javascript"></script>
 	<script src="/design/static/js/app/user/selectFilter.js?version=${version}" type="text/javascript"></script>
 
	<#-- 增加用户 -->
	<aside class="tpmc_aside_r  dis_ib">
	<#if user??>
		<input type="hidden" id="user_id" value="${user.id }" />
	</#if>
		<div class="hk_div_box" style="background-color: #fff;">
			<div class="jiben_news">
				<b class="hk_icon1 dis14 hk_icon_img"></b>
				<span class="tp_word_hei"><@spring.message "basic.information" /></span>
			</div>
			<table class="hk_tab bc">
				<tr>
					<td><@spring.message "username" /><span class="tp_orang2">*</span>：</td>
					<td class="user_td">
						<input type="text" id="userName"  value="${user.userName!''}" class="input_user input_user_yanzheng" onBlur="checkUserName(this.value,'userName_check',false)">
					</td>
					<td>
						<!-- <b id="userName_check" class="hk_icon_img face dis14" > -->
						<b id="userName_check" class="hk_icon_img face_nor dis14"></b><@spring.message "user.name.lt.fourteen" />
					</td>
				</tr>
				<tr>
					<td><@spring.message "login.name" /><span class="tp_orang2">*</span>：</td>
					<td class="user_td">
						<input type="text"  id= "loginName"  value="${user.loginName!''}" onBlur="checkUserName(this.value,'loginName_check',false)" class="input_user">
					</td>
					<td>
						<b id="loginName_check" class="hk_icon_img face_nor dis14"></b><@spring.message "login.name.lt.fourteen" />
					</td>
				</tr>
				<tr>
					<td><@spring.message "password" />
					<#if user??>
					<#else>
					<span class="tp_orang2">*</span>：
					</#if>
					</td>
					<td class="user_td">
					<#if user.password?? >
						<input type="password" id= "password" class="input_user" onBlur="checkPassword(this.value,'edit',false)">
					<#else>
					<input type="password" id= "password" class="input_user" onBlur="checkPassword(this.value,'add',false)">
					</#if>
					</td>
					<td>
						<b id="password_check" class="hk_icon_img face_nor dis14"></b><@spring.message "the.password.standard" />
					</td>
				</tr>
				<tr>
					<td><@spring.message "mobile.phone" />：</td>
					<td class="user_td">
						<input type="text" id="mobilePhone"  value="${user.mobilePhone!''}" class="input_user">
					</td>
					<td>
						
					</td>
				</tr>
				<tr>
					<td><@spring.message "email" />：</td>
					<td class="user_td">
						<input type="text" id="email" value="${user.email!''}" onblur="checkEmail(this.value,false)"  class="input_user">
					</td>
					<td>
						<b id="email_check" class="hk_icon_img face_nor dis14"></b><@spring.message "email.is.not.valid" />
					</td>
					<td>
					</td>
				</tr>
				<tr>
					<td>QQ：</td>
					<td class="user_td">
						<input type="text" id="qq" value="${user.qq!''}"  class="input_user">
					</td>
					<td>
					</td>
				</tr>
				<tr>
					<td><@spring.message "super.manager.user" />：</td>
					<td class="user_td">
						<select id="isSuperUser" >
							<option value="0" 
							<#if user.isSuperUser?? && user.isSuperUser == 0>
								selected="selected"
								</#if>>
							<@spring.message "no" /></option>
							<option value="1" <#if user.isSuperUser?? && user.isSuperUser == 1>
								selected="selected"
								</#if>>
							<@spring.message "yes" /></option>
						</select>
					</td>
					<td>
					</td>
				</tr>
				<tr>
					<td><@spring.message "user.statu" />：</td>
					<td class="user_td">
						<select id="statu" >
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
					</td>
				</tr>
				
			</table>
			<div class="user_news">
				<b class="dis14 hk_icon_img hk_icon2 "></b>
				<span class="tp_word_hei"><@spring.message "user.group.information" /></span>
			</div>
			<div class="user_news_distail">
				<#if groups??>
				<#list groups?keys as key>
					<span class="hk_span_com">
					<#if existGroupId?? && existGroupId?seq_contains(key?number) >
						<span class="tp_checkbox tp_icom_com dis14 checkbox_click"></span>
					<#else>
						<span class="tp_checkbox tp_icom_com dis14 "></span>
					</#if>
						<#assign value = groups[key] />
						<b id="${key!'' }">${ value!''}</b>		
					</span>
				</#list>
			</#if>
			</div>
			<div class="jibie_box">
				<b class="hk_icon3 dis14 hk_icon_img"></b>
				<span class="tp_word_hei"><@spring.message "staff.level.information"/></span>
			</div>
			<div class="jibie_shang tp_word_hei ">
				<@spring.message "user.sup" />
			</div>
			<form method="post" name="myform" id=""> 
			   <table border="0" width="100%" class="bc tab_hk"> 
			    <tbody>
			     <tr> 
			      <td width="40%" class="td_sel_com hk_border_r"> 
			      	<input type="text" id = "combobox_sup" onkeyup="selectFilterSup(event)" placeholder="输入过滤" class="sel_filter">
			      	<!-- <div class="div_head">商品部</div> -->
			      	<select class="sel_checkbox sel_left "  id="user_all_option_sup" multiple="" name="list1" size="12" ondblclick="moveOption(document.myform.list1, document.myform.list2)"> 
			      		<#if allUser?? >
			      			<#list allUser?keys as key>
				      			<option value="${key }">${allUser[key] }</option>
				      		</#list>
				      	</#if>
					</select> </td> 
			      
			      <td width="20%" align="center"> 
			      <a  class="btn100_danlvse " onclick="moveOption(document.myform.list1, document.myform.list2)">添加<b class="add1 hk_icon_img dis_16"></b></a>
			      <br> <br>   
			       <a class="btn100_danlvse " onclick="moveOption(document.myform.list2, document.myform.list1)"><b class="delete1 hk_icon_img dis_16"></b><@spring.message "delete"/></a>
			      </td> 
			      <td width="40%" class="td_sel_com va_top hk_border_l" >
			      	<div class="sel_filter xuanze_ml"><@spring.message "had.choosed" />：1/3082</div>
			      	<select  id="superiorOption"  class="sel_checkbox sel_left"  multiple="" name="list2" size="12" ondblclick="moveOption(document.myform.list2, document.myform.list1)"> 
			    	<#if sups?? >
			      		<#list sups?keys as key>
			      			<option value="${key}">${ sups[key]!''}</option> 
			      		</#list>
			      	</#if>	
			     </select> </td>
			     </tr> 
			    </tbody>
			   </table>
			</form>
				<div class="jibie_shang  tp_word_hei" style="margin-top: 24px;">
				<@spring.message "user.sub" />
			</div>
			<form method="post" name="myform22" id=""> 
			   <table border="0" width="100%" class="bc tab_hk"> 
			    <tbody>
			     <tr> 
			      <td width="40%" class="td_sel_com hk_border_r"> 
			      	<input type="text" id = "combobox_sub" onkeyup="selectFilterSub(event)" placeholder="输入过滤" class="sel_filter">
			    	 <select id = "user_all_option_sub" class="sel_checkbox sel_left " multiple="" name="list11" size="12" ondblclick="moveOption(document.myform22.list11, document.myform22.list22)">
						<#if allUser?? >
			      			<#list allUser?keys as key>
				      			<option value="${key }">${allUser[key] }</option>
				      		</#list>
				      	</#if>
					</select> </td> 
			      
			      <td width="20%" align="center"> 
			      <a  class="btn100_danlvse " onclick="moveOption(document.myform22.list11, document.myform22.list22)">><@spring.message "add" /><b class="add1 hk_icon_img dis_16"></b></a>
			      <br> <br>   
			       <a class="btn100_danlvse " onclick="moveOption(document.myform22.list22, document.myform22.list11)"><b class="delete1 hk_icon_img dis_16"></b><@spring.message "delete" /></a>
			      </td> 
			      <td width="40%" class="td_sel_com va_top hk_border_l">
			      	<div class="sel_filter xuanze_ml"><@spring.message "had.choosed" />：1/3082</div>
			      	<select id="subordinateOption" class="sel_checkbox sel_left "  multiple="" name="list22" size="12" ondblclick="moveOption(document.myform22.list22, document.myform22.list11)">
						<#if subordinates?? >
			      		<#list subordinates?keys as key>
			      			<option value="${key}">${ subordinates[key]!''}</option> 
			      		</#list>
			      	</#if>			      	

			      	</select> </td>
			     </tr> 
			    </tbody>
			   </table>
			</form>
		</div>
		<div class="pl_btn clear">
			<a href="manageUserList" class="tp_btn_com"><b class="fbt_reture1 dis_16"></b><@spring.message "back" /></a>
			<a href="addUser" class="tp_btn_com"><b class="fbt_reture2 dis_16"></b><@spring.message "reset" /></a>
		<@tpmcAuth name="tpmc_user_manager_save">
			<a onClick="saveUser(0)" class="tp_btn_com tp_btn_com_else"><b class="fbt_reture3  dis_16"></b><@spring.message "save.and.back" /></a>
			<a onClick="saveUser(1)" class="tp_btn_com "><b class="fbt_reture3 dis_16"></b><@spring.message "save" /></a>
		 </@tpmcAuth>	
		</div>
	</aside>
	<#include "common/footer.ftl"/>
</#if>

 <script type="text/javascript">
   $(function(){
	//选择；box
	$(".hk_span_com ").click(function(){
		$(this).find('span').toggleClass("checkbox_click");
	})
    //滚动条
    $(".sel_left").niceScroll({cursorcolor:"#35404d",autohidemode: false });
   })
	function moveOption(e1, e2) {
	    try {
	        for (var i = 0; i < e1.options.length; i++) {
	            if (e1.options[i].selected) {
	                var e = e1.options[i];
	                e2.options.add(new Option(e.text, e.value));
	                e1.remove(i);
	                ii = i - 1
	            }
	        }
	        document.myform.city.value = getvalue(document.myform.list2);
	    } catch(e) {}
	}
	function getvalue(geto) {
	    var allvalue = "";
	    for (var i = 0; i < geto.options.length; i++) {
	        allvalue += geto.options[i].value + ",";
	    }
	    return allvalue;
	}
	function changepos(obj, index) {
	    if (index == -1) {
	        if (obj.selectedIndex > 0) {
	            obj.options(obj.selectedIndex).swapNode(obj.options(obj.selectedIndex - 1))
	        }
	    } else if (index == 1) {
	        if (obj.selectedIndex < obj.options.length - 1) {
	            obj.options(obj.selectedIndex).swapNode(obj.options(obj.selectedIndex + 1))
	        }
	    }
	}
</script> 
