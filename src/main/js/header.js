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

  header.getProfileImageOnHomePage();
  },
  render: () => {
    return `
    <span class="menu-icon" id="menu-icon">&#9776;</span>
    <span class="title"><b><u>Pill Reminder App</u></b></span>
    <span class="logout-icon" id="logout-icon">
    <div id="logout-menu">LOGOUT</div><img src="" id="photo-logout"></span>
    `;
  },

  getProfileImageOnHomePage: async function(){
    if(localStorage.getItem("image")==null){
      const serverResponse = await getProfilePicture();
    var bytes = new Uint8Array(serverResponse);
    var image = document.getElementById('photo-logout');
    // image.src = 'data:image/jpg;base64,'+encode(bytes);
    let encodedImage = userProfilePage.encode_function(bytes);
    image.src = 'data:image/jpg;base64,'+encodedImage;
    localStorage.setItem("imageInBytes",bytes);
    }
    else{
      var reader = new FileReader();
      reader.onload = function (e) {
          const photo = document.getElementById("profile-photo");
              photo.setAttribute('src', e.target.result);
      };
      reader.readAsDataURL(localStorage.getItem("image"));
    }
    
  },
  
}
//<span class="logout-icon" id="logout-icon">&#10150;</span>
export default header;