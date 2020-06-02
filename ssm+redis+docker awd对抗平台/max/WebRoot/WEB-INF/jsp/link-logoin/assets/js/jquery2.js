window.onload = function(a) {

	var submit = document.getElementById("submit");
	var a = 0;
	var b = 0;
	var c = 0;
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
			a = 1;
			$a('a-name').innerText = " ";
			$a("a-name").style.color = "green";
			$a("name").style.border = '2px solid green';
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
		$namecheck();
		$passwdcheck();
		$codecheck();

		if (a == 1 && b == 1 && c == 1) {
			passwd = sha3_256(passwd);
			$.ajax({
				type : "post",
				url : "logoin/logoin.do",
				data : {
					"name" : name,
					"passwd" : passwd,
					"code" : code,
				},
				cache : false,
				dataType : "text", //json,xml,script,html
				success : function(data) {
					if (data == 0) {
						window.location.href = "./home.do";
					} else if (data == "验证码错误") {
						$a("codeimage").src = 'code/code.do?tm=' + Math.random();

						alert("验证码错误");
					} else {
						$a("codeimage").src = 'code/code.do?tm=' + Math.random();

						alert("登陆失败");
					}
				},
				error : function(data) {
					$a("codeimage").src = 'code/code.do?tm=' + Math.random();

					alert(登陆失败);
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
}