function validateDeleteUser()
{
	var userId=deleteusers.user.value;
	//alert("user Id: " +userId);
	
	if(userId.length == 0 || userId=="")
	{
		alert("Please Select User !!!");
		return false;
	}
	
	return true;
	
	
}