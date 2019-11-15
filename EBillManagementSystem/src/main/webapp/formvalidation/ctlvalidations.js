function clvalidate() {
		var username = document.getElementById("custuserid").value;
		var password = document.getElementById("custpwd").value;

		var usernamePattern = /^[A-Z]+$/;
		var passwordPattern = /^[a-zA-Z]+[@\$\#]+[0-9]+$/;

		if (username.length == 0) {
			document.getElementById("usererror").innerText = "**Please Enter Your UserName";
			document.getElementById("custuserid").focus();
			return false;
		} else {
			document.getElementById("usererror").innerText = "";
		}
		if (username.length <= 5) {
			document.getElementById("usererror").innerText = "**Enter Your UserName with min 6characters";
			document.getElementById("custuserid").focus();
			return false;

		} else {
			document.getElementById("usererror").innerText = "";
		}
		if (!username.match(usernamePattern)) {
			document.getElementById("usererror").innerText = "**Enter Your UserName and Should be capital characters";
			document.getElementById("custuserid").focus();
			return false;
		} else {
			document.getElementById("usererror").innerText = "";
		}

		if (password.length == 0) {
			document.getElementById("pwderror").innerText = "**Please Enter Your Password";
			document.getElementById("custpwd").focus();
			return false;
		} else {
			document.getElementById("pwderror").innerText = "";
		}

		if (!password.match(passwordPattern)) {
			document.getElementById("pwderror").innerText = "**Enter Your Password with uppercases,lowercases,numbers,symbols like:$,@,#";
			document.getElementById("custpwd").focus();
			return false;
		} else {
			document.getElementById("pwderror").innerText = "";
		}
	}