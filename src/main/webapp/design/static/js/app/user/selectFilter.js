function selectFilterSub(event){
	var input = $("#combobox_sub").val().toLowerCase();
	$('#user_all_option_sub option').each(function () {
		if(this.text.toLowerCase().indexOf(input)<=-1){
			var spanEL=$(this).parent();
			if(spanEL.is("span")){
				 $(this).unwrap();
			}
		    $(this).wrap('<span></span>').hide();
		}else{
		    $("#user_all_option_sub").children("span").children(this).unwrap();
		    $(this).show();
		}
	})
}

function selectFilterSup(event){
	var input = $("#combobox_sup").val().toLowerCase();
	$('#user_all_option_sup option').each(function () {
		if(this.text.toLowerCase().indexOf(input)<=-1){
			var spanEL=$(this).parent();
			if(spanEL.is("span")){
				 $(this).unwrap();
			}
		    $(this).wrap('<span></span>').hide();
		}else{
		    $("#user_all_option_sup").children("span").children(this).unwrap();
		    $(this).show();
		}
	})
}
