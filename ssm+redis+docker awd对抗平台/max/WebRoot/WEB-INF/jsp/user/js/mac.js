window.onload = function(a) {
	var submit = document.getElementById("submit");
	var e = 0;
	function $maccheck() {
		var val = $a("mac").value;
		var regName = /((([a-f0-9]{2}:){5})|(([a-f0-9]{2}-){5}))[a-f0-9]{2}/gi;
		if (!regName.test(val)) {
			e = 0;
			$a("a-mac").style.color = "red";
			$a("mac").style.border = '2px solid red';
			$a('a-mac').innerText = "✘请输入正确的mac地址";
		} else {
			e = 1;
			$a('a-mac').innerText = " ";
			$a("a-mac").style.color = "green";
			$a("mac").style.border = '2px solid green';
		}
	}
	submit.cc = function() {
		var mac = $a("mac").value;
		$maccheck();
		if (e == 1) {
			$.ajax({
				type : "post",
				url : "MacChange.do",
				data : {
					"mac" : mac,
				},
				cache : false,
				dataType : "text", //json,xml,script,html
				success : function(data) {
				
					if (data == 'true') {
						alert("修改成功");
					} else {
						alert("修改失败");
					}
				},
				error : function(data) {
					alert(data);
				}
			});
		} else {
			return false;
		}
	}
	function $a(id) {
		return document.getElementById(id)
	}
	//获取ID函数

	$a("mac").onblur = function fn() {
		$maccheck();
	}
}