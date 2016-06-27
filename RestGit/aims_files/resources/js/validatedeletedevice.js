function validateDeleteDevice()
{
	var deviceId=deletedevices.device.value;
	//alert("device Id: " +deviceId);
	
	if(deviceId.length == 0 || deviceId=="")
	{
		alert("Please Select Device !!!");
		return false;
	}
	
	return true;
	
	
}