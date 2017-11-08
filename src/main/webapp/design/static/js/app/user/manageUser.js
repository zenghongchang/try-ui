function saveUser(obj){
	var userName =  $("#userName").val().trim();
	if(!checkUserName(userName,"userName_check",true)){
		return false;
	}
	var loginName = $("#loginName").val().trim();
	if(!checkUserName(loginName,"loginName_check",true)){
		return false;
	}
	var id = $("#user_id").val();
	var password = $("#password").val();
	
	if( ""== id || typeof(id) =='undefined'){
    	if(!checkPassword(password,"add",true)){
			return false;
		}
     }else{
     	if(!checkPassword(password,"edit",true)){
			return false;
		}
	}
	
	var mobilePhone = $("#mobilePhone").val().trim();
	var email = $("#email").val().trim();
	if(! checkEmail(email,true)){
		return false;
	}
	
	var qq = $("#qq").val().trim();
	var state = $("#statu").val().trim();
	var isSuperUser = $("#isSuperUser").val();
	var subs = [];
	var sups = [];
	var groupIds = [];
	
	var eles = $("span[class*='checkbox_click']").next("b");
	$(eles).each(function(){
    	groupIds.push( this.id);
	})
	
	//用户上下级
	$('#subordinateOption option').each(function () {
		var option = $(this);
		var value = option.val();
		subs.push(parseInt(value));
	});
	var flag = false;
	$('#superiorOption option').each(function () {
		var option = $(this);
		var value = option.val();
		if($.inArray(parseInt(value), subs) > -1){
			var d = dialog({
				title: lang["tip"],
				content: lang["sub.sup.cntains.common.user"]
			});
			d.show();
			flag = true;
		}
		sups.push(parseInt(value));
	});
	if(flag){
		return false;
	}else{
		$.ajax({
		    type: 'POST',
		    traditional:true,
			url: "saveUser",
			data: {
				"id":id,
				"userName": userName,
				"loginName": loginName,
				"password": password, 
				"mobilePhone" : mobilePhone, 
				"email" : email,
				"qq":qq,
				"state":state,
				"isSuperUser":isSuperUser,
				"subIds":subs,
				"supIds":sups,
				"groupIds":groupIds
			},
			success: function(result){
				if( '' != result['code'] && result['code'] == 200){
					var d = dialog({
						content: lang["make.success"]
					});
					d.show();
					setTimeout(function () {
						d.close().remove();
					}, 2000);
					if(obj == 0){
						location.href ="/user/manageUserList";
					}else{
						location.href = window.location.href;
					}
				}else{
					var d = dialog({
						content: lang["make.failure"] + ":" + result['description'],
					});
					d.show();
					setTimeout(function () {
						d.close().remove();
					}, 2000);
				}				
			},
			error:function(){
				console.log("error");
			}
		});
	}
}

function checkEmail(email,flag) {
	if(email == null || email == undefined || email == ""){
	 	$("#email_check").removeClass().addClass("hk_icon_img face_nor dis14")
		return true;
	}
	if (email.search(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/) != -1){
		$("#email_check").removeClass().addClass("hk_icon_img face_nor dis14")
		return true;
	}
	$("#email_check").removeClass().addClass("hk_icon_img face dis14")
	if(flag){
		$("#email").focus();
	}
	return false;
}

function checkUserName(userName,id,flag){
	if(userName == null || userName == undefined || userName == "" || userName.length > 14){
		var input = id.split("_")[0];
		if(flag){
			$("#"+input).focus();
		}
		$("#"+id).removeClass().addClass("hk_icon_img face dis14");
		return false;
	}
	$("#"+id).removeClass().addClass("hk_icon_img face_nor dis14")
	return true;
}

function checkPassword(password,type,flag) {
	if(type == "edit" && ( null == password || password == "" )){
	 	$("#password_check").removeClass().addClass("hk_icon_img face_nor dis14");
		return true;
	}
    var reg1 = /[a-z]/i;
    var reg2 = /[0-9]/;
    var complex = 0;
    if (reg1.test(password)) {
        ++complex;
    }
    if (reg2.test(password)) {
        ++complex;
    }
    if (complex < 2 || password.length < 8 || password.indexOf(" ") >=0) {
        $("#password_check").removeClass().addClass("hk_icon_img face dis14")
        if(flag){	
        	$("#password").focus();
        }
        return false;
    } 
    $("#password_check").removeClass().addClass("hk_icon_img face_nor dis14")
	return true;
}

function checkNumber(number){
	 var reg2 = /[0-9]/;
	 if (! reg2.test(number)) {
	 	
	 }
}

function deleteUser(id){
	var d = dialog({
		title: lang["tip"],
		content: lang["are.you.sure.remove"],
		okValue: lang["sure"],
		ok: function () {
			this.title(lang["deleting"]);
			$.ajax({
			    type: 'POST',
			    traditional:true,
				url: "deleteUser",
				data: {
					"id":id,
				},
				success: function(result){
					console.log(result);
					if( '' != result['code'] && result['code'] == 200){
						var d = dialog({
							content: lang["make.success"]
						});
						d.show();
						setTimeout(function () {
							d.close().remove();
						}, 2000);
						location.href ="/user/manageUserList";
					}else{
						var d = dialog({
							content: lang["make.failure"]
						});
						d.show();
						setTimeout(function () {
							d.close().remove();
						}, 2000);
					}
				},
				error:function(){
					console.log("error");
				}
			});
			return true;
		},
		cancelValue: lang["cancel"],
		cancel: function () {}
	});
	d.show();
}

