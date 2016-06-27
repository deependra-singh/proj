function validateDeleteNotification()
{
	var id=deletnotifications.notification.value;
	//alert(" Id: " +id);
	
	if(id.length == 0 || id=="")
	{
		alert("Please Select Notification !!!");
		return false;
	}
	
	return true;
	
	
}