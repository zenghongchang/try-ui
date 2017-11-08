$(function(){
	$("#input_filter , .input_filter").bind("keyup",function(){
		var input=$(this).val().toLowerCase();
		var selector=$(this).next("select");
		var optionor=$(selector).find("option");
		for(var i=0;i<optionor.length;i++){
			var option=optionor[i];
			var span_el=$(option).parent();
			if(span_el.is("span")){
				$(option).unwrap();
			}
			if(option.text.toLowerCase().indexOf(input)<=-1){
			    $(option).wrap('<span></span>').hide();
			}else{
			    $(option).show();
			} 
		}
		if(null==input || ''==input || typeof(input)=="undefined"){
			$(selector).val("");
		}
	})
})