function misubmit()
{
	
	var username=regform.username.value;
	var password=regform.password.value;
	var conpassword=regform.conpassword.value;
	var email=regform.email.value;
	var firstname=regform.firstname.value;
	var lastname=regform.lastname.value;
	var mobileno=regform.mobileno.value;
	var courseindex=regform.course.selectedIndex;

	var flag=false;
	var str="";
	var efilter=/^([a-zA-Z0-9\_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})$/


	if(username.trim()=="")
	{ 
		flag=true;
		str+="username should not be blank\n";
	}
	if(password.trim()==""||password!=conpassword)
	{
		flag=true;
		str+="enter correct password\n";
	}if(firstname.trim=="")
	{ 
		flag=true;
		str+="firstname should not contain extra symbols\n";
	}
	if(lastname.trim=="")
	{ 
		flag=true;
		str+="last should not contain extra symbols\n";
	}
	if(regform.gender[0].checked==false&&regform.gender[1].checked==false)
	{
		flag=true;
		str+="please select gender\n";
	
	}
	if(!efilter.test(email))
	{
		flag=true;
		str+="Email not valid\n";
	}
	if(courseindex==0)
	{
		flag=true;
		str+="Course not selected\n";
	}
	if(isNaN(mobileno)||mobileno.length>12)
	{
		flag=true;
		str+="mobile no not valid\n";
	}
	if(flag)
	{
		alert(str);
		return false;
	}
	alert("hi");
	return true;//   
}
