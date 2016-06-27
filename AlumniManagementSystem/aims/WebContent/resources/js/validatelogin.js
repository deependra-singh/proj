function validateLogin()
{
		
	var userid=logins.userid.value;
	var password=logins.password.value;
	
	if(userid.charAt(0)==" " )
	{
		alert("Spaces are not allowed in Login Id field !!!");
		return false;
	}
	else if(userid.length == 0 || userid=="")
	{
		alert("User Id can not be empty !!!");
		return false;
	}
	
	
	else if(password.charAt(0)==" " )
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