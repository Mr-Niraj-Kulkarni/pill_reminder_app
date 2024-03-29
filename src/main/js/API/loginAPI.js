
export const postLoginData = async (data) => {
  try {

    

    //console.log(localStorage.getItem("jwtToken"));
    const response = await fetch('http://localhost:8080/login', {

      method: 'POST', // or 'PUT'
      headers: {
        'Content-Type': 'application/json',
        'Authorization' : localStorage.getItem("jwtToken")
      },
      body: JSON.stringify(data)
    });
    //console.log("on line 11 ")
    const isLoginDataValid = await response.text();
    console.log("login data", isLoginDataValid);

    if (isLoginDataValid == 0) {

      alert("Error Signing in. Incorrect username / password");
    }
    else {
      //let raps = isLoginDataValid;
      //document.getElementById("login").innerHTML = isLoginDataValid;
      //window.location.href="#/home";
      //console.log(raps);
      getSecretAns(data);
    }


  } catch (e) {
    console.log("ERROR: ", e);
  }
}

export const postRegistrationData = async (data) => {
  try {
    const response = await fetch('http://localhost:8080/register', {
      method: 'POST', // or 'PUT'
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(data)
    });

    const isRegistrationDataValid = await response.text();
    console.log("login data", isRegistrationDataValid);

    if(isRegistrationDataValid){
      window.location.href = "#/";
    }
    
    //document.getElementById("login").innerHTML = isRegistrationDataValid;




  } catch (e) {
    console.log("ERROR: ", e);
  }
}


export const postForgotData = async (forgotdata) => {
  try {
    const response = await fetch('http://localhost:8080/passwordUpdate', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(forgotdata)

    });
    const status = await response.text();
    return status;
    //document.getElementById("responce-msg").innerHTML = msg;

  } catch (e) {
    console.log("ERROR: ", e);
  }
}

export const getJwtToken = async (data) => {
	  try {
	    const response = await fetch('http://localhost:8080/login', {
	      method: 'POST', // or 'PUT'
	      headers: {
	        'Content-Type': 'application/json',
	      },
        body: JSON.stringify(data)
      });
      
      const isRegistrationDataValid = await response.json();
      console.log("on line 92",isRegistrationDataValid);
      if(isRegistrationDataValid.token == null){
        alert("Invalid Creds");

      }
      else{
      console.log(isRegistrationDataValid);
      localStorage.setItem("jwtToken",`Bearer `+isRegistrationDataValid.token);
      console.log(localStorage.getItem("jwtToken"));
      window.location.href="/#/home";
      }
        
      
	  } catch (e) {
	    console.log("ERROR: ", e);
	  }
	}

  export const authenticateUser = async () => {
    console.log(localStorage.getItem("jwtToken"));
  try {
    const response = await fetch('http://localhost:8080/authenticateUser',{
      method: 'GET',
      headers: {
        'Authorization' : localStorage.getItem("jwtToken")
      },
    
    });
    const status = await response.json();
    console.log(status);
    return status;
    //document.getElementById("responce-msg").innerHTML = msg;

  } catch (e) {
    console.log("ERROR: ", e);
  }
}
