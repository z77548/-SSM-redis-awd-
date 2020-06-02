window.onload = function(a) {
	var submit = document.getElementById("submit");
	var a = 0; //用户名
	var b = 0; //密码
	var c = 0; //确认密码
	var d = 0; //真实姓名
	var e = 0; //电话
	var f = 0; //身份证
	var g = 0; //邮箱
	function $namecheck() {
		var name = $a("name").value;
		if (name == "") {
			a = 0;
			$a("a-name").style.color = "red";
			$a("name").style.border = '2px solid red';
			$a('a-name').innerText = "✘用户名不能为空";
		} else if ((name.length < 6) || (name.length > 18)) {
			a = 0;
			$a("a-name").style.color = "red";
			$a("name").style.border = '2px solid red';
			$a('a-name').innerText = "✘格式错误,长度应为6-18个字符";
		} else {

			$.ajax({
				type : "get",
				url : "../logoin/Verification.do?name=" + name,
				cache : false,
				dataType : "text", //json,xml,script,html
				success : function(data) {
					if (data == 0) {
						a = 1;
						$a('a-name').innerText = " ";
						$a("a-name").style.color = "green";
						$a("name").style.border = '2px solid green';
					} else if (data == 1) {
						a = 0;
						$a("a-name").style.color = "red";
						$a("name").style.border = '2px solid red';
						$a('a-name').innerText = "✘用户名已经存在";
					} else {
						alert("ERROR");
					}
				},
				error : function(data) {
					alert(data);
				}
			});
		}
	}

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



	function $truenamecheck() {
		var val = $a("truename").value;
		var regName = /^[\u4E00-\u9FA5]{2,4}$/;
		if (!regName.test(val)) {
			d = 0;
			$a("a-truename").style.color = "red";
			$a("truename").style.border = '2px solid red';
			$a('a-truename').innerText = "✘请输入正确的姓名";
		} else {
			d = 1;
			$a('a-truename').innerText = " ";
			$a("a-truename").style.color = "green";
			$a("truename").style.border = '2px solid green';
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

	function $idcardcheck() {
		var val = $a("idcard").value;
		var regName = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
		if (!regName.test(val)) {
			f = 0;
			$a("a-idcard").style.color = "red";
			$a("idcard").style.border = '2px solid red';
			$a('a-idcard').innerText = "✘请输入正确的身份证号";
		} else {
			f = 1;
			$a('a-idcard').innerText = " ";
			$a("a-idcard").style.color = "green";
			$a("idcard").style.border = '2px solid green';
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

	function $codecheck() {
		var code = $a("code").value;
		if (code == "") {
			c = 0;
			$a("a-code").style.color = "red";
			$a("code").style.border = '2px solid red';
			$a('a-code').innerText = "✘验证码不能为空";
		} else if (code.length != 4) {
			c = 0;
			$a("a-code").style.color = "red";
			$a("code").style.border = '2px solid red';
			$a('a-code').innerText = "✘验证码錯誤";
		} else {
			c = 1;
			$a('a-code').innerText = " ";
			$a("a-code").style.color = "green";
			$a("code").style.border = '2px solid green';

		}
	}
	submit.cc = function() {

		var name = $a("name").value;
		var passwd = $a("passwd").value;
		var code = $a("code").value;
		var truename = $a("truename").value;
		var idcard = $a("idcard").value;
		var iphone = $a("iphone").value;
		var email = $a("email").value;
		$namecheck();
		$passwdcheck();
		$codecheck();
		$passwd2check();
		$truenamecheck();
		$iphonecheck();
		$idcardcheck();
		$emailcheck();
		if (a == 1 && b == 1 && c == 1 && d == 1 && e == 1 && f == 1 && g == 1) {
			passwd = sha3_256(passwd);
			$.ajax({
				type : "post",
				url : "../sign/signer.do",
				data : {
					"name" : name,
					"passwd" : passwd,
					"truename" : truename,
					"idcard" : idcard,
					"iphone" : iphone,
					"email" : email,
					"code" : code,
				},
				cache : false,
				dataType : "text", //json,xml,script,html
				success : function(data) {
					if (data == "注册成功") {

						alert("注册成功 ");
						window.location.href = "../home.do";
					} else if (data == "验证码错误") {
						$a("codeimage").src = '../code/code.do?tm=' + Math.random()
						$a("a-code").style.color = "red";
						$a("code").style.border = '2px solid red';
						$a('a-code').innerText = "✘验证码错误";
					} else {
						$a("codeimage").src = '../code/code.do?tm=' + Math.random()

						alert("注册失败");
					}
				},
				error : function(data) {
					$a("codeimage").src = '../code/code.do?tm=' + Math.random()

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
	$a("name").onfocus = function fn() {}
	$a("name").onblur = function fn() {
		var name = $a("name").value;
		$namecheck();
	}
	$a("code").onblur = function fn() {
		$codecheck();
	}
	$a("passwd").onfocus = function fn() {}
	$a("passwd").onblur = function fn() {
		$passwdcheck();
	}
	$a("passwd2").onfocus = function fn() {}
	$a("passwd2").onblur = function fn() {
		$passwd2check();
	}
	$a("truename").onfocus = function fn() {}
	$a("truename").onblur = function fn() {
		$truenamecheck();
	}
	$a("iphone").onblur = function fn() {
		$iphonecheck();
	}
	$a("idcard").onblur = function fn() {
		$idcardcheck();
	}
	$a("email").onblur = function fn() {
		$emailcheck();
	}
}