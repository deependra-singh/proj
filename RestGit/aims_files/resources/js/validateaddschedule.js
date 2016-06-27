function validateAddSchedule()
{
	
	var currentDate = new Date();
	var day = currentDate.getDate();
	var month = currentDate.getMonth() + 1;
	var year = currentDate.getFullYear();
	var currDate=day + "/" + month + "/" + year;
	var cday=0;
	var cmonth=0;
	var cyear=0;
	  
	//alert("Current Date: " + currDate);
	currDateLength=currDate.length;
	
	if(currDateLength==10)    // 11/11/2013
	{
		cday=parseInt(currDate.substring(0,2));
		//alert("cday :" +cday);
		cmonth=parseInt(currDate.substring(3,5));
		//alert("cmonth :" +cmonth);
		cyear=parseInt(currDate.substring(6));
		//alert("cyear :" +cyear);
	}
	else if(currDateLength==8)	// 5/5/2013
	{
		cday=parseInt(currDate.substring(0,1));
		//alert("cday :" +cday);
		cmonth=parseInt(currDate.substring(2,3));
		//alert("cmonth :" +cmonth);
		cyear=parseInt(currDate.substring(4));
		//alert("cyear :" +cyear);
		
	}
	else					// 8/11/2013 or 12/8/2013
	{
		var n=currDate.indexOf("/");
		if(n==1)
		{
			cday=parseInt(currDate.substring(0,1));
			//alert("cday :" +cday);
			cmonth=parseInt(currDate.substring(2,4));
			//alert("cmonth :" +cmonth);
			cyear=parseInt(currDate.substring(5));
			//alert("cyear :" +cyear);
		}
		else
		{
			cday=parseInt(currDate.substring(0,2));
			//alert("cday :" +cday);
			cmonth=parseInt(currDate.substring(3,4));
			//alert("cmonth :" +cmonth);
			cyear=parseInt(currDate.substring(5));
			//alert("cyear :" +cyear);
		}
			
	}
	
	
	
	var taskName = addschedules.taskname.value;
	var deviceId = addschedules.device.value;
	var sdate = addschedules.ondate.value;
	var edate = addschedules.offdate.value;
	
	var onTimehr = addschedules.ontimehr.value;
	var onTimemin = addschedules.ontimemin.value;
	var onTimeprd = addschedules.ontimeprd.value;  
	
	var offTimehr = addschedules.offtimehr.value;
	var offTimemin = addschedules.offtimemin.value;
	var offTimeprd = addschedules.offtimeprd.value;   
	
	//var users = addschedules.userlist.value;
	
	
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
	

	/*-------------Validation for taskName----------*/
	if(taskName.charAt(0)==" ")
	{
		alert("First Character can not be space !!!");
		return false;
	}
	else if(taskName.length == 0 || taskName=="")
	{
		alert("Task Name can not be empty !!!");
		return false;
	}
	
	
		
	/*-------------Validation for device selection----------*/
	
	else if(deviceId.length == 0 || deviceId=="")
	{
		alert("Please Select Device !!!");
		return false;
	}
	
	/*----------------Validation for Current and Start/ON Date------------*/
	
	else if(sday<cday && smonth<=cmonth && syear<=cyear)
	{
		alert("Please don't select past date !!!");
		return false;
	}
	else if(smonth<cmonth && syear<=cyear)
	{
		alert("Please don't select past date !!!");
		return false;			
	}
	else if (cyear>syear)
	{
		alert("Please don't select past date !!!");
		return false;
	}
	

	/*----------------Validation for Start/ON and End/OFF Date------------*/
	else if(sdate.length == 0 || sdate=="")
	{
		alert("ON Date can not be empty !!!");
		return false;
	}
	
	else if(edate.length == 0 || edate=="")
	{
		alert("OFF Date can not be empty !!!");
		return false;
	}
	
	else if(eday<sday && emonth<=smonth && eyear<=syear)
	{
		alert("OFF Date's Day Should be larger !!!");
		return false;
		
	}
	else if(emonth<smonth && eyear<=syear)
	{
		alert("OFF date's month Should be larger !!!");
		return false;
	}

	else if (syear>eyear)
	{
		alert("OFF date's year Should be larger !!!");
		return false;
	}
	
	
	/*-------------Validation for on time hr selection----------*/
	
	else if(onTimehr.length == 0 || onTimehr=="")
	{
		alert("Please Select ON time Hour !!!");
		return false;
	}
	
	/*-------------Validation for on time min selection----------*/
	
	else if(onTimemin.length == 0 || onTimemin=="")
	{
		alert("Please Select ON time Min !!!");
		return false;
	}

	/*-------------Validation for on time prd selection----------*/
	
	else if(onTimeprd.length == 0 || onTimeprd=="")
	{
		alert("Please Select ON time Period !!!");
		return false;
	}
	
	
	/*-------------Validation for off time hr selection----------*/
	
	else if(offTimehr.length == 0 || offTimehr=="")
	{
		alert("Please Select OFF time Hour !!!");
		return false;
	}
	
	/*-------------Validation for off time min selection----------*/
	
	else if(offTimemin.length == 0 || offTimemin=="")
	{
		alert("Please Select OFF time Min !!!");
		return false;
	}
	
	/*-------------Validation for off time prd selection----------*/
	
	else if(offTimeprd.length == 0 || offTimeprd=="")
	{
		alert("Please Select OFF time Period !!!");
		return false;
	}
	
	
	/*-------------Validation for User selection----------*/
	
	/*else if(users.length == 0 || users=="")
	{
		alert("Please Select user !!!");
		return false;
	}*/

	
	return true;
}