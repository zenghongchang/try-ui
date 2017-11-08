/**
 * dynamic import js/css 
 */
jq.extend({
	includePath: '',
	include: function(file) {
		var files = typeof file == "string" ? [file]:file;
		for (var i = 0; i < files.length; i++) {
			var name = files[i].replace(/^\s|\s$/g, "");
			var att = name.split('.');
			var ext = att[att.length - 1].toLowerCase();
			var isCSS = ext == "css";
			var tag = isCSS ? "link" : "script";
			var attr = isCSS ? " type='text/css' rel='stylesheet' " : " language='javascript' type='text/javascript' ";
			var link = (isCSS ? "href" : "src") + "='" + jq.includePath + name + "'";
			if (jq(tag + "[" + link + "]").length == 0) jq("head").append("<" + tag + attr + link + "></" + tag + ">");
		}
	}
});