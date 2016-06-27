function validateDeleteSchedule()
{
	var scheduleId=deleteschedules.schedule.value;
	//alert("schedule Id: " +scheduleId);
	
	if(scheduleId.length == 0 || scheduleId=="")
	{
		alert("Please Select Schedule !!!");
		return false;
	}
	
	return true;
	
	
}