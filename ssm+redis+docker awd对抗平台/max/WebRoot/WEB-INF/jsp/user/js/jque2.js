window.onload = function(a) {
	var submit = document.getElementById("submit");
	var a = 0; //用户名
	function $namecheck() {
		var name = $a("name").value;
		if (name == "") {
			a = 0;
			$a("a-name").style.color = "red";
			$a("name").style.border = '2px solid red';
			$a('a-name').innerText = "✘战队ID不能为空";
		} else if ((name.length < 0) || (name.length > 18)) {
			a = 0;
			$a("a-name").style.color = "red";
			$a("name").style.border = '2px solid red';
			$a('a-name').innerText = "✘格式错误";
		} else {

			$.ajax({
				type : "get",
				url : "./TeamCheck.do?id=" + name,
				cache : false,
				dataType : "text", //json,xml,script,html
				success : function(data) {
					if (data == 0) {
						a = 1;
						$a('a-name').innerText = " ";
						$a("a-name").style.color = "green";
						$a("name").style.border = '2px solid green';
						$a('a-name').innerText = "可以加入";
					} else if (data == 1) {
						a = 0;
						$a("a-name").style.color = "red";
						$a("name").style.border = '2px solid red';
						$a('a-name').innerText = "✘战队不存在";
					} else if (data == 2) {
						a = 0;
						$a("a-name").style.color = "red";
						$a("name").style.border = '2px solid red';
						$a('a-name').innerText = "✘战队人数已满";
					} else if (data == 3) {
						a = 0;
						$a("a-name").style.color = "red";
						$a("name").style.border = '2px solid red';
						$a('a-name').innerText = "✘您已经加入战队";
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
				url : "JoinTeam.do",
				data : {
					"id" : name,
				},
				cache : false,
				dataType : "text", //json,xml,script,html
				success : function(data) {
					if (data == "true") {
						alert("申请成功，等待队长审核！ ");
					} else {
						alert("加入失败");
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