function validateEditDevices()
{
	var deviceName=editdevicess.dname.value;
	var vcps=editdevicess.vcp.value;
	
	
	/*-------------Validation for device Name----------*/
	if(deviceName.charAt(0)==" " )
	{
		alert("First character can not be space in device name field!!!");
		return false;
	}
	else if(deviceName.length == 0 || deviceName=="")
	{
		alert("Device Name can not be empty !!!");
		return false;
	}
	else if ( !isNaN(deviceName.charAt(0)))
	{
		alert("First character of device name can not be numeric  !!!");
		return false;
	}
	
	
	/*-------------Validation for VCP----------*/
	
	
	if(vcps.length == 0 || vcps=="")
	{
		alert("Please Select Virtual Comp Port !!!");
		return false;
	}
	
	return true;
	
	
}


