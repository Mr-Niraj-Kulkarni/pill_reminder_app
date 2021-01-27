
const homePage = {
  /*after_render: function () {
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
    //forgot link event listener
    document.getElementById("login-forgot").addEventListener("click", e => {
      let forGot = document.getElementById("login");
      forGot.innerHTML = forgotPage.render();
      if (forgotPage.after_render()) {
        forgotPage.after_render();
      }
    });
  },*/
  render: () => {

    return `
    <h1>You are in</h1>
    <div id="home-page">Unauthorized Entry</div>
     `;
  },

 /* submitLoginData: async function () {
    let email = document.getElementById("login-email").value;
    let pwd = document.getElementById("login-pwd").value;

    const data = {
      "userEmail": email,
      "userPassword": pwd
    }

    await postLoginData(data);

  }*/




}

export default homePage;