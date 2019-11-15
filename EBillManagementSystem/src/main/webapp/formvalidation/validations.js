function validation() {
		var empname = document.getElementById("name").value;
		var empmobile = document.getElementById("mobile").value;
		var empadd = document.getElementById("add").value;
		var empprofile = document.getElementById("profile").value;
		var namePattern = /^[a-z]+$/;
		var mobilePattern = /^[0-9]+$/;
		
		if (empname.length == 0) {
			document.getElementById("error").innerText = "Please Enter Your Name";
			document.getElementById("name").focus();
			return false;
		} else {
			document.getElementById("error").innerText = "";
		}
		if (empname.length <= 5) {
			document.getElementById("error").innerText = "Enter Your Name with min 6characters";
			document.getElementById("name").focus();
			return false;

		} else {
			document.getElementById("error").innerText = "";
		}
		if (!empname.match(namePattern)) {
			document.getElementById("error").innerText = "Enter Your Name and Should be small characters";
			document.getElementById("name").focus();
			return false;
		} else {
			document.getElementById("error").innerText = "";
		}
		if (empadd.length == 0) {
			document.getElementById("error1").innerText = "Please Enter Your Address";
			document.getElementById("add").focus();
			return false;
		} else {
			document.getElementById("error1").innerText = "";
		}
		if(empmobile.length==0)
		{
			//alert("enter mobile ");
			document.getElementById("error2").innerText="enter mobile";
			document.getElementById("mobile").focus();
			return false;
			
		}else {
			document.getElementById("error2").innerText = "";
		}
		if(!empmobile.match(mobilePattern))
		{
			document.getElementById("error2").innerText="enter mobile and should be numeric";
			document.getElementById("mobile").focus();
			return false;
			
		}
		else {
			document.getElementById("error2").innerText = "";
		}
		if(empmobile.length!=10)
		{
			//alert("enter mobile number should be 10");
			document.getElementById("error2").innerText="enter mobile number should be 10";
			document.getElementById("mobile").focus();
			return false;
			
		}else {
			document.getElementById("error2").innerText = "";
		}
		
		if (empprofile.length == 0) {
			document.getElementById("error3").innerText = "Please Enter Your Profile";
			document.getElementById("profile").focus();
			return false;
		} else {
			document.getElementById("error3").innerText = "";
		}
	}