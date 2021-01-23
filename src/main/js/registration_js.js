import login_page from '/js/login_page.js';
import abc from '/js/login.js';

function def(){
document.getElementById("reg-submit").addEventListener("click",e=>{
	e.preventDefault();
	dataDiv();
});

function namez(){
	var name = String(document.getElementById("reg-name").value);
	var letters = /^[A-Za-z]+$/;
	if(name.trim() == "" || !name.match(letters) ){
		 document.getElementById("reg-td1").innerHTML="&#x274C;";
		 return 0;
	}
	else{
	  document.getElementById("reg-td1").innerHTML="&#x2705;";
	  return 1;
 }
	}
document.getElementById("reg-name").addEventListener("keyup",namez);

function emailz(){
	var x=document.getElementById("reg-email").value;
	var atpos=x.indexOf("@");  
	var dotpos=x.lastIndexOf(".");  if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length){  
 //document.getElementById("td2").innerHTML="Please enter a valid email: email@email.com";
	alert("Please enter a valid email: email@emaill.com");
 return 0;  
	}
	else{
		 document.getElementById("reg-td2").innerHTML="&#x2705;";
		 return 1;
 }  
}
document.getElementById("reg-email").addEventListener("focusout",emailz);

function contactz(){
	var y = document.getElementById("reg-number").value;
	var num = y.replace( /\D+/g, '');
	if(y.length!=10 || num.length != 10){
		 document.getElementById("reg-td3").innerHTML="&#x274C;";
		 return 0;
	}
	else{
		 document.getElementById("reg-td3").innerHTML="&#x2705;";
		 return 1;
	}
}
document.getElementById("reg-number").addEventListener("keyup",contactz);

function dobz(){
			
	var x = document.getElementById("reg-dob").value;
	if(x.length == 0){
		 document.getElementById("reg-td5").innerHTML="&#x274C;";
		 return 0;
	}
	else{
		 document.getElementById("reg-td5").innerHTML="&#x2705;";
		 return 1;
	}
}
document.getElementById("reg-dob").addEventListener("focusout",dobz);

function pwdz(){
	var x = document.getElementById("reg-pwd1").value;
	//alert(x);
	var passw=  /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,20}$/;
	if(x.match(passw)){
		 document.getElementById("reg-td6").innerHTML="&#x2705;";
		 return 1;
	}
	else{
		 //document.getElementById("td6").innerHTML="1 Uppercase, 1 lowercase and 1 number along with 8-20 characters";
		 alert("1 Uppercase, 1 lowercase and 1 number along with 8-20 characters");
		 return 0;
	}
}
document.getElementById("reg-pwd1").addEventListener("focusout",pwdz);

function checkpwdz(){
	var x = document.getElementById("reg-pwd2").value;
	var y = document.getElementById("reg-pwd1").value;
	if(x === y){
		 document.getElementById("reg-td7").innerHTML="&#x2705;";
		 return 1;
	}
	else{
		 document.getElementById("reg-td7").innerHTML="&#x274C;";
		 return 0;
	}
}
document.getElementById("reg-pwd2").addEventListener("keyup",checkpwdz);
	

function dataDiv(){
	
  if(namez() == 1 && emailz() == 1 && pwdz() == 1 && checkpwdz() == 1){
    alert("Registered Successfully as per excel sheet rules!");
}
  else{
		alert("Registration unsuccessful, check form data and try again.");
  }
}


var backlogin = document.getElementById("reg-backlogin");
backlogin.addEventListener("click",e=>{
	e.preventDefault();
	var inn = document.getElementById("login");
	inn.innerHTML = login_page();
    abc();
   
	
});
}

export default def;