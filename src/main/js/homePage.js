import {userpillsa} from './homePillReminder.js';
import {dependentpills} from './homePillReminder.js';
import {homePillReminder} from './homePillReminder.js';
import {getUserInfoHomePage} from './homeAPI.js';
const homePage = {
  after_render: async function(){
  document.getElementById("mainbar").style.flexDirection = "column";
  document.getElementById("main_mid_row").innerHTML = await homePillReminder.render(dependentpills);
  document.getElementById("main_mid_row").innerHTML += await homePillReminder.render(userpillsa);
  document.getElementById("main_mid_row").innerHTML += await homePillReminder.render(userpillsa);
  homePage.getHomePageUserInfo();
  },
  render: () => {

    return `
      <div class="mainbar" id="mainbar">
        <div class="main_top_row" id="main_top_row">
          <div class="user_profile" id="user_profile">
          Email id: <div id="homepage-useremail"></div><br>
          Contact Number: <div id="homepage-usercontact"></div><br>
          BMI: <div id="homepage-userbmi"></div>
          </div>
          <div class="welcome_name" id="welcome_name">
            <h2 id="homepage-username"></h2>
          </div>
        </div>
        <div class="main_mid_row" id="main_mid_row">med history</div>
        <div class="main_bottom_row" id="main_bottom_row">
          <input type="button" id="add-medical-history" value="Add Medical History" />
        </div>
      </div>
     `;
  },

  getHomePageUserInfo: async function () {
    //await getUserInfoHomePage();

  }
}

export default homePage;