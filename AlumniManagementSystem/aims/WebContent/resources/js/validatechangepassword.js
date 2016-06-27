function validateChangePassword()
{
	
	var oldPass = changepasswords.oldpswd.value;
	var newPass = changepasswords.newpswd.value;
	var confirmNewPass = changepasswords.confirmnewpswd.value;
	
	
	if(oldPass.charAt(0)==" " )
	{
		alert("Spaces are not allowed in Old password field !!!");
		return false;
	}
	else if(oldPass.length == 0 || oldPass=="")
	{
		alert("Old password can not be empty !!!");
		return false;
	}
	
	else if(newPass.charAt(0)==" " )
	{
		alert("Spaces are not allowed in New password field !!!");
		return false;
	}
	else if(newPass.length == 0 || newPass=="")
	{
		alert("New password can not be empty !!!");
		return false;
	}
	
	else if(confirmNewPass.charAt(0)==" " )
	{
		alert("Spaces are not allowed in Confirm new password field !!!");
		return false;
	}
	else if(confirmNewPass.length == 0 || confirmNewPass=="")
	{
		alert("Confirm New password field can not be empty !!!");
		return false;
	}
	
	else if(newPass != confirmNewPass)
	{
		alert(" Passwords are not same !!!");
		return false;
		
	}
	
	
	return true;
	
	

}