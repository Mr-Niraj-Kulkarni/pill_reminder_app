import loginPage from './loginPage.js';
import registrationPage from './registrationPage';
import forgotPage from './forgotPage.js';
import homePage from './homePage.js';
import '../resources/static/css/login.css';
import '../resources/static/css/registration.css';


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
		  '/home' : homePage
		  

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
			alert(parseUrl);
		  const screen = routes[parseUrl] ? routes[parseUrl]: Error404Screen;
		  

			document.getElementById("login").innerHTML= await screen.render();
			
		  if(screen.after_render){
		    screen.after_render();
		  }
		  
}

window.addEventListener("load",router);
window.addEventListener("hashchange",router);

