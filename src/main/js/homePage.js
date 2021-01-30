
const homePage = {
  after_render: function(){
  document.getElementById("mainbar").style.flexDirection = "column";
  },
  render: () => {

    return `
    <div class="sidebar_one" id="sidebar_one">
    <a href="#/home" id="home-link">Home</a><br>
    <a href="#/profile" id="profile-link">Profile</a>
    </div>
      <div class="mainbar" id="mainbar">
        <div class="main_top_row" id="main_top_row">
          <div class="user_profile" id="user_profile">
          user profile
          </div>
          <div class="welcome_name" id="welcome_name">
            <br>welcome name
          </div>
        </div>
        <div class="main_mid_row" id="main_mid_row">med history</div>
        <div class="main_bottom_row" id="main_bottom_row">
          <input type="button" id="add-medical-history" value="Add Medical History" />
        </div>
      </div>
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