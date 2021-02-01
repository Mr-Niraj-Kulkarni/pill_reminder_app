import loginPage from './loginPage.js';
import registrationPage from './registrationPage';
import forgotPage from './forgotPage.js';
import homePage from './homePage.js';
import userProfilePage from './userProfilePage';
import header from './header.js';
import sideMenu from './sideMenu.js';
import '../resources/static/css/login.css';
import '../resources/static/css/registration.css';
import '../resources/static/css/home.css';
import '../resources/static/css/profile.css';
/*import '../resources/static/css/w3.css';
import '../resources/static/css/googleapi.css';*/


/*const rout = async () => {
	document.getElementById("login").innerHTML = loginPage.render();
	console.log("inside the function");
	if (loginPage.after_render()) {
		loginPage.after_render();
	}
}
rout();*/

const routes = {
		  '/' : loginPage,
		  '/signup': registrationPage,
		  '/forgotpwd' : forgotPage,
			'/home' : homePage,
			'/profile' : userProfilePage
		}
const parseRequestUrl = () =>{
		  const url = document.location.hash.toLowerCase();
		  const request = url.split('/');
		  return {
		    resource: request[1],
		    id: request[2],
		    verb: request[3]
		  }
		  
}
		//rootEle.innerHTML=LoginScreen.render();
const router = async () => {
		  const request = parseRequestUrl();
		  const parseUrl = (request.resource ? `/${request.resource}` : '/') + 
		  (request.id ? '/:id' : '')+
		  (request.verb ? `/${request.verb}` : '');
			//alert(parseUrl);
			const screen = routes[parseUrl] ? routes[parseUrl]: Error404Screen;
			
			if(parseUrl == "/" || parseUrl == "/signup" || parseUrl == "/forgotpwd"){
				//const logindiv = document.getElementById("login");
				console.log("ithe ka jatoy yacha pahile");
				if(document.getElementById("login") == null){
					console.log("ithe ka jatoy");
					document.getElementById("container").innerHTML = "";
					const createlogindiv = document.createElement("div");
					createlogindiv.className="login";
					createlogindiv.id = "login";
					document.getElementById("container").appendChild(createlogindiv);
				}
				document.getElementById("login").innerHTML= await screen.render();
			}
			else{
				//console.log("homeurl")
				document.getElementById("container").innerHTML = await sideMenu.render();
				document.getElementById("container").innerHTML += await screen.render();
				document.getElementById("upper-container").innerHTML = await header.render();
				header.after_render();
			}
			
			
		  if(screen.after_render){
		    screen.after_render();
		  }
		  
}

window.addEventListener("load",router);
window.addEventListener("hashchange",router);

