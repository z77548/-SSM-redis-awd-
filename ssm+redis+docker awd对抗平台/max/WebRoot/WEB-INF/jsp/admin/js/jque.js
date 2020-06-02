window.onload = function(a) {

	var submit = document.getElementById("btn");

	submit.cc = function() {
		var model = document.getElementById("model").value;
		var count = document.getElementById("count").value;
		var ipaddr = document.getElementById("ipaddr").value;
		var ssid = $a("ssid").innerText;
		$.ajax({
			type : "post",
			url : "dockersubmit.do",
			data : {
				"eventid" : ssid,
				"model" : model,
				"count" : count,
				"ipaddr" : ipaddr,
			},
			cache : false,
			dataType : "text", //json,xml,script,html
			success : function(data) {
				if (data == "true") {
					alert("发布成功 ");
					window.location.href = "ls/index.jsp";
				} else {
					alert("发布失败");
				}
			},
			error : function(data) {
				alert(data);
			}
		});



	}

	function $a(id) {
		return document.getElementById(id)
	}

}