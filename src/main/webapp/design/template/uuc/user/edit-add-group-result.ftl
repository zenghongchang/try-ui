 <!-- //z-tree end-->
	<style type="text/css">
	.tree .tree-item {
	    /*height: 46px;*/
	}
	.add_checkbox_div{
		    margin-left: 28px;
		    margin-top: 10px;
	}
	.add_checkbox_div:after{
		    display: inline-block;
	    content: "";
	    position: absolute;
	        top: 23px;
	    bottom: 13px;
	    left: 11px;
	    border: 1px dotted #67b2dd;
	    border-width: 0 0 0 1px;
	    z-index: 1;
	}
	.add_checkbox_div:before{
	    display: inline-block;
	    content: "";
	    position: absolute;
	        top: 43px;
    left: 12px;
	    width: 18px;
	    height: 0;
	    border-top: 1px dotted #67b2dd;
	    z-index: 1;
	}
	.widget-box{
		border-bottom: 0px ;
	}
	.widget-body{
		border: 0;
	}
	.ml_5 {
	    margin-right: 5px;
	}
	.tp_checkbox, .tp_checkbox_all {
	    position: relative;
	    top: 1px;
	    background: url(${imagesPath}tp_checkbox.png) no-repeat;
	}
	.dis14 {
	    display: inline-block;
	    width: 14px;
	    height: 14px;
	}
	.tree .tree-item, .tree .tree-folder .tree-folder-header{
		/*width: 142px;
		float: left;*/
	}
	.tree .tree-item{
		height: 46px;

	}
	.add_checkbox_div{
		height: 20px;
		line-height: 20px;
		/*background: green;*/
	}
	.tp_checkbox_span{
		display: inline-block;
		width: 105px;
	}
	.tp_checkbox_span .checkbox_click{
		background-position: 0 -15px;
	}
	.quanxian{
		background-image: url(${imagesPath}tp_quanxian.png);
	    background-repeat: no-repeat;
	    position: relative;
	    top: 2px;
	    margin-right: 5px;
	}	
	</style>

	<style type="text/css">
		 .sel_checkbox   option{
	     padding: 0;
	    margin:0;
	    height: 26px;
	    padding-top: 10px;
	    border: none;
	    outline: none;
	    padding-left: 20px;
	    color:#6d6d6d;
	    -webkit-appearance:none; /*去除系统默认的样式*/
	    -webkit-tap-highlight-color: rgba(0, 0, 0, 0);   /* 点击去除高亮的颜色*/
	    background-color: #f7fafc;
	}
	 .sel_checkbox   option:checked{
	    color: yellow;
	    background-color: red;
	}
	</style>
	<aside class="tpmc_aside_r  dis_ib">
	<#if group??>
		<input type="hidden" id="group_id" value="${group.id }" />
		<input type="hidden" id="limitsTree" value='${limitsTree }' />
	</#if>
		<div class="hk_div_box" style="background-color: #fff;">
			<div class="jiben_news">
				<b class="hk_icon1 dis14 hk_icon_img"></b>
				<span class="tp_word_hei"><@spring.message "basic.information"/></span>
			</div>
			<table class="hk_tab bc">
				<tr>
					<td><@spring.message  "group.name"/><span class="tp_orang2">*</span>：</td>
					<td class="user_td">
						<input type="text" id="groupName" class="input_user input_user_yanzheng" value="${group.groupName}">
					</td>
				</tr>
				<tr>
					<td><@spring.message  "group.code"/> :</td>
					<td class="user_td">
						<input type="text" id ="code" class="input_user" value="${group.code}">
					</td>
				</tr>
				<tr>
					<td><@spring.message  "staff.level"/><span class="tp_orang2">*</span>：</td>
					<td class="user_td">
						<#assign map = staffLevel !''/>
						<select name="xz_select" id="staffLevel" class="xz_select">
						 <option value="">---<@spring.message 'please.choose'/>---</option>
							<#list map?keys as key>
									<option  <#if key == group.staffLevel!'' > selected = "selected" </#if> value="${key!''}">${ map[key]}</option>
							</#list>
						</select>
					</td>
					<td>
						
					</td>
				</tr>
			</table>
			<div class="user_news">
				<b class="dis14 hk_icon_img hk_icon2 "></b>
				<span class="tp_word_hei"><@spring.message  "group.user"/></span>
			</div>
			<div class="user_news_distail">
			<#if groupUsers??>
				<#list groupUsers as groupUser>
					<span class="hk_span_com">
						<span class="tp_checkbox tp_icom_com dis14 checkbox_click"></span>
						<b id="${groupUser.id!''}">${groupUser.userName!''}</b>					
					</span>
				</#list>
			</#if>
			<#if users??>
				<#list users as user>
					<span class="hk_span_com">
						<span class="tp_checkbox tp_icom_com dis14"></span>
						<b id="${user.id!''}">${user.userName!''}</b>					
					</span>
				</#list>
			</#if>
			</div>
			<div class="user_news" style="padding-bottom: 10px;">
				<b class="dis14 quanxian  "></b>
				<span class="tp_word_hei"><@spring.message  "group.permission"/></span>
			</div>
			<!-- ztree 插件 -->
			<div class="content_wrap" style="width: 100%;">
				<div class="zTreeDemoBackground left" style="float: left;width: 100%;">
					<ul id="treeDemo" class="ztree" style="width: 100%;"></ul>
				</div>
			</div>
		</div>
		<div class="pl_btn clear">
			<a href="groupList" class="tp_btn_com"><b class="fbt_reture1 dis_16"></b><@spring.message "back"/></a>
			<a href="editAddGroup" class="tp_btn_com"><b class="fbt_reture2 dis_16"></b><@spring.message "reset"/></a>
			<a onClick="saveGroup(0)" class="tp_btn_com tp_btn_com_else" ><b class="fbt_reture3  dis_16"></b><@spring.message "save.and.back"/></a>
			<a onClick="saveGroup(1)" class="tp_btn_com " ><b class="fbt_reture3 dis_16"></b><@spring.message "save"/></a>
			
		</div>
	</aside>
<script type="text/javascript">
	var limitTrees = $("#limitsTree").val();
	$(function(){
		// 用户组信息 xuanze;
		$(".hk_span_com ").click(function(){
			$(this).find('span').toggleClass("checkbox_click");
		})
		$(".tp_checkbox ").click(function(){
			$(this).toggleClass("checkbox_click");
		})
	})
</script>

<SCRIPT type="text/javascript">
	//fetchGroupPrivage()
		var setting = {
			view: {
				selectedMulti: false
			},
			check: {
				enable: true
			},
			data: {
				simpleData: {
					enable: true
				}
			}
		};

		function createTree() {
			var limits = JSON.parse(limitTrees);
			$.fn.zTree.init($("#treeDemo"), setting, limits);
			count();
			clearFlag = $("#last").attr("checked");
		}

		$(document).ready(function(){
			createTree();			
			$("#init").bind("change", createTree);
			$("#last").bind("change", createTree);
		});
		//-->
	</SCRIPT>
	    <!--[if IE]><script lang="javascript" type="text/javascript" src="../../js/excanvas.js"></script><![endif]-->
</body>
</html>