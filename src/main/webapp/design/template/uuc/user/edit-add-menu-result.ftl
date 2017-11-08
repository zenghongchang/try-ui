<script src="${jsPath}app/validate.js?version=${version}" type="text/javascript"></script>
<script src="${jsPath}app/user/menu_edit_add.js?version=${version}" type="text/javascript"></script>
<style type="text/css">
		.shangpin_right_div,
		.shangpin_left_div{
		    width: 44%;
		    display: inline-block;
		    vertical-align: top;
		}
		.hr_sku{
			border-top: 1px solid #e8eaf1;    
			margin: 10px 0;
		}
		.wuliao_ul li {
		   height: 124px;
		}
		.shangpin_left_div{
			margin-right: 5%;
		}
		.shangpin_right_div{
			margin-left: 5%;
		}

		.hk_tab tr td .input_user{
		    width: 100%;
		}
		.hk_tab {
			width: 100%;
		}
		.hk_tab tr td.user_td{
			padding-left: 0;
		}
		.hk_tab tr {
		    height: 38px;
		}
		.attr_tab tr td,
		.attr_tab2 tr td{
			width: 35%;
		}
		.all_select .checkbox_click,
		.hk_span_comm .checkbox_click{
			background-position: 0 -15px;
		}
	</style>
<aside class="tpmc_aside_r  dis_ib">
	<form id="editAddform" action="/user/saveOrUpdateMenu">
		<input type="hidden" name="id" id="id" value="${menu.id}"/>
		<input type="hidden" name="parent" id="parent" value="${parentId}"/>
		
		<div class="hk_div_box" style="background-color: #fff;">
		    <div class="shangpin_left_div">
		    </div>
			<div class="shangpin_left_div clear_only" style="    width: 90%;">    	
				<div class="jiben_news" style="margin-top: 20px;">
					<b class="hk_icon1 dis14 hk_icon_img"></b>
					<span class="tp_word_hei"><@spring.message "menu.manage"/></span>
				</div>
				<table class="hk_tab bc attr_tab">
							<tr>
								<td ><@spring.message "menu.name"/><span class="tp_orang2">*</span>：  
									<input type="text" class="required input_user input_user_yanzheng materialAttr" attribute="<@spring.message "menu.name"/>"  value="${menu.menuName}" name="menuName" style="width: 65%;"/>
								</td>
								<td><@spring.message "address"/>(url)<span class="tp_orang2">*</span>：
									<input type="text" class="required input_user input_user_yanzheng materialAttr" attribute="<@spring.message "address"/>" value="${menu.url}" name = "url" style="width: 65%;"/>
								</td>
								<td ><@spring.message "internationalization"/>key<span class="tp_orang2">*</span>：  
									<input type="text" class="required input_user input_user_yanzheng materialAttr" attribute="<@spring.message "internationalization"/>key" value="${menu.i18nKey}" name="i18nKey" style="width: 65%;"/>
								</td>
								<td>
									<img src="${imagesPath}attr_add.png" alt="" class="attr_add" title="<@spring.message "add.acl"/>">
								</td>
							</tr>
							
							<table class="hk_tab bc  kk">
								<div class="jiben_news" style="margin-top: 20px;">
									<b class="hk_icon4 dis14 "></b>
									<span class="tp_word_hei"><@spring.message "menu.acl"/></span>
								</div>
							<#if menu.acls?? &&(menu.acls?size>0)>
								<input type="hidden" name="index" id="index" value="${menu.acls?size-1}"/>
								<#list menu.acls as acl>
								<tr>
									<input type="hidden" name="acls[${acl_index}].id" value="${acl.id}"/>
									<td ><@spring.message "aclBtn"/><span class="tp_orang2">*：  
										<input type="text" class="required input_user input_user_yanzheng materialAttr" attribute="<@spring.message "aclBtn"/>" tempid="aclB_${acl_index}" name="acls[${acl_index}].aclBtn" value="${acl.aclBtn}" style="width: 55%;"/>
									</td>
									<td ><@spring.message "description"/>：  
										<input type="text" class="input_user input_user_yanzheng materialAttr" attribute="<@spring.message "description"/>" tempid="desc_${acl_index}" name="acls[${acl_index}].describe" value="${acl.describe}" style="width:60%;"/>
									</td>
									<td><@spring.message "address"/>(url)<span class="tp_orang2">*</span>：
										<input type="text" class="required input_user input_user_yanzheng materialAttr"  attribute="<@spring.message "address"/>" tempid="aclU_${acl_index}" name="acls[${acl_index}].aclUrl" value="${acl.aclUrl}" style="width:55%;"/>
									</td>
									<td><@spring.message "internationalization"/>key<span class="tp_orang2">*</span>：
										<input type="text" class="required input_user input_user_yanzheng materialAttr" attribute="<@spring.message "internationalization"/>key" tempid="i18n_${acl_index}" name="acls[${acl_index}].i18nKey" value="${acl.i18nKey}" style="width: 55%;"/>
									</td>
									<td>
										<img src="${imagesPath}attr_del.png" alt="" class="attr_del" title="<@spring.message "delete.acl"/>">
									</td>
								</tr>
								</#list>
								</table>
						<#else>
							<input type="hidden" name="index" id="index" value="-1"/>
						</#if>
				</table>
			</div>
		</div>
		
		<div class="pl_btn clear">
			<a href="/user/listMenu" class="tp_btn_com"><b class="fbt_reture1 dis_16"></b><@spring.message "back"/></a>
			<a href="/user/editAddMenu?id=${menu.id}" class="tp_btn_com" onclick="resetAllData()"><b class="fbt_reture2 dis_16"></b><@spring.message "reset"/></a>
			<a href="#" class="tp_btn_com tp_btn_com_else" onclick="setData(this,1)"><b class="fbt_reture3  dis_16"></b><@spring.message "save.and.back"/></a>
			<a href="#" class="tp_btn_com" onclick="setData(this,0)"><b class="fbt_reture3 dis_16"></b><@spring.message "save"/></a>
		</div>
	  </form>
	</aside>
	
<script type="text/javascript">
	var i = -1;
    $(function(){
	    $(".sel_left").niceScroll({cursorcolor:"#35404d",autohidemode: false });
    	$(document).on('click','.attr_add',function(){
    	if (i ==-1) {
	    	i = parseInt($("#index").val());
    	}
    	i = i +1;
			var tr_add ="<tr>\
						<td><@spring.message "aclBtn"/><span class='tp_orang2'>*</span>：  \
							<input type='text' class='required input_user input_user_yanzheng'  attribute='<@spring.message "aclBtn"/>'  tempid='aclB_"+i+"' name='acls["+i+"].aclBtn' style='width: 55%;'>\
						</td>\
						<td ><@spring.message "description"/>：  \
										<input type='text' class='input_user input_user_yanzheng materialAttr' tempid='desc_"+i+"' name='acls["+i+"].describe'  style='width: 60%;'/>\
									</td>\
						<td><@spring.message "address"/>(url)<span class='tp_orang2'>*</span>： \
							<input type='text' class='required input_user input_user_yanzheng'  attribute='<@spring.message "address"/>' tempid='aclU_"+i+"' name='acls["+i+"].aclUrl' style='width: 55%;'>\
						</td>\
						<td><@spring.message 'internationalization'/>key<span class='tp_orang2'>*</span></span>： \
							<input type='text' class='required input_user input_user_yanzheng' attribute='<@spring.message "internationalization"/>key' tempid='i18n_"+i+"' name='acls["+i+"].i18nKey' style='width: 55%;'>\
						</td>\
						<td>\
							<img src='${imagesPath}attr_del.png' alt='' class='attr_del' title='<@spring.message 'delete.acl'/>'>\
						</td>\
						</tr>\
						";
			$(".kk").append(tr_add);
		})
		//attr_del
		$(document).on('click','.attr_del',function(){
			$(this).parents("tr").remove();
		})	
    })
    </script>