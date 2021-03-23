function validate()  //function to validate the values entered by the user
{
	var err = 0;
	var name = document.getElementById("name").value; //stores name value into name variable
	var mob = document.getElementById("mob").value; //stores mobile no. value into mob variable
	var amt = document.getElementById("amt").value; //stores amount value into amt variable
	var mode = document.querySelector('input[name="Payment"]:checked'); //stores selected radio button into mode variable

	var nameRegex = /^[a-zA-Z ]*$/; //Regular Expression to allow only Alphabets
	var mobRegex = /[1-9]{1}[0-9]{9}/; //Regular Expression to allow 10 digit number
	var amtRegex = /^[0-9]*$/; //Regular Expession to allow only Digits

	if(name==="" || !(nameRegex.test(name))) //Checks validity of name 
	{
		if(name==="")
			document.getElementById("nameError").innerHTML = "Name is Empty";
		else 
			document.getElementById("nameError").innerHTML = "Invalid Name: Only alphabets are allowed";
		err = 1;
	} else {
		document.getElementById("nameError").innerHTML = "";
	}

	if(mob==="" || !(mobRegex.test(mob))) //Checks validity of mobile no. 
	{
		if(mob==="")
			document.getElementById("mobError").innerHTML = "Mobile no. is Empty";
		else
			document.getElementById("mobError").innerHTML = "Invalid Mobile no: Should be 10 digits and Should not start with 0";
		err = 1;
	} else {
		document.getElementById("mobError").innerHTML = "";
	} 

	if(amt==="" || !(amtRegex.test(amt))) //Checks validity of amount
	{
		if(amt==="")
			document.getElementById("billError").innerHTML = "Amount is Empty";
		else
			document.getElementById("billError").innerHTML = "Invalid Bill Amount: Should contain digits only";
		err = 1;
	} else {
		document.getElementById("billError").innerHTML = "";
	} 

	if(mode==null) //Checks whether radio button is selected 
	{
		document.getElementById("modeError").innerHTML="No Payment Method Selected";
	} else {
		document.getElementById("modeError").innerHTML="";
	}


	if(err===0)  //if err = 0 then values are correct 
	{
		var method=getRadioValue();
		//gives a alert box if everything validates correctly
		alert(`Thank you ${name} your bill payment of amount ${amt} is accepted through ${method}`);
		return true;
	}
	else //else some value is not correct
	{
		return false;
	}
}

function getRadioValue() //gets the value of the selected radio button
{
	var modes = document.getElementsByName("Payment");
	var i;
	var method;
	for(i=0;i<modes.length;i++)
	{
		if(modes[i].checked)
			return modes[i].value;
	}
}

function clearError()  //clears all error and set the focus to the first input field.
{
	document.getElementById("nameError").innerHTML = "";
	document.getElementById("mobError").innerHTML = "";
	document.getElementById("billError").innerHTML = "";
	document.getElementById("modeError").innerHTML = "";
	document.getElementById('name').focus();
}