function saveGroup(obj){
	var groupName =  $("#groupName").val()
	var staffLevel = $("#staffLevel").val();
	if(!checkGroupName(groupName)){
		return false;
	}
	if(!checkStaffLevel(staffLevel)){
		return false;
	}
	var code = $("#code").val();
	var groupId = $("#group_id").val();
	var menuIds = [];
	var aclIds = [];
	var userIds = [];
	
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	var ids = zTree.getCheckedNodes(true);
	for(var i=0;i<ids.length;i++){
			var id = ids[i].id;
			if (id.toString().indexOf("a_")>=0) {
				aclIds.push(parseInt(id.toString().substring("2")));
			}else {
				menuIds.push(id);
			}
	}
	var eles = $("span[class*='checkbox_click']").next("b");
	$(eles).each(function(){
		userIds.push( this.id);
	})
	
	$.ajax({
	    type: 'POST',
	    traditional:true,
		url: "/user/saveGroup",
		data: {
			"id":groupId,
			"groupName": groupName,
			"code": code, 
			"staffLevel":staffLevel,
			"userIds":userIds,
			"menuIds":menuIds,
			"aclIds":aclIds
		},
		success: function(data){

			console.log(data);
			if( '' != data['code'] && data['code'] == 200){
				var d = dialog({
					content: lang["make.success"]
				});
				d.show();
				setTimeout(function () {
					d.close().remove();
				}, 2000);
				if(obj == 0){
					location.href ="/user/groupList";
				}else{
					location.href = window.location.href;
				}
			}else{
				var d = dialog({
					content: data['result']
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

function checkGroupName(groupName){
	if(groupName == null || groupName == undefined || groupName == ""){
		$("#groupName").focus();
		return false;
	}
	if(groupName.length > 80){
		$("#groupName").focus();
		return false;
	}
	return true;
}
function checkStaffLevel(staffLevel){
	if(staffLevel == null || staffLevel == undefined || staffLevel == ""){
		$("#staffLevel").focus();
		return false;
	}
	return true;
}

function deleteGroup(id){
	var d = dialog({
		title: lang["tip"],
		content: lang["are.you.sure.remove"],
		okValue: lang["sure"],
		ok: function () {
			this.title(lang["deleting"]);
			$.ajax({
			    type: 'POST',
			    traditional:true,
				url: "/user/deleteGroup",
				data: {
					"id":id,
				},
				success: function(data){
					console.log(data);
					if( '' != data['code'] && data['code'] == 200){
						var d = dialog({
							content: lang["make.success"]
						});
						d.show();
						setTimeout(function () {
							d.close().remove();
						}, 2000);
						location.href ="/user/groupList";
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
