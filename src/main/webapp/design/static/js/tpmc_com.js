$(function(){ 	
	//左侧滚动条 
 	$(".div_nav_left").niceScroll({
 		// cursoropacitymin: 0, // 当滚动条是隐藏状态时改变透明度, 值范围 1 到 0
        // cursoropacitymax: 1, // 当滚动条是显示状态时改变透明度, 值范围 1 到 0
 		cursorcolor:"#35404d",
 		autohidemode: true 
 	});

	$(".tp_more ").click(function(){
		var t=$(this).text();
		if(t=="展开更多条件"){
			$(".tr_add_poit").removeClass("dis_none");
			$(this).text("收起更多条件");
			$(this).siblings().css('transform','rotate(180deg)');
		}else{
			$(".tr_add_poit").addClass("dis_none");
			$(this).text("展开更多条件");
			$(this).siblings().css('transform','rotate(0deg)');
		}  
	}); 
	// list  高级搜索
    $(document).on("click",".ys_more  ",function(){
		var t=$(this).text();
		if(t=="展开更多商品"){
			// alert($(this))
			$(".tpmc_user_div").addClass("dis_none");
			// ys_more
			$(this).text("收起更多商品");
			$(this).siblings().css('transform','rotate(180deg)');
		}else{
			$(".tpmc_user_div").removeClass("dis_none");
			$(this).text("展开更多商品");
			$(this).siblings().css('transform','rotate(0deg)');
		}  
	});
	//點擊變色；
 	$(".nav_ul  li").click(function(){
	  	//$(".nav_ul  li").eq($(this).index()).addClass("orangeColor").siblings().removeClass("orangeColor");
	  	$(this).addClass("orangeColor").siblings().removeClass("orangeColor");
	});
 	 
 	 //点击事件
 	$(".tpmc_left_ul li").each(function(i,v){
 		//console.log(v);
 		$(v).click(function(){
 			console.log(i);
 			//控制选中图标切换
 			$(".tpmc_left_div_box ").css("display",'block');
 			$(this).attr('id',"select_head2").siblings().removeAttr('id');
 			//收缩部分
 			console.log($(".tpmc_left_div")[i]) ;
 			var div = $(".tpmc_left_div")[i];
 			$(div).css('display','block');
 			$(div).siblings().css('display','none');
 			$(".tpmc_aside_r").css({'margin-left':'238px',"width":"calc(100% - 258px)"});
 		}); 
 	});

	///	//left 收起 	
	$(".shouqi").click(function(){
		$(".tpmc_left_div_box ").css("display",'none');
		$(".tpmc_aside_r").addClass('width_right');
		$(".tpmc_aside_l").css('width','62px');
		$(".tpmc_aside_r").css({'margin-left':'82px',"width":"calc(100% - 102px)"});
	});

	//list  click 
	$(".all_goods li").click(function(){
		$(this).toggleClass("list_select");
	});
}) ;

$(document).ready(
		function() {
			// 点击变色
			var thisU3 = window.location.pathname;
			console.log(thisU3);
			// 自动展开及选中
			if (thisU3 != "/") {
				$(".tpmc_left_ul li").each(
						function(i, v) {
							// console.log(v);
							var attr = $(this).attr("attr");
							if (typeof (attr) != 'undefined'
									&& "null" != attr) {
								var attrs = attr.split("|");
								console.log(attrs);
								for (var j = 0; j < attrs.length; j++) {
									if (thisU3.indexOf(attrs[j] + "/") != -1||thisU3==("/"+attrs[j])) {
										console.log(i);
										// 控制选中图标切换
										$(".tpmc_left_div_box ").css("display",
												'block');
										$(this).attr('id', "select_head2")
												.siblings().removeAttr('id');
										// 收缩部分
										//console.log($(".tpmc_left_div")[i]);
										var div = $(".tpmc_left_div")[i];
										$(div).css('display', 'block');
										$(div).siblings()
												.css('display', 'none');
										$(".tpmc_aside_r").css({
											'margin-left' : '238px',
											"width" : "calc(100% - 258px)"
										});
										break;
									}
								}
							}
						});
			}
		});
function filterOnclick(obj) {
	if(obj.value == "输入过滤") {
		obj.value="";
	}	
}

function filterOnblur (obj) {
	if (obj.value.trim() == "") {
		obj.value="输入过滤";
	}
}
/** selectId 赛选的下拉框id
	    obj 当前input对象
	**/
function filterOnValue(obj) {
	var select = obj.parentNode.getElementsByTagName("select")[0];
	var filterValue = obj.value.trim().toUpperCase();
	var filterValueToLowerCase = obj.value.trim().toLowerCase();
	for (var i=0; i < select.options.length; i++) {
		if (select.options[i].text.indexOf(filterValue) < 0 || select.options[i].text.indexOf(filterValueToLowerCase) < 0) {
		    select.options[i].style.display = "none";
		} else{
			select.options[i].style.display = "block";
		}				
	}
	for (var i=0; i < select.options.length; i++) {
		if (select.options[i].style.display == "block") {
			select.options[i].selected="selected";
			break;
		}
	}
}