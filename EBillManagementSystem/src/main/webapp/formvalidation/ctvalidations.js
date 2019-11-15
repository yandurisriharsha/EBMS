function ctvalidation() {
	var custname = document.getElementById("ctname").value;
	var custadd = document.getElementById("ctadd").value;
	var custmobile = document.getElementById("ctmobile").value;
	var custemail = document.getElementById("ctemail").value;
	var custtype = document.getElementById("cttype").value;

	var custnamePattern = /^[a-z]+$/;
	var custmobilePattern = /^[0-9]+$/;
	var cusstemailPattern = /^[a-z]+[a-z0-9\.\_]+[@]+[a-z]+[.]+[a-z]+$/;

	if (custname.length == 0) {
		// alert("please enter name");
		document.getElementById("cnameerror").innerHTML = "**Please Enter Your Name";
		document.getElementById("ctname").focus();
		return false;
	} else {
		document.getElementById("cnameerror").innerText = "";
	}
	if (custname.length <= 5) {
		// alert("enter name and should be min 6characters");
		document.getElementById("cnameerror").innerHTML = "**Entered name should be min 6characters";
		document.getElementById("ctname").focus();
		return false;

	} else {
		document.getElementById("cnameerror").innerText = "";
	}
	if (!custname.match(custnamePattern)) {
		document.getElementById("cnameerror").innerHTML = "**Entered name should be small characters";
		document.getElementById("ctname").focus();
		return false;

	} else {
		document.getElementById("cnameerror").innerText = "";
	}

	if (custadd.length == 0) {
		document.getElementById("cadderror").innerText = "**Please Enter Your Address";
		document.getElementById("ctadd").focus();
		return false;
	} else {
		document.getElementById("cadderror").innerText = "";
	}

	if (custmobile.length == 0) {
		// alert("enter mobile ");
		document.getElementById("cmobileerror").innerText = "**Enter your mobile number";
		document.getElementById("ctmobile").focus();
		return false;

	} else {
		document.getElementById("cmobileerror").innerText = "";
	}
	if (!custmobile.match(custmobilePattern)) {
		document.getElementById("cmobileerror").innerText = "**Entered mobile number should be numeric";
		document.getElementById("ctmobile").focus();
		return false;

	} else {
		document.getElementById("cmobileerror").innerText = "";
	}
	if (custmobile.length != 10) {
		// alert("enter mobile number should be 10");
		document.getElementById("cmobileerror").innerText = "**Entered mobile number should be 10";
		document.getElementById("ctmobile").focus();
		return false;

	} else {
		document.getElementById("cmobileerror").innerText = "";
	}

	if (custemail.length == 0) {
		// alert("enter email address");
		document.getElementById("cemailerror").innerHTML = "**Enter Your email address";
		document.getElementById("ctemail").focus();
		return false;

	} else {
		document.getElementById("cemailerror").innerText = "";
	}
	if (!custemail.match(custemailPattern)) {
		document.getElementById("cemailerror").innerHTML = "**Enter email ex. abc@xyz.com";
		document.getElementById("ctemail").focus();
		return false;

	} else {
		document.getElementById("cemailerror").innerText = "";
	}

	if (custtype.length == 0) {
		document.getElementById("ctypeerror").innerText = "**Please select Your connection type";
		document.getElementById("cttype").focus();
		return false;
	} else {
		document.getElementById("ctypeerror").innerText = "";
	}
}