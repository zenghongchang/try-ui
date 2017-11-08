$(function() {
	var timer = setInterval(function() {
		recordRequest(timer);
	}, 5 * 60 * 1000);
	recordRequest(timer);
});

function recordRequest(timer) {
	var url = "/user/onlineLogger";
	$.post(url, {}, function(result) {
		if (!"false" == String(result)) {
			window.clearInterval(timer);// 用户超时解除定时器
		}
	});
}