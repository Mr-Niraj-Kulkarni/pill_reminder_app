import { postLoginData } from './loginAPI.js';
import {getJwtToken} from './loginAPI.js';
import registrationPage from './registrationPage';
import forgotPage from './forgotPage.js';
import {getProfileData} from './profileAPI.js';
import {viewDependentData} from './profileAPI.js';
import {updateUserProfileData} from './profileAPI.js';
import dependentProfilePage from './dependentProfilePage.js';

const userProfilePage = {
  after_render: function () {
    document.getElementById("mainbar").style.flexDirection = "row";
    function readURLs(input){
      if (input.files && input.files[0]) {
        var reader = new FileReader();
    
        reader.onload = function (e) {
            const photo = document.getElementById("profile-photo");
                photo.setAttribute('src', e.target.result);
        };
    
        reader.readAsDataURL(input.files[0]);
    }
    }
    var arrayBuffer = [];
    document.getElementById("link-hidden").addEventListener("click",e=>{
      document.getElementById("profile-photo-upload").addEventListener("change",()=>{
        readURLs(document.getElementById("profile-photo-upload"));
        var reader = new FileReader();
        reader.onload = function() {

        arrayBuffer = new Uint8Array(reader.result);
        console.log(arrayBuffer);
        
      };
     reader.readAsArrayBuffer(document.getElementById("profile-photo-upload").files[0]); 
        var blob = new Blob(arrayBuffer,{type:"image/jpeg"});
        console.log(blob);
        var url = URL.createObjectURL(blob);
        console.log(url);
        document.getElementById("testtest").src = url; 
      })
      document.getElementById("profile-photo-upload").click();
      
      //e.preventDefault();
    });

    document.getElementById("profile-edit").addEventListener("click",()=>{
      document.getElementById("profile-save").style.visibility = "visible";
      document.getElementById("profile-cancel").style.visibility = "visible";
      document.getElementById("profile-edit").style.visibility = "hidden";
      const profileform = document.getElementById("profile-form");
      const profileforminputs = profileform.getElementsByTagName("input");
      for(var i = 0; i<profileforminputs.length;i++){
        profileforminputs[i].removeAttribute("readonly");
      }
    })

    document.getElementById("profile-cancel").addEventListener("click",()=>{
      document.getElementById("profile-save").style.visibility = "hidden";
      document.getElementById("profile-cancel").style.visibility = "hidden";
      document.getElementById("profile-edit").style.visibility = "visible";
      const profileform = document.getElementById("profile-form");
      const profileforminputs = profileform.getElementsByTagName("input");
      for(var i = 0; i<profileforminputs.length-3;i++){
        profileforminputs[i].value="";
        profileforminputs[i].setAttribute("readonly","readonly");
      }
    })

    userProfilePage.getProfileData();

    document.getElementById("view-dependents").addEventListener("click",()=>{
      document.getElementById("dependent-form").innerHTML = dependentProfilePage.render();
      if(dependentProfilePage.after_render){
        dependentProfilePage.after_render();
        userProfilePage.viewDependentData();
      }
      
    });
    document.getElementById("add-dependents").addEventListener("click",()=>{
      document.getElementById("dependent-form").innerHTML = dependentProfilePage.render();
      if(dependentProfilePage.after_render){
        dependentProfilePage.after_render();
      }
    });
    document.getElementById("profile-save").addEventListener("click",()=>{
      userProfilePage.submitProfileUpdateData();

    })

  },
  render: () => {

    return `
    <div class="sidebar_one" id="sidebar_one">
    <a href="#/home" id="home-link">Home</a><br>
    <a href="#/profile" id="profile-link">Profile</a>
    </div>
    <div class="mainbar" id="mainbar">
    <div class="profile-photos" id="profile-photos">
        <form id="profile-form">
          <span class="image-cum-editbtn"><img src="#" id="profile-photo">
          <a id="link-hidden"><span>&#x270E;</span><input type="file" id="profile-photo-upload" hidden/></a>
          </span><br>
          <h2 class="image-para">PROFILE</h2>
            <table id="profile-form">
              <tr><th>Name</th><td><input type="text" id="profile-name" readonly/></td><td id="pr-1">&#x2705;</td></tr>
              <tr><th>Email id</th><td><input type="email" id="profile-email" readonly/></td><td id="pr-2"></td></tr>
              <tr><th>Contact Number</th><td><input type="number" id="profile-contact" readonly/></td><td id="pr-3"></td></tr>
              <tr><th>Blood Group</th><td><input type="text" id="profile-bloodgroup" readonly/></td><td id="pr-4"></td></tr>
              <tr><th>Date of Birth</th><td><input type="date" id="profile-dob" readonly/></td><td id="pr-5"></td></tr>
              <tr><th>Weight</th><td><input type="text" id="profile-weight" readonly/></td><td id="pr-6"></td></tr>
              <tr><th>Height</th><td><input type="text" id="profile-height" readonly/></td><td id="pr-7"></td></tr>
            </table><br><img id="testtest">
            <span class="image-para">
          <input type="button" class="save-cancel editvisiblity" id="profile-save" value="Save" />
          <input type="button" class="save-cancel" id="profile-edit" value="Edit" />
          <input type="button" class="save-cancel editvisiblity" id="profile-cancel" value="Cancel" /></span>
        </form>
    </div>
      <div class="dependent-profile" id="dependent-profile">
        <div class="add-view-dependent image-para" id="add-view-dependent"><br>
          <form id="add-view-form">
            <select id="relationship"> 
              <option value="" disabled selected>Relation</option>
            </select>
            <input type="text" id="relationship-name" placeholder="Dependent Name" />
            <input type="button" id="view-dependents" value="View Dependents" /><br><br>
            <input type="button" id="add-dependents" value="Add Dependents" />

          </form>
        </div>
        <div class="dependent-form" id="dependent-form">
          
        </div>
      </div>
    </div>
    `;
  },
  
  submitProfileUpdateData: async function () {
      //let userProfilePic = document.getElementById("login-email").value;
      const data = {
        "userName" : document.getElementById("profile-name").value,
        "userEmail" : document.getElementById("profile-email").value,
        "userContact" : document.getElementById("profile-contact").value,
        "userBloodGroup" : document.getElementById("profile-bloodgroup").value,
        "userDateOfBirth" : document.getElementById("profile-dob").value,
        "userWeight" : document.getElementById("profile-weight").value,
        "userHeight": document.getElementById("profile-height").value
      }
      console.log(data);
      await updateUserProfileData(data);
      
  },
  getProfileData: async function(){
    await getProfileData();
  },
  viewDependentData: async function(){
    const dependentRelation = document.getElementById("relationship").value;
    const dependentName = document.getElementById("relationship-name").value;
    const data = {
      "dependentRelation" : dependentRelation,
      "dependentName" : dependentName
    }
    await viewDependentData(data);
  }
}

export default userProfilePage;