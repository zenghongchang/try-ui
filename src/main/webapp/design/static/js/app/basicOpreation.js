// delete by Id	
function deleteById(url, id){
 	var d = dialog({
		title: lang["tip"],
		content: lang["are.you.sure.remove"],
		okValue: lang["sure"],
		ok: function () {
			this.title(lang["deleting"]);
			$.ajax({
			    type: 'GET',
			    traditional:true,
				url: url,
				data: {
					"id":id,
				},
				success: function(result){
					//console.log(result);
					if( '' != result['code'] && result['code'] == 200){
						var d = dialog({
							content: lang["make.success"]
						});
						d.show();
						setTimeout(function () {
							d.close().remove();
						}, 2000);
						location.href = location.href;
					} else {
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
