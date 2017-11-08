function resetAllData(){
	var id = $('#id').val();
	if(id == "") {
		location.href ="/user/editAddMenu";
	} else {
		location.href ="/user/editAddMenu?id="+id;
	}
}	 
function setData(obj,num) {
	if (!submitValidate()) {
		return false;
	}
	var url = $("#editAddform").attr("action");
	var fd = new FormData($("#editAddform")[0]);
	fd.append("num", num);
	$.ajax({
		url : url,
		type : 'post',
		data : fd,
		processData : false,
		contentType : false,
		success : function(result) {
			var code = result.code;
			var msg = result.description;
	        if (code == 205) {
	        	//保存并返回
	        	location.href ="/user/listMenu";
	        } else if (code == 204) {
	        	//保存
	        	showMsg(msg);
	        	location.reload(true);   
	        } else if (code == 203)  {
	        	showMsg(msg);
	        }else{
	        	showMsg(msg);
	        }
		}, // 提交后的回调函数
		error : function(result) {
			showMsg(result);
		}
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

function submitValidate() {
	var flag = true;
	var serializeArray=$("input").serializeArray();
	if (typeof(serializeArray)!='undefined'&&null!=serializeArray&&''!=serializeArray) {
		var validate = new Validate();
		$.each( serializeArray, function(i, field) { 
			if (field.name=='menuName' || field.name=='url' || field.name=='i18nKey' ||field.name.indexOf("aclBtn") > 0 ||field.name.indexOf("i18nKey") > 0||field.name.indexOf("aclUrl") > 0) {
				if (!validate.isNotNull(field.value)) {
					var name;
					if (field.name.length > 10) {
						$("input[tempid^="+field.name.substr(8,4)+"_"+field.name.substr(5,1)+"]").focus();
						name = $("input[tempid^="+field.name.substr(8,4)+"_"+field.name.substr(5,1)+"]").attr("attribute");
					}else {
						$("input[name="+field.name+"]").focus();
						name = $("input[name="+field.name+"]").attr("attribute");
					}
					showMsg(lang["data.is.not.null"].replace("{0}",name));
					flag = false;
					return false;
				}
			}
		});
	}
	return flag;
}

function deleteMenu(id){
 	var d = dialog({
		title: lang["tip"],
		content: lang["are.you.sure.remove"],
		okValue: lang["sure"],
		ok: function () {
			this.title(lang["deleting"]);
			$.ajax({
			    type: 'POST',
			    traditional:true,
				url: "deleteMenu",
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
						location.href ="/user/listMenu";
					}else{
						var d = dialog({
							content: lang["make.failure"]+","+result['description']
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