window.onload = function(a) {
	var submit = document.getElementById("submit");

	var b = 0; //密码
	var c = 0; //确认密码
	var e = 0; //电话
	var g = 0; //邮箱

	function $passwdcheck() {
		var passwd = $a("passwd").value;
		if (passwd == "") {
			b = 0;
			$a("a-passwd").style.color = "red";
			$a("passwd").style.border = '2px solid red';
			$a('a-passwd').innerText = "✘密码不能为空";
		} else if ((passwd.length < 6) || (passwd.length > 18)) {
			b = 0;
			$a("a-passwd").style.color = "red";
			$a("passwd").style.border = '2px solid red';
			$a('a-passwd').innerText = "✘格式错误,长度应为6-18个字符";
		} else {
			b = 1;
			$a('a-passwd').innerText = " ";
			$a("a-passwd").style.color = "green";
			$a("passwd").style.border = '2px solid green';

		}

	}

	function $passwd2check() {
		var passwd = $a("passwd2").value;
		if (passwd == "") {
			c = 0;
			$a("a-passwd2").style.color = "red";
			$a("passwd2").style.border = '2px solid red';
			$a('a-passwd2').innerText = "✘密码不能为空";
		} else if ((passwd.length < 6) || (passwd.length > 18)) {
			c = 0;
			$a("a-passwd2").style.color = "red";
			$a("passwd2").style.border = '2px solid red';
			$a('a-passwd2').innerText = "✘格式错误,长度应为6-18个字符";
		} else if (passwd != ($a("passwd").value)) {
			c = 0;
			$a("a-passwd2").style.color = "red";
			$a("passwd2").style.border = '2px solid red';
			$a('a-passwd2').innerText = "✘两次输入密码不相符";

		} else {
			c = 1;
			$a('a-passwd2').innerText = " ";
			$a("a-passwd2").style.color = "green";
			$a("passwd2").style.border = '2px solid green';

		}

	}




	function $iphonecheck() {
		var val = $a("iphone").value;
		var regName = /(^1[3|4|5|7|8|9]\d{9}$)|(^09\d{8}$)/;
		if (!regName.test(val)) {
			e = 0;
			$a("a-iphone").style.color = "red";
			$a("iphone").style.border = '2px solid red';
			$a('a-iphone').innerText = "✘请输入正确的手机号";
		} else {
			e = 1;
			$a('a-iphone').innerText = " ";
			$a("a-iphone").style.color = "green";
			$a("iphone").style.border = '2px solid green';
		}
	}

	function $emailcheck() {
		var val = $a("email").value;
		var regName = /^[A-Za-z0-9]+([_\.][A-Za-z0-9]+)*@([A-Za-z0-9\-]+\.)+[A-Za-z]{2,6}$/;
		if (!regName.test(val)) {
			g = 0;
			$a("a-email").style.color = "red";
			$a("email").style.border = '2px solid red';
			$a('a-email').innerText = "✘请输入正确的邮箱";
		} else {
			g = 1;
			$a('a-email').innerText = " ";
			$a("a-email").style.color = "green";
			$a("email").style.border = '2px solid green';
		}
	}

	submit.cc = function() {

		var passwd = $a("passwd").value;
		var iphone = $a("iphone").value;
		var email = $a("email").value;
		$passwdcheck();
		$passwd2check();
		$iphonecheck();
		$emailcheck();
		if (b == 1 && c == 1 && e == 1 && g == 1) {
			passwd = sha3_256(passwd);
			$.ajax({
				type : "post",
				url : "PersonalChange.do",
				data : {
					"passwd" : passwd,
					"iphone" : iphone,
					"email" : email,
				},
				cache : false,
				dataType : "text", //json,xml,script,html
				success : function(data) {
					if (data == "true") {

						alert("修改成功 ");
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

	$a("passwd").onblur = function fn() {
		$passwdcheck();
	}
	$a("passwd2").onfocus = function fn() {}
	$a("passwd2").onblur = function fn() {
		$passwd2check();
	}

	$a("iphone").onblur = function fn() {
		$iphonecheck();
	}
	$a("email").onblur = function fn() {
		$emailcheck();
	}
}