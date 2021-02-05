import {getProfilePicture} from './profileAPI.js';
import userProfilePage from './userProfilePage.js';
const header = {
  after_render: function () {
  var openstatus = true;
  
  document.getElementById("menu-icon").addEventListener("click",()=>{
    openstatus ? close() : open();
  });
  const close =()=>{
    document.getElementById("sidebar_one").classList.add("collapse");
    openstatus = false;
  }
  const open = ()=>{
    document.getElementById("sidebar_one").classList.remove("collapse");
    openstatus = true;
  }
  document.getElementById("logout-menu").addEventListener("click",()=>{
    localStorage.removeItem("jwtToken");
    history.pushState("http://localhost:8080","sample","#/");
    window.location.reload();
    
  })

  header.getProfileImageOnHomePage("photo-logout");
  },
  render: () => {
    return `
    <span class="menu-icon" id="menu-icon"><div id="menu-click-icon">&#9776;</div></span>
    <span class="title"><b><u>Pill Reminder App</u></b></span>
    <span class="logout-icon" id="logout-icon">
    <div id="logout-hover-menu"><img src="" id="photo-logout"></div>
    <div id="logout-menu">
    Logout
    </div></span>
    `;
  },
//<div id="logout-menu">LOGOUT</div><img src="" id="photo-logout"></span>
  getProfileImageOnHomePage: async function(imgId){
    const serverResponse = await getProfilePicture();
    console.log(serverResponse);
    console.log(serverResponse.byteLength);
    if(serverResponse.byteLength<11000){
      var image = document.getElementById(imgId);
      image.src = "/images/defaultAvtar.png";
    }
    else{
      var bytes = new Uint8Array(serverResponse);
      var image = document.getElementById(imgId);
      image.src = 'data:image/jpg;base64,'+userProfilePage.encode_function(bytes);
      //console.log(bytes);
    }
    
    }
  
}
//<span class="logout-icon" id="logout-icon">&#10150;</span>
export default header;