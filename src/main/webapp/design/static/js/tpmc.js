$(function() {
	//选择；box
	$(".hk_span_com ").click(function() {
		$(this).find('span').toggleClass("checkbox_click");
	});
	//滚动条
	$(".sel_left").niceScroll({
		cursorcolor : "#35404d",
		autohidemode : false
	});
});
function moveOption(e1, e2) {
	try {
		for (var i = 0; i < e1.options.length; i++) {
			if (e1.options[i].selected) {
				var e = e1.options[i];
				e2.options.add(new Option(e.text, e.value));
				e1.remove(i);
				ii = i - 1;
			}
		}
		document.myform.city.value = getvalue(document.myform.list2);
	} catch (e) {
	}
}
function getvalue(geto) {
	var allvalue = "";
	for (var i = 0; i < geto.options.length; i++) {
		allvalue += geto.options[i].value + ",";
	}
	return allvalue;
}
function changepos(obj, index) {
	if (index == -1) {
		if (obj.selectedIndex > 0) {
			obj.options(obj.selectedIndex).swapNode(
					obj.options(obj.selectedIndex - 1));
		}
	} else if (index == 1) {
		if (obj.selectedIndex < obj.options.length - 1) {
			obj.options(obj.selectedIndex).swapNode(
					obj.options(obj.selectedIndex + 1));
		}
	}
}