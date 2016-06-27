function validateDateForDevice()
{
	
	var sdate=datefordevice.startdate.value;
	var edate=datefordevice.enddate.value;
		
	var sday=parseInt(sdate.substring(0,2));
	var smonth=parseInt(sdate.substring(3,5));   //26-09-2013
	var syear=parseInt(sdate.substring(6));
	
	if(smonth==0)
		smonth=parseInt(sdate.substring(4,5));
	
	
	var eday=parseInt(edate.substring(0,2));
	var emonth=parseInt(edate.substring(3,5));
	var eyear=parseInt(edate.substring(6));
	
	if(emonth==0)
		emonth=parseInt(edate.substring(4,5));
	

	if(sdate.length == 0 || sdate=="")
	{
		alert("Start Date can not be empty !!!");
		return false;
	}
	
	else if(edate.length == 0 || edate=="")
	{
		alert("End Date can not be empty !!!");
		return false;
	}
	
	else if(eday<sday && emonth<=smonth && eyear<=syear)
	{
		alert("End Date's Day Should be larger !!!");
		return false;
		
	}
	else if(emonth<smonth && eyear<=syear)
	{
		alert("End date's month Should be larger !!!");
		return false;
	}

	else if (syear>eyear)
	{
		alert("End date's year Should be larger !!!");
		return false;
	}
	
	
	return true;
}