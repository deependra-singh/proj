function validateAddNotification()
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
	  
	var summarries = addnotifications.summary.value;
	var contents = addnotifications.content.value;
	var sdate = addnotifications.dates.value;
	var users = addnotifications.userlist.value;
	
	
	var sday=parseInt(sdate.substring(0,2));
	var smonth=parseInt(sdate.substring(3,5));   //26-09-2013
	var syear=parseInt(sdate.substring(6));
	
	if(smonth==0)
		smonth=parseInt(sdate.substring(4,5));
	
	/*----------------Validation for Summarry----------------------*/
	if(summarries.charAt(0)==" " )
	{
		alert("First character can not be space in Summary !!!");
		return false;
	}
	else if(summarries.length == 0 || summarries=="")
	{
		alert("Summary can not be empty !!!");
		return false;
	}
	
	
	
	/*----------------Validation for Contents----------------------*/
	else if(contents.charAt(0)==" " )
	{
		alert("First character can not be space in contents field !!!");
		return false;
	}
	else if(contents.length == 0 || contents=="")
	{
		alert("Content can not be empty !!!");
		return false;
	}
	
	
	/*----------------Validation for Current and Date------------*/
	
	else if(sdate.length == 0 || sdate=="")
	{
		alert("Date can not be empty !!!");
		return false;
	}
	
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
	
	
	/*-------------Validation for user selection----------*/
	
	
	if(users.length == 0 || users=="")
	{
		alert("Please Select User !!!");
		return false;
	}

	
	return true;
	

}