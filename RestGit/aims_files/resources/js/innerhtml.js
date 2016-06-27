function checkDeviceType(id) 
{
	
		var xmlhttp;
		//get the ID field for easy access... 
        var index =  document.getElementById("ports");
        if (window.XMLHttpRequest) 
        {
        	// code for IE7+, Firefox, Chrome, Opera, Safari
        	xmlhttp = new XMLHttpRequest();
        } 
        else 
        {
        	// code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function() 
        {
        	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) 
        	{
                // here you get back a response... xmlhttp.responseText
                // set the hidden field with new data.
        		document.getElementById("ports").innerHTML= xmlhttp.responseText;
        	}
        }
            // here you make a request to your script to check your database...
            xmlhttp.open("POST", "dynamicports.jsp?id="+id, true);
            xmlhttp.send();
}

function checkRole(id) 
{
	
		var xmlhttp;
		//get the ID field for easy access... 
        var index =  document.getElementById("abc");
        if (window.XMLHttpRequest) 
        {
        	// code for IE7+, Firefox, Chrome, Opera, Safari
        	xmlhttp = new XMLHttpRequest();
        } 
        else 
        {
        	// code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function() 
        {
        	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) 
        	{
                // here you get back a response... xmlhttp.responseText
                // set the hidden field with new data.
        		document.getElementById("abc").innerHTML= xmlhttp.responseText;
        	}
        }
            // here you make a request to your script to check your database...
            xmlhttp.open("POST", "dynamicdevicelistforrole.jsp?id="+id, true);
            xmlhttp.send();
}

function first() 
{
	
		var xmlhttp;
		//get the ID field for easy access... 
        var index =  document.getElementById("getData");
        if (window.XMLHttpRequest) 
        {
        	// code for IE7+, Firefox, Chrome, Opera, Safari
        	xmlhttp = new XMLHttpRequest();
        } 
        else 
        {
        	// code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function() 
        {
        	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) 
        	{
                // here you get back a response... xmlhttp.responseText
                // set the hidden field with new data.
        		document.getElementById("getData").innerHTML= xmlhttp.responseText;
        	}
        }
            // here you make a request to your script to check your database...
            xmlhttp.open("POST", "getnotifications.jsp?", true);
            xmlhttp.send();
            
            //var myVar = setInterval(first(),2000);
            window.setInterval(first, 50000);
}


function second(id) 
{
	alert("To remove another notification please wait for 25 sec");
		var xmlhttp;
		//get the ID field for easy access... 
        var index =  document.getElementById("getData");
        if (window.XMLHttpRequest) 
        {
        	// code for IE7+, Firefox, Chrome, Opera, Safari
        	xmlhttp = new XMLHttpRequest();
        } 
        else 
        {
        	// code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function() 
        {
        	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) 
        	{
                // here you get back a response... xmlhttp.responseText
                // set the hidden field with new data.
        		document.getElementById("getData").innerHTML= xmlhttp.responseText;
        	}
        }
        // here you make a request to your script to check your database...
        xmlhttp.open("POST", "readnotifications.jsp?id="+id, true);
        xmlhttp.send();
           
}


function userList(offset, limit) //to display all users
{
		var xmlhttp;
		//get the ID field for easy access... 
        var index =  document.getElementById("reportdata");
        if (window.XMLHttpRequest) 
        {// code for IE7+, Firefox, Chrome, Opera, Safari
        	xmlhttp = new XMLHttpRequest();
        } 
        else 
        {// code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function() 
        {
        	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) 
        	{
                   // here you get back a response... xmlhttp.responseText
                        // set the hidden field with new data.
        		document.getElementById("reportdata").innerHTML= xmlhttp.responseText;
        	}
        }
              
        xmlhttp.open("POST", "dynamicuserlist.jsp?offsets="+offset+"&limits="+limit, true);
        xmlhttp.send();
}

function checkNextUserlist(offset, limit) //showing next user list 
{
	
		var xmlhttp;
		//get the ID field for easy access... 
        var index =  document.getElementById("reportdata");
        if (window.XMLHttpRequest) 
        {// code for IE7+, Firefox, Chrome, Opera, Safari
        	xmlhttp = new XMLHttpRequest();
        } 
        else 
        {// code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function() 
        {
        	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) 
        	{
                   // here you get back a response... xmlhttp.responseText
                        // set the hidden field with new data.
        		document.getElementById("reportdata").innerHTML= xmlhttp.responseText;
        	}
        }
              
        xmlhttp.open("POST", "dynamicuserlist.jsp?offsets="+offset+"&limits="+limit, true);
        xmlhttp.send();
}


function finalUserReport(offset, limit) //to display all users
{
		var xmlhttp;
		//get the ID field for easy access... 
        var index =  document.getElementById("finalreport");
        if (window.XMLHttpRequest) 
        {// code for IE7+, Firefox, Chrome, Opera, Safari
        	xmlhttp = new XMLHttpRequest();
        } 
        else 
        {// code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function() 
        {
        	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) 
        	{
                   // here you get back a response... xmlhttp.responseText
                        // set the hidden field with new data.
        		document.getElementById("finalreport").innerHTML= xmlhttp.responseText;
        	}
        }
              
        xmlhttp.open("POST", "dynamicfinaluserreport.jsp?offsets="+offset+"&limits="+limit, true);
        xmlhttp.send();
}

function nextFinalUserReportlist(offset, limit) //showing next final user report list 
{
	
		var xmlhttp;
		//get the ID field for easy access... 
        var index =  document.getElementById("finalreport");
        if (window.XMLHttpRequest) 
        {// code for IE7+, Firefox, Chrome, Opera, Safari
        	xmlhttp = new XMLHttpRequest();
        } 
        else 
        {// code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function() 
        {
        	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) 
        	{
                   // here you get back a response... xmlhttp.responseText
                        // set the hidden field with new data.
        		document.getElementById("finalreport").innerHTML= xmlhttp.responseText;
        	}
        }
              
        xmlhttp.open("POST", "dynamicfinaluserreport.jsp?offsets="+offset+"&limits="+limit, true);
        xmlhttp.send();
}


/*--------------------Device Report-----------------*/

function devicesList(offset, limit) //to display all devices
{
		var xmlhttp;
		//get the ID field for easy access... 
        var index =  document.getElementById("reportdata");
        if (window.XMLHttpRequest) 
        {// code for IE7+, Firefox, Chrome, Opera, Safari
        	xmlhttp = new XMLHttpRequest();
        } 
        else 
        {// code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function() 
        {
        	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) 
        	{
                   // here you get back a response... xmlhttp.responseText
                        // set the hidden field with new data.
        		document.getElementById("reportdata").innerHTML= xmlhttp.responseText;
        	}
        }
            
        xmlhttp.open("POST", "dynamicdeviceslist.jsp?offsets="+offset+"&limits="+limit, true);
        xmlhttp.send();
}


function checkNextDevicelist(offset, limit) //showing next device list 
{
	
		var xmlhttp;
		//get the ID field for easy access... 
        var index =  document.getElementById("reportdata");
        if (window.XMLHttpRequest) 
        {// code for IE7+, Firefox, Chrome, Opera, Safari
        	xmlhttp = new XMLHttpRequest();
        } 
        else 
        {// code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function() 
        {
        	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) 
        	{
                   // here you get back a response... xmlhttp.responseText
                        // set the hidden field with new data.
        		document.getElementById("reportdata").innerHTML= xmlhttp.responseText;
        	}
        }
              
        xmlhttp.open("POST", "dynamicdeviceslist.jsp?offsets="+offset+"&limits="+limit, true);
        xmlhttp.send();
}


function finalDeviceReport(offset, limit) //to display all Devices schedule
{
		var xmlhttp;
		//get the ID field for easy access... 
        var index =  document.getElementById("finalreport");
        if (window.XMLHttpRequest) 
        {// code for IE7+, Firefox, Chrome, Opera, Safari
        	xmlhttp = new XMLHttpRequest();
        } 
        else 
        {// code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function() 
        {
        	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) 
        	{
                   // here you get back a response... xmlhttp.responseText
                        // set the hidden field with new data.
        		document.getElementById("finalreport").innerHTML= xmlhttp.responseText;
        	}
        }
              
        xmlhttp.open("POST", "dynamicfinaldevicereport.jsp?offsets="+offset+"&limits="+limit, true);
        xmlhttp.send();
}


function nextFinalDeviceReportlist(offset, limit) //showing next final user report list 
{
	
		var xmlhttp;
		//get the ID field for easy access... 
        var index =  document.getElementById("finalreport");
        if (window.XMLHttpRequest) 
        {// code for IE7+, Firefox, Chrome, Opera, Safari
        	xmlhttp = new XMLHttpRequest();
        } 
        else 
        {// code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function() 
        {
        	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) 
        	{
                   // here you get back a response... xmlhttp.responseText
                        // set the hidden field with new data.
        		document.getElementById("finalreport").innerHTML= xmlhttp.responseText;
        	}
        }
              
        xmlhttp.open("POST", "dynamicfinaldevicereport.jsp?offsets="+offset+"&limits="+limit, true);
        xmlhttp.send();
}