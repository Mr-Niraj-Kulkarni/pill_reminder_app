import { postLoginData } from './loginAPI.js';
import {getJwtToken} from './loginAPI.js';
import registrationPage from './registrationPage';
import forgotPage from './forgotPage.js';
<<<<<<< HEAD
/*function login_page(){
  return `
      <form id="login-f1" >
        <table id="login-t1">
          <tr><td><div id="login-app">Welcome! Please Sign in to continue</div></td></tr>
        <tr><td><input type="text" id="login-email" placeholder="Email Id"></td></tr>
        <tr><td><input type="password" id = "login-pwd" placeholder="Password"></td></tr>
        <tr><td><a href="/home"><button type="submit" id="login-s1">LOGIN</button></a></td></tr>
        <tr><td><p class="login-left"><a href="#" id="login-forgot">Forgot Password?</a></p>
          <p class="login-right"><a href="#newuser" id="login-newUser">New User?</a></p></td></tr>
      </table>
      </form>
      <script type="module" src="/js/login.js"></script>
      <h1>dSADSA</h1>
  `
}
export default login_page;
*/
=======

>>>>>>> cff86cabed5a6066cf6f9767f57845481a6f3c6c
const loginPage = {
  after_render: function () {
    //login submit button event Listener
    document.getElementById("login-s1").addEventListener("click", e => {
      e.preventDefault();
      //loginPage.submitLoginData();
      loginPage.submitTokenRequest();
    });

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
    //forgot link event listener
    document.getElementById("login-forgot").addEventListener("click", e => {
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
        <tr><td>Email Id</td><td><input type="text" id="login-email"></td></tr>
        <tr><td>Password&nbsp;&nbsp;</td><td><input type="password" id = "login-pwd"></td></tr> </table>
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
    console.log(JSON.stringify(JSON.stringify(data), JSON.stringify({ "flag": 1 })));
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