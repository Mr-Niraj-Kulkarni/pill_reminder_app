import { postLoginData } from './loginAPI.js';
import registrationPage from './registrationPage';

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
const loginPage = {
  after_render: function () {
    //login submit button event Listener
    document.getElementById("login-s1").addEventListener("click", e => {
      e.preventDefault();
      loginPage.submitLoginData();
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
  },
  render: () => {

    return `<form id="login-f1" >
        <table id="login-t1">
          <tr><td><div id="login-app">Welcome! Please Sign in to continue</div></td></tr>
        <tr><td><input type="text" id="login-email" placeholder="Email Id"></td></tr>
        <tr><td><input type="password" id = "login-pwd" placeholder="Password"></td></tr>
        <tr><td><a href="/home"><button type="submit" id="login-s1">LOGIN</button></a></td></tr>
        <tr><td><p class="login-left"><a href="#" id="login-forgot">Forgot Password?</a></p>
          <p class="login-right"><a href="#newuser" id="login-newUser">New User?</a></p></td></tr>
      </table>
      </form> `;
  },

  submitLoginData: async function () {
    let email = document.getElementById("login-email").value;
    let pwd = document.getElementById("login-pwd").value;

    const data = {
      "email": email,
      "password": pwd
    }

    await postLoginData(data);

  }




}

export default loginPage;