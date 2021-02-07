import loginPage from './Login/loginPage.js';
import registrationPage from './Login/registrationPage';
import forgotPage from './Login/forgotPage.js';
import homePage from './Home/homePage.js';
import userProfilePage from './Profile/userProfilePage';
import header from './Home/header.js';
import sideMenu from './Home/sideMenu.js';
import medicalHistoryPage from './MedicalHistory/medicalHistoryPage.js';
import Error404Screen from './Login/error404.js';
import {authenticateUser} from './API/loginAPI.js';

//Imports for CSS

import '../resources/static/css/login.css';
import '../resources/static/css/registration.css';
import '../resources/static/css/home.css';
import '../resources/static/css/profile.css';


const routes = {
	'/': loginPage,
	'/signup': registrationPage,
	'/forgotpwd': forgotPage,
	'/home': homePage,
	'/profile': userProfilePage,
	'/medicalhistory': medicalHistoryPage
}
const parseRequestUrl = () => {

	const url = document.location.hash.toLowerCase();
	const request = url.split('/');
	return {
		resource: request[1],
		id: request[2],
		verb: request[3]
	}

}
const router = async () => {
		  const request = parseRequestUrl();
		  const parseUrl = (request.resource ? `/${request.resource}` : '/') + 
		  (request.id ? '/:id' : '')+
		  (request.verb ? `/${request.verb}` : '');
			const screen = routes[parseUrl] ? routes[parseUrl]: Error404Screen;
			
			if(parseUrl == "/" || parseUrl == "/signup" || parseUrl == "/forgotpwd"){
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
				if(screen.after_render){
					screen.after_render();
				}
			}
			else if(screen == Error404Screen){
				document.querySelector(".full").innerHTML = Error404Screen.render();
			}
			else{
				const response =await authenticateUser() ;
				if(response==null){
				
				document.getElementById("container").innerHTML = await sideMenu.render();
				document.getElementById("container").innerHTML += await screen.render();
				if(document.getElementById("logout-menu") == null){
					document.getElementById("upper-container").innerHTML = await header.render();
					header.after_render();
					//menus.menus();	
				}
				if(screen.after_render){
					screen.after_render();
				}
			}
			else if(response.status!=200){
				document.getElementById("container").innerHTML = "<h1>Not Authorized. Login and try again</h1>"// call error page or redirect to login
				setTimeout(()=>{
					alert("You will now be redirected to login page");
					window.location.href= "#/";
				},500);
				
				
			}
				
			}

}

window.addEventListener("load", router());
window.addEventListener("hashchange", router);

