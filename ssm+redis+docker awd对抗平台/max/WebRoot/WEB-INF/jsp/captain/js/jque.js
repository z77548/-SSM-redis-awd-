window.onload = function(a) {
	var submit = document.getElementById("submit");
	var a = 0; //用户名
	function $namecheck() {
		var name = $a("name").value;
		if (name == "") {
			a = 0;
			$a("a-name").style.color = "red";
			$a("name").style.border = '2px solid red';
			$a('a-name').innerText = "✘战队名称不能为空";
		} else if ((name.length < 3) || (name.length > 18)) {
			a = 0;
			$a("a-name").style.color = "red";
			$a("name").style.border = '2px solid red';
			$a('a-name').innerText = "✘格式错误,长度应为3-18个字符";
		} else {

			$.ajax({
				type : "get",
				url : "TeamName.do?Name=" + name,
				cache : false,
				dataType : "text", //json,xml,script,html
				success : function(data) {
					if (data == "true") {
						a = 1;
						$a('a-name').innerText = " ";
						$a("a-name").style.color = "green";
						$a("name").style.border = '2px solid green';
						$a('a-name').innerText = "战队名称可以使用";
					} else if (data == "false") {
						a = 0;
						$a("a-name").style.color = "red";
						$a("name").style.border = '2px solid red';
						$a('a-name').innerText = "✘战队名称已经存在";
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




	submit.cc = function() {

		var name = $a("name").value;
		$namecheck();
		if (a == 1) {
			$.ajax({
				type : "post",
				url : "TeamCreat.do",
				data : {
					"Name" : name,
				},
				cache : false,
				dataType : "text", //json,xml,script,html
				success : function(data) {
					if (data == "true") {
						alert("创建成功 ");
						window.location.href = "../Userindex";
					} else {
						alert("创建失败,请检查是否已经加入战队。");
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
	$a("name").onfocus = function fn() {}
	$a("name").onblur = function fn() {
		var name = $a("name").value;
		$namecheck();
	}

}