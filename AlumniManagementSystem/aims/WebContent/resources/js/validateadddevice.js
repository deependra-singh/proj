function validateAddDevice()
{
	var deviceName=adddevices.devicename.value;
	//alert("device name: " +deviceName);
	
	var deviceType=adddevices.devicetype.value;
	//alert("device type: " +deviceType);
		
	var vcps=adddevices.vcp.value;
	//alert("vcp : " +vcps);
	
	
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
	
	
	
	/*-------------Validation for deviceType----------*/
	
	else if(deviceType.indexOf(" ")>=0 )
	{
		alert("Spaces are not allowed in Device Type field !!!");
		return false;
	}
	else if(deviceType.length == 0 || deviceType=="")
	{
		alert("Please Select Device Type !!!");
		return false;
	}
	
	
	/*-------------Validation for VCP selection----------*/
	
	else if(vcps.indexOf(" ")>=0 )
	{
		alert("Spaces are not allowed in Virtual Comp Port field !!!");
		return false;
	}
	else if(vcps.length == 0 || vcps=="")
	{
		alert("Please Select Virtual Comp Port !!!");
		return false;
	}
	
	return true;
	
}