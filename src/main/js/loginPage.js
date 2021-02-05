import { postLoginData } from './loginAPI.js';
import {getJwtToken} from './loginAPI.js';
import registrationPage from './registrationPage';
import forgotPage from './forgotPage.js';
import userValidation from './userValidation.js';

const loginPage = {
  after_render: function () {
    //login submit button event Listener
    document.getElementById("login-s1").addEventListener("click", e => {
      e.preventDefault();
      if (userValidation.isValidEmailForLogin() && userValidation.isValidPasswordForLogin()) {
        loginPage.submitTokenRequest();
      }
      else{
        alert("Invalid Creds");
      }

    });
    
    // login validation
    //document.getElementById("login-email").addEventListener("focusout", userValidation.isValidEmail);
    //document.getElementById("login-pwd").addEventListener("focusout", userValidation.isValidPassword);
    
    //new user registration link event listener 
    document.getElementById("login-newUser").addEventListener("click", e => {
      //e.preventDefault();
      let divele = document.getElementById("login");
      divele.innerHTML = registrationPage.render();
      if (registrationPage.after_render()) {
        registrationPage.after_render();
      }
    });

    //forgot link event listener
    document.getElementById("login-forgot").addEventListener("click", e => {
    	//e.preventDefault();
      let forGot = document.getElementById("login");
      forGot.innerHTML = forgotPage.render();
      if (forgotPage.after_render()) {
        forgotPage.after_render();
      }
    });
  },
  render: () => {

    return `<form id="login-f1" >
        <table id="login-t1">
        <div id="login-app"><h1>Login</h1></div>
        <tr><th>Email Id</th><td><input type="text" id="login-email"></td><td id = "log-mail"></td></tr>
        <tr><th>Password&nbsp;&nbsp;</th><td><input type="password" id = "login-pwd"></td><td id = "log-pwd"></td></tr> </table>
        <p class="login-submit-btn"><a href="/home"><input type="button" id="login-s1" value="LOGIN" /></a></p>
        <p class="login-left"><a href="#/forgotpwd" id="login-forgot">Forgot Password?</a></p>
          <p class="login-right"><a href="#/signup" id="login-newUser">New User?</a></p>
     
      </form> `;
  },

  submitLoginData: async function () {
    let email = document.getElementById("login-email").value;
    let pwd = document.getElementById("login-pwd").value;

    const data = {
      "userEmail": email,
      "userPassword": pwd
    }

    await postLoginData(data);

  },
  
  submitTokenRequest: async function () {
	    let email = document.getElementById("login-email").value;
	    let pwd = document.getElementById("login-pwd").value;

	    const data = {
	      "userEmail": email,
	      "userPassword": pwd
	    }

	    await getJwtToken(data);

    }




}

export default loginPage;