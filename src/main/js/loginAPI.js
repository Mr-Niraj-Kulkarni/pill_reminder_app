
export const postLoginData = async (data) => {
  try {
    //console.log(localStorage.getItem("jwtToken"));
    const response = await fetch('http://localhost:8080/login', {
      method: 'POST', // or 'PUT'
      headers: {
        'Content-Type': 'application/json',
        'Authorization' : localStorage.getItem("jwtToken")
      },
      body: JSON.stringify(JSON.stringify(data))
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


    //window.location.href = "http://localhost:8080/mainmenu";
    document.getElementById("login").innerHTML = isRegistrationDataValid;




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
    console.log("hiiii");
    const msg = await response.text();
    console.log(msg);
    document.getElementById("responce-msg").innerHTML = msg;

  } catch (e) {
    console.log("ERROR: ", e);
  }
<<<<<<< HEAD
}
=======
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
      window.location.href="#/home";
      getSecretAns(data);
      }
        
      
	  } catch (e) {
	    console.log("ERROR: ", e);
	  }
	}

const getSecretAns = async(data) =>{
  console.log(data);
	try{
		const response = await fetch('http://localhost:8080/getSecretAns',{
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Authorization' : localStorage.getItem("jwtToken")
      },
      body: JSON.stringify(data)
    })
      const returnFromServer = await response.text();
      //console.log("haha",returnFromServer)
      //document.getElementById("home-page").innerHTML = returnFromServer;
	} catch(e){
		 console.log("ERROR: ", e);
	}
}
>>>>>>> cff86cabed5a6066cf6f9767f57845481a6f3c6c
