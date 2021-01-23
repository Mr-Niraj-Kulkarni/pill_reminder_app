import loginPage from './loginPage.js';
import '../resources/static/css/login.css';
import '../resources/static/css/registration.css';

/*
var script = document.createElement("script");
script.type = "module";
script.src = "/js/login.js";
var css = document.createElement("link");
css.rel = "stylesheet";
css.href = "/css/login.css";
document.getElementsByTagName("head")[0].appendChild(script);
document.getElementsByTagName("head")[0].appendChild(css);

var scripts = document.createElement("script");
scripts.type = "module";
scripts.src = "/js/registration_js.js";
var csss = document.createElement("link");
csss.rel = "stylesheet";
csss.href = "/css/registration.css";
document.getElementsByTagName("head")[0].appendChild(scripts);
document.getElementsByTagName("head")[0].appendChild(csss);
*/
const rout = async () => {
	document.getElementById("login").innerHTML = loginPage.render();
	console.log("inside the function");
	if (loginPage.after_render()) {
		loginPage.after_render();
	}
}
rout();


//trial part 
/*alert("ok");
//alert(document.getElementById("container").value);
/*var asa = document.getElementById("container");
asa.innerHTML = "hhh";
const rout=async ()=>{


	var login = window.document.getElementById("container");
	login.innerHTML = await loginPage.render();

	}
rout();
/*const abc = {
		render : async ()=>{
			//alert(document.getElementById("container").value);
			return `pore bc`;

		}
};
abc.render();
const aaa = async () =>{
	document.querySelector("#login").innerHTML = await abc.render();
}*/
