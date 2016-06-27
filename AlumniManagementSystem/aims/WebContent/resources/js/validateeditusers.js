function validateEditUsers()
{
	
	var fName=edituserss.fname.value;
	//alert("fname: " +fName);
	var lName=edituserss.lname.value;
	//alert("lname: " +lName);
	
	var emailId=edituserss.email.value;
	//alert("email: " +emailId);
	
	var mobileNo=edituserss.mobileno.value;
	//alert("mbl: " +mobileNo);
	
	var roles=edituserss.role.value;
	//alert("role: " +roles);
	
	var password=edituserss.password.value;
	//alert("pass: " +password);
	
	atpos = emailId.indexOf("@");
	dotpos = emailId.lastIndexOf(".");
	
	
	
	/*-------------Validation for First Name----------*/
	if(fName.indexOf(" ")>=0 )
	{
		alert("Spaces are not allowed in First Name field !!!");
		return false;
	}
	else if(fName.length == 0 || fName=="")
	{
		alert("First Name can not be empty !!!");
		return false;
	}
	else if ( !isNaN(fName.charAt(0)))
	{
		alert("Please enter character values !!!");
		return false;
	}
	
	
	/*-------------Validation for Last Name----------*/
	else if(lName.indexOf(" ")>=0 )
	{
		alert("Spaces are not allowed in Last Name field !!!");
		return false;
	}
	else if(lName.length == 0 || lName=="")
	{
		alert("Last Name can not be empty !!!");
		return false;
	}
	else if ( !isNaN(lName.charAt(0)))
	{
		alert("Please enter character values !!!");
		return false;
	}
	
	
	/*-------------Validation for Email Id----------*/
	else if(emailId.indexOf(" ")>=0 )
	{
		alert("Spaces are not allowed in Email Id field !!!");
		return false;
	}
	else if(emailId.length == 0 || emailId=="")
	{
		alert("Email Id can not be empty !!!");
		return false;
	}
		
	else if ( !isNaN(emailId.charAt(0)))
	{
		alert("First letter of Email Id should be a character !!!");
		return false;
	}
		
	else if (atpos < 1 || ( dotpos - atpos < 2 )) 
	{
	       alert("Invalid EmailId !!!");
	       return false;
	     
	}
	
	
	/*-------------Validation for Mobile No----------*/
	
	else if(mobileNo.indexOf(" ")>=0 )
	{
		alert("Spaces are not allowed in Mobile No field !!!");
		return false;
	}
	else if(mobileNo.length == 0 || mobileNo=="")
	{
		alert("Mobile No can not be empty !!!");
		return false;
	}
	else if(mobileNo.length < 10 )
	{
		alert("Enter 10 digit Mobile No !!!");
		return false;
	}
		
	else if ( isNaN(mobileNo))
	{
		alert("Enter only numeric values for mobile no!!!");
		return false;
	}
	else if ( mobileNo.charAt(0)=="." || mobileNo.charAt(1)==".")
	{
		alert("Decimals are not allowed !!!");
		return false;
	}
	
	
	/*-------------Validation for role selection----------*/
	
	else if(roles.indexOf(" ")>=0 )
	{
		alert("Spaces are not allowed in Role field !!!");
		return false;
	}
	else if(roles.length == 0 || roles=="")
	{
		alert("Please Select Role !!!");
		return false;
	}
	
	/*-------------Validation for password ---------*/
	else if(password.indexOf(" ")>=0 )
	{
		alert("Spaces are not allowed in Password field !!!");
		return false;
	}
	else if(password.length == 0 || password=="")
	{
		alert("Password can not be empty !!!");
		return false;
	}
		
	return true;

}