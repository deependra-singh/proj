function validateForgotPassword()
{
	var emailId = forgotpasswords.email.value;
	atpos = emailId.indexOf("@");
	dotpos = emailId.lastIndexOf(".");
	
	if(emailId.charAt(0)==" " )
	{
		alert("Spaces are not allowed !!!");
		return false;
	}
	else if(emailId.length == 0 || emailId=="")
	{
		alert("Email Id can not be empty !!!");
		return false;
	}
	else if (atpos < 1 || ( dotpos - atpos < 2 )) 
	{
	       alert("Invalid Emailid !!!");
	       
	       return false;
	     
	}
	
	/*Pattern p=Pattern.compile("([A-Za-z0-9])+([A-Za-z0-9])@([A-Za-z])+(\\.[A-Za-z]{2,})"); 
	Matcher m=p.matcher(emailId);
	boolean b=m.matches();

	
	if(emailId.charAt(0)==" " )
	{
		alert("Spaces are not allowed !!!");
		return false;
	}
	else if(emailId.length == 0 || emailId=="")
	{
		alert("Email Id can not be empty !!!");
		return false;
	}
	
	else if ( !isNaN(emailId.charAt(0)))
	{
		alert("First letter should be character !!!");
		return false;
	}
	
	else if(b==false)
	{
		alert("Invalid Email Id !!!");
		return false;
	}*/

	
	
	
	return true;
	
}