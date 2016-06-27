function validateEditDevice()
{
	var id=editdevices.device.value;
	//alert(" Id: " +id);
	
	if(id.length == 0 || id=="")
	{
		alert("Please Select Device !!!");
		return false;
	}
	
	return true;
	
	
}


