import login_page from '/js/login_page.js';

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

document.getElementById("login").innerHTML = login_page();

var newUsers = document.getElementById("upper-container");
newUsers.addEventListener("click",()=>{alert("ok")});

