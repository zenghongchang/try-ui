///验证
var span_add = "<b class='error'>"+lang["required"]+"</b>";
var span_add_ch = "<b class='error'>"+lang["letter.num"]+"</b>";
var span_add_ch2 = "<b class='error'>"+lang["letter.num2"]+"</b>";
var span_add_num = "<b class='error'>"+lang["must.is.num"]+"</b>";
var span_add_num_gt_zero = "<b class='error'>"+lang["must.is.num.gt.zero"]+"</b>"; 
$(function(){ 
	$(".required").blur(function(){
		$(this).siblings("b").remove();
	    if($(this).val().trim() == ""){
			$(this).css("border-color","red");
			$(this).parent().append(span_add);
		}else{
			$(this).css("border-color","#e8eaf1");
		}
	});
	
	$(".numUpperChar").blur(function(){
		if (!($(this).hasClass("required"))) {
			$(this).siblings("b").remove();
			$(this).css("border-color","#e8eaf1");
		}
		if ($(this).val().trim() != "" ) {
			$(this).siblings("b").remove();
			if(!($(this).val().trim().match(/^[A-Z0-9-]{1,}$/))){
				$(this).css("border-color","red");
				$(this).parent().append(span_add_ch);	
			} else {
				$(this).css("border-color","#e8eaf1");
			}
		}
	});
	
	$(".numUpperChar2").blur(function(){
		if (!($(this).hasClass("required"))) {
			$(this).siblings("b").remove();
			$(this).css("border-color","#e8eaf1");
		}
		if ($(this).val().trim() != "" ) {
			$(this).siblings("b").remove();
			if(!($(this).val().trim().match(/^(?=.*\d.*)(?=.*[A-Z].*).{1,}$/))){
				$(this).css("border-color","red");
				$(this).parent().append(span_add_ch2);	
			} else {
				$(this).css("border-color","#e8eaf1");
			}
		}
	});
	
	$(".number").blur(function() {
		if (!($(this).hasClass("required"))) {
			$(this).siblings("b").remove();
			$(this).css("border-color","#e8eaf1");
		}
		if ($(this).val().trim() != "" ) { 
			$(this).siblings("b").remove();
			var reg=/^\d+(\.\d{1,2})?$/; //数字和两位以内的小数
			if (!(reg.test($(this).val().trim())))  {
				$(this).css("border-color","red");
				$(this).after(span_add_num);
			} else {
				$(this).css("border-color","#e8eaf1");
			}
		}
	});
	$(".numberGtZero").blur(function() {
		if (!($(this).hasClass("required"))) {
			$(this).siblings("b").remove();
			$(this).css("border-color","#e8eaf1");
		}
		if ($(this).val().trim() != "" ) { 
			$(this).siblings("b").remove();
			var reg=/^[1-9]?[0-9]*$/; //正整数
			if (!(reg.test($(this).val().trim())))  {
				$(this).css("border-color","red");
				$(this).after(span_add_num);
			} else {
				$(this).css("border-color","#e8eaf1");
			}
		}
	});
	
});

function valiForm() {
	var type = true;
	$(".required").each(function() {
		//$(this).siblings("b").remove();
		if ($(this).val().trim() == "") {
			type = false;
			$(this).addClass("input_selet");
			$(this).parent().append(span_add);
		}
	});
	$(".numberGtZero").each(function() {
		//$(this).siblings("b").remove();
		if ($(this).val().trim() != "") {
			if ($(this).parent().find(".error").length != 0) {
				type = false;
				$(this).addClass("input_selet");
				$(this).parent().append(span_add_num_gt_zero);
			}
		}
	});
	
	$(".number").each(function() {
		//$(this).siblings("b").remove();
		if ($(this).val().trim() != "") {
			if ($(this).parent().find(".error").length != 0) {
				type = false;
				$(this).addClass("input_selet");
				$(this).parent().append(span_add_num);
			}
		}
	});
	
	$(".numUpperChar2").each(function() {
		//$(this).siblings("b").remove();
		if ($(this).val().trim() != "") {
			if ($(this).parent().find(".error").length != 0) {
				type = false;
				$(this).addClass("input_selet");
				$(this).parent().append(span_add_ch2);
			}
		}
	});
	
	$(".numUpperChar").each(function() {
		//$(this).siblings("b").remove();
		if ($(this).val().trim() != "") {
			if ($(this).parent().find(".error").length != 0) {
				type = false;
				$(this).addClass("input_selet");
				$(this).parent().append(span_add_ch);
			}
		}
	});
	
	if (!type) {
		$("body").scrollTop(100);	
	}
	return type;
}

//返回
function back() {
	history.back();
}

//重置
function reset(url) {
	window.location.href = url;
}

//保存 type 1:保存并返回 0:保存
function save(type, submitFun) {
	if (valiForm()) {
		if (submitFun) {
			submitFun(type);
		} else {
			submitData(type);
		}
	}
}



function submitData(type) {
	var url = $("#editAddform").attr("action");
	var fd = $("#editAddform").serialize();
	var goBackUrl = $("#goBack").attr("href");
	$.post(url, fd, function(data) {
		var code = data.code;
		var msg = data.description;
        if (code == 200) {
        	if (type == 1) {
        		//保存并返回
        		window.location.href = goBackUrl;
        	}
        } 
        showMsg(msg);
    }).error(function(xhr,errorText,errorType){
        showMsg(errorText);
    });
	return false;
}


function showMsg(msg) {
	var d = dialog({
        quickClose: true,
        content: msg
    });
    d.show();
}

function Validate () {}
Validate.prototype = {
		isNotNull: function(value) {
			if (null == value || "" == value) {
				return false;
		    }
		    return true;
		},
		isNum: function(value) {
			if (null == value || '' == value || (isNaN(value) || parseFloat(value) < 0 ) ) {
				return false;
			}
			return true;
		},
		isNumGtZero: function(value) {
			var re = /^[1-9]?[0-9]*$/ ;  
		    return re.test(value);
		},
		isAZNumLine: function(value) {
			var re = /^[A-Z0-9-]{1,}$/ ;
		    return re.test(value);
		},
		isMoney: function(value) {
			var re = /^\d+(\.\d{1,2})?$/ ;
		    return re.test(value);
		}
}
