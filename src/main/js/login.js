import aa from "/js/spa.js";
import newUsers from "/js/newUser.js";
import def from '/js/registration_js.js';


function abc() {
	document.getElementById("login-s1").addEventListener("click", e => {
		e.preventDefault();
		test();
	});

	function test() {
		var email = document.getElementById("login-email").value;
		var pwd = document.getElementById("login-pwd").value;

		const data = {
			"email": email,
			"password": pwd
		};
		/*
			fetch('http://localhost:8080/home', {
				method: 'POST', // or 'PUT'
				headers: {
					'Content-Type': 'application/json',
				},
				body: JSON.stringify(data),
			})
				.then(response => response.text())
				.then(data => {
					raps = data;
					if (data == "false") {
						//window.location.assign("http://localhost:8080/login/"+data);	
						document.getElementById("login-app").innerHTML = "Error Signing in. Incorrect username / password";
					}
					else {
						fetch('http://localhost:8080/home')
							.then(response => response.json())
							.then(data => innerfetch = data);
						//window.location.assign("https:localhost:8080/home");
						document.getElementById("container").innerHTML = raps;
						console.log(raps);
					}
				})
		}*/

		var newUser = document.getElementById("login-newUser");
		newUser.addEventListener("click", e => {
			//e.preventDefault();
			var inn = document.getElementById("login");
			inn.innerHTML = newUsers();
			var aaa = document.getElementsByTagName("link")
			document.getElementsByTagName("head")[0].removeChild(aaa[0]);
			def();

		});

	}
	abc();
	export default abc;
