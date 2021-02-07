import {homePillReminder} from '../Home/homePillReminder.js';
import {getUserInfoHomePage} from '../API/homeAPI.js';


const homePage = {
  after_render: async ()=>{
  
  document.getElementById("mainbar").style.flexDirection = "column";
  await homePage.getUserInfoONPage();
  document.getElementById("main_mid_row").innerHTML = await homePillReminder.render();
  if(homePillReminder.after_render){
    homePillReminder.after_render();
  }
  //document.getElementById("main_mid_row").innerHTML = await homePillReminder.render(dependentpills);
  //document.getElementById("main_mid_row").innerHTML += await homePillReminder.render(userpillsa);
  //document.getElementById("main_mid_row").innerHTML += await homePillReminder.render(userpillsa);
  //homePage.getHomePageUserInfo();
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
        <div class="main_mid_row" id="main_mid_row"></div>
      </div>
     `;
  },

  getUserInfoONPage: async ()=>{
    await getUserInfoHomePage();
  },

  /*getPillInformation: async ()=>{
    return await homePillReminder.render();
  }*/
}

export default homePage;