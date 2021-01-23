function login_page(){
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
	`
}
export default login_page;
/*const loginPage={
	render: async ()=>{
	
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
	
	
	}



}

export default loginPage ;*/