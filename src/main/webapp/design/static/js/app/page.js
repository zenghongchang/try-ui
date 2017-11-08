$(document).ready(function () {
  //上一页js
	$(".view_log_container2 .first_page .left_page").click(function(){
		var targetUrl=$("#requestUrl").val();
		var pn= $.trim($("#page_number").val());
		if(typeof(pn)=="undefined" || pn==""){
			pn=1;
		}
		var pageNum = Math.ceil(pn);
		if((pageNum-1)>=1){
			//$(".view_log_container2 .first_page .number_page").html(pageNum-1);
			$("#page_number").val(pageNum-1);
			$("#currentPage").val(pageNum-1);
		}else{
			return false;
		}
		//ajax调用刷新页面
		ajaxSubmit(targetUrl,null,this);
	}); 
   //下一页	
	$(".view_log_container2 .first_page .right_page").click(function(){
		var targetUrl=$("#requestUrl").val();
		var pn= $.trim($("#page_number").val());
		if(typeof(pn)=="undefined" || pn==""){
			pn=1;
		}
		var pageNum = Math.ceil(pn);
		var totalPage=Math.ceil($("#totalPages").val());
		if((pageNum+1)<=totalPage){
			//$(".view_log_container2 .first_page .number_page").html(pageNum+1);
			$("#page_number").val(pageNum+1);
			$("#currentPage").val(pageNum+1);
		}else{
			return false;
		}
		//ajax调用刷新页面
		ajaxSubmit(targetUrl,null,this);
	}); 
	//选择 select 刷新分页
	$("#pager-limit").change(function(){
		var targetUrl=$("#requestUrl").val();
		ajaxSubmit(targetUrl,null,this);
		return false;
	});
	// 搜索提交 
	$(".tpmc_search_button").click(function(){
		var targetUrl=$("#requestUrl").val();
		ajaxSubmit(targetUrl,null,this);
		return false;
	});
	// 重置
	$(".tpmc_reset").click(function(){
		$("#searchForm").resetForm();
		var targetUrl=$("#requestUrl").val();
		$("#currentPage").val(1);
		ajaxSubmit(targetUrl,null,this);
		return false;
	});
	//页码输入 onblur 事件
	$("#page_number").blur(function(){
		 var value = $.trim($(this).val());
		 if(value==""){
			 showTips('请输入正确页码', this, 2);
			 $(this).val(1);
			 return false;
		 }
		 //验证为数字
		 var matchs = /^\+?[1-9][0-9]*$/;
		 if(!matchs.test(value)){
			 showTips('请输入正确页码', this, 2);
			 $(this).val(1);
			 return false;
		 }
	});
	
});
//提交 ajax 请求 表单数据提交的 分页
function ajaxSubmit(url,params,object){
    var url = url;
    if(typeof(params)!='undefined'&&null!=params&&''!=params){
    	url=url+"?"+params;
    }
    var index = layer.load(1, {shade: [0.42,'#000000']}); //0代表加载的风格，支持0-2
    var serializeArray=$("select,input,:checkbox,:radio").serializeArray();
    var sendParams="";
    if(typeof(serializeArray)!='undefined'&&null!=serializeArray&&''!=serializeArray){
    	$.each( serializeArray, function(i, field){
    		  //$("#results").append(field.value + " ");
    		  if($.trim(field.value)!=""&&typeof(field.name)!="undefined"&&field.name!="totalPages"){
    			  sendParams+=("\""+field.name+"\""+":"+"\""+$.trim(field.value)+"\""+",");
    		  }
    		});
    	sendParams=("{"+sendParams+"}").replace(",}","}");
    }
   // sendParams=$.parseJSON(sendParams);
    //
	$.ajax({
		type : "POST",  //提交方式
		url : url,//路径
		contentType: 'application/json',
		data : sendParams,//数据，这里使用的是Json格式进行传输
		success : function(result) {//返回数据根据结果进行相应的处理
			if(result.indexOf("un-login")!=-1){
				layer.close(index);
				layer.msg('本次登录失效,请重新登录!');
				setTimeout("location.reload()",1000);
			}else{
				$(".shang_tab_box").html(result);
				try {
					// 绑定分页
					var pageData = $(".shang_tab_box").children('*[attr]')
							.attr("attr");
					//console.log($(".shang_tab_box").children('*[attr]').attr("attr"));
					//console.log(pageData);
					// var jsonD=jQuery.parseJSON(pageData);
					var jsondata = jQuery.parseJSON(pageData);
					$("#span_totalPages").html(jsondata["totalPages"]);
					$("#totalRecords").html(jsondata["totalRecords"]);
					$("#totalPages").val(jsondata["totalPages"]);
				} catch (e) {
				}
			}
		},
		error:function(result){
			console.log(result);
			//$(object).qtips("request error!!");
			//setTimeout("",3000);
			layer.close(index);
		},
		complete:function(result){
			layer.close(index);
		}
    });
}
// 提交
function formSubmit(url, formId, showRequest) {
	if (typeof (url) == '' || url == null) {
		url = $("#" + formId).attr("action");
	}
	if (url == '') {
		return false;
	}
	var options = {
		// target : '.shang_tab_box', //把服务器返回的内容放入id为output的元素中
		beforeSubmit : function(formData, jqForm, options) {
			var queryString = $.param(formData);
			console.log(queryString);
		}, // 提交前的回调函数
		success : function(responseText, statusText) {
			$(".shang_tab_box").html(responseText);
		}, // 提交后的回调函数
		url : url, // 默认是form的action， 如果申明，则会覆盖
		// type: type, //默认是form的method（get or post），如果申明，则会覆盖
		// dataType: null, //html(默认), xml, script, json...接受服务端返回的类型
		// clearForm: true, //成功提交后，清除所有表单元素的值
		// resetForm: true, //成功提交后，重置所有表单元素的值
		// timeout : 3000
		error : function() {
		}
	// 限制请求的时间，当请求大于3秒后，跳出请求
	};
	$("#" + formId).ajaxSubmit(options);
	return false;
}

function resetForm(formId){
	$("#"+formId).reset();
}