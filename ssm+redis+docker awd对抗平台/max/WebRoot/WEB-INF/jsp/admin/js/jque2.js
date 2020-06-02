window.onload = function(a) {

	var submit = document.getElementById("btn");
	var a = 0;
	var b = 0;
	var c = 0;
	var d = 0;
	function $xzcheck() {
		var name = $a("xz-input").value;
		if (name == "") {
			a = 0;
			$a("xz-input").style.border = '2px solid red';
		} else {
			a = 1;
			$a("xz-input").style.border = '2px solid green';
		}


	}
	function $dacheck() {
		var passwd = $a("da-input").value;
		if (passwd == "") {
			b = 0;
			$a("da-input").style.border = '2px solid red';
		} else {
			b = 1;
			$a("da-input").style.border = '2px solid green';
		}
	}

	function $mccheck() {
		var passwd = $a("mc-input").value;
		if (passwd == "") {
			c = 0;
			$a("mc-input").style.border = '2px solid red';
		} else {
			c = 1;
			$a("mc-input").style.border = '2px solid green';
		}
	}

	function $jjcheck() {
		var passwd = $a("jj-input").value;
		if (passwd == "") {
			d = 0;
			$a("jj-input").style.border = '2px solid red';
		} else {
			d = 1;
			$a("jj-input").style.border = '2px solid green';
		}
	}



	submit.cc = function() {
		var ac = document.getElementById("pid");
		var bc = ac.options[ac.selectedIndex].value;
		var ssid = $a("ssid-input").innerText;
		var ssmc = $a("ssmc-input").innerText;
		if (bc == 1 || bc == 2) {
			var xz = $a("xz-input").value;
			$xzcheck();
		} else if (bc = 3) {
			var mc = $a("mc-input").value;
			var jj = $a("jj-input").value;
			var fj = $a("fj-input").value;
			$mccheck();
			$jjcheck();
		} else {
		}
		var da = $a("da-input").value;

		$dacheck();

		if (a == 1 && b == 1 && c == 0 && d == 0) {
			$.ajax({
				type : "post",
				url : "../fbtm",
				data : {
					"ssid" : ssid,
					"ssmc" : ssmc,
					"type" : bc,
					"xz" : xz,
					"da" : da,
				},
				cache : false,
				dataType : "text", //json,xml,script,html
				success : function(data) {
					if (data == 0) {

						alert("发布成功 ");
					} else {
						alert("发布失败");
					}
				},
				error : function(data) {
					alert(data);
				}
			});
		} else if (a == 0 && b == 1 && c == 1 && d == 1) {
			var formData = new FormData();
			formData.append("ssid", ssid);
			formData.append("ssmc", ssmc);
			formData.append("type", bc);
			formData.append("mc", mc);
			formData.append("jj", jj);
			formData.append("da", da);
			formData.append("fj", $('#fj-input')[0].files[0]);
	

			$.ajax({
				type : "post",
				url : "../fbtm",
				async : false,
				data : formData,
				cache : false,
				processData : false, // 使数据不做处理
				contentType : false, // 不要设置Content-Type请求头
				dataType : "text", //json,xml,script,html
				success : function(data) {
					if (data == 0) {

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


		} else {
		}


	}

	function $a(id) {
		return document.getElementById(id)
	}

}