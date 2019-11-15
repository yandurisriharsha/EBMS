function validate()
{
	var username = document.getElementById("empuserid").value;
	var password = document.getElementById("emppwd").value;
	
	
	var usernamePattern=/^[A-Z]+$/;
	var passwordPattern=/^[a-zA-Z]+[@\$\#]+[0-9]+$/;
	
	if (username.length == 0) {
		document.getElementById("usererror").innerText = "**Please Enter Your UserName";
		document.getElementById("empuserid").focus();
		return false;
	} else {
		document.getElementById("usererror").innerText = "";
	}
	if (username.length <= 5) {
		document.getElementById("usererror").innerText = "**Enter Your UserName with min 6characters";
		document.getElementById("empuserid").focus();
		return false;

	} else {
		document.getElementById("usererror").innerText = "";
	}
	if (!username.match(usernamePattern)) {
		document.getElementById("usererror").innerText = "**Enter Your UserName and Should be capital characters";
		document.getElementById("empuserid").focus();
		return false;
	} else {
		document.getElementById("usererror").innerText = "";
	}
	
	if (password.length == 0) {
		document.getElementById("pwderror").innerText = "**Please Enter Your Password";
		document.getElementById("emppwd").focus();
		return false;
	} else {
		document.getElementById("pwderror").innerText = "";
	}
	
	if (!password.match(passwordPattern)) {
		document.getElementById("pwderror").innerText = "**Enter Your Password with uppercases,lowercases,numbers,symbols like:$,@,#";
		document.getElementById("emppwd").focus();
		return false;
	} else {
		document.getElementById("pwderror").innerText = "";
	}
}