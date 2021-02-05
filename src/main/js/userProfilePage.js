
import {getProfileData} from './profileAPI.js';
import {viewDependentData} from './profileAPI.js';
import {updateUserProfileData} from './profileAPI.js';
import dependentProfilePage from './dependentProfilePage.js';
import {uploadProfilePicture} from './profileAPI.js';
import {getProfilePicture} from './profileAPI.js';
import header from './header.js';

import userValidation from './userValidation.js';

const userProfilePage = {
  after_render: function () {
    document.getElementById("mainbar").style.flexDirection = "row";
    // display profile image
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
    
  
    // <a>  LINK     <input type="file" hidden></input>button file.jpg      </a>   

    document.getElementById("link-hidden").addEventListener("click",()=>{
      document.getElementById("profile-photo-upload").click();
      console.log("oj");
      //ithe onchange wala code hota adhi :)
     //reader.readAsArrayBuffer(document.getElementById("profile-photo-upload").files[0]); 
      });
      let arrayBuffer = [];
    document.getElementById("profile-photo-upload").addEventListener("change",()=>{
        console.log("whoops");
        readURLs(document.getElementById("profile-photo-upload"));

        
      
      userProfilePage.submitProfilePicture(arrayBuffer);
      //e.preventDefault();
    });

    // edit button
      document.getElementById("profile-edit").addEventListener("click",()=>{
      document.getElementById("profile-save").style.visibility = "visible";
      document.getElementById("profile-cancel").style.visibility = "visible";
      document.getElementById("profile-edit").style.visibility = "hidden";
      const profileform = document.getElementById("profile-form");
      const profileforminputs = profileform.getElementsByTagName("input");
      for(var i = 0; i<profileforminputs.length;i++){
        profileforminputs[i].removeAttribute("readonly");
      }
    });
  

       // validation for profile form
      document.getElementById("profile-name").addEventListener("focusout", userValidation.isValidName);
      document.getElementById("profile-email").addEventListener("focusout", userValidation.isValidEmail);
      document.getElementById("profile-contact").addEventListener("focusout", userValidation.isValidContact);
      document.getElementById("profile-bloodgroup").addEventListener("focusout", userValidation.isValidBloodGroup);
      document.getElementById("profile-dob").addEventListener("focusout", userValidation.isValidDateofBirth);
      document.getElementById("profile-weight").addEventListener("focusout", userValidation.isValidWeight);
      document.getElementById("profile-height").addEventListener("focusout", userValidation.isValidHeight);
    

    // cancel button
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
      // call the profile data
      userProfilePage.getProfileData();

      document.getElementById("pr-1").innerHTML = "";
      document.getElementById("pr-2").innerHTML = "";
      document.getElementById("pr-3").innerHTML = "";
      document.getElementById("pr-4").innerHTML = "";
      document.getElementById("pr-5").innerHTML = "";
      document.getElementById("pr-6").innerHTML = "";
      document.getElementById("pr-7").innerHTML = "";

    })
    // save button
    document.getElementById("profile-save").addEventListener("click", ()=>{
      if (userValidation.isValidNameForProfile() && userValidation.isValidEmailForProfile() && 
          userValidation.isValidContactForProfile() && userValidation.isValidBloodGroupForProfile() && 
          userValidation.isValidDateofBirthForProfile() && userValidation.isValidWeightForProfile() && 
          userValidation.isValidHeightForProfile()) {
          console.log("ihi");
          const profileDataUpdate = async ()=>{
            await userProfilePage.submitProfileUpdateData();
            await userProfilePage.getProfileData();
          }
          profileDataUpdate();
          
          
        
        document.getElementById("pr-1").innerHTML = "";
        document.getElementById("pr-2").innerHTML = "";
        document.getElementById("pr-3").innerHTML = "";
        document.getElementById("pr-4").innerHTML = "";
        document.getElementById("pr-5").innerHTML = "";
        document.getElementById("pr-6").innerHTML = "";
        document.getElementById("pr-7").innerHTML = "";
        // readlony visible
        const profileform = document.getElementById("profile-form");
        const profileforminputs = profileform.getElementsByTagName("input");
        for(var i = 0; i<profileforminputs.length-3;i++){
          //profileforminputs[i].value="";
          profileforminputs[i].setAttribute("readonly","readonly");
        }
        // call the profile data 
        
        //buttton visiblity
        document.getElementById("profile-save").style.visibility = "hidden";
        document.getElementById("profile-cancel").style.visibility = "hidden";
        document.getElementById("profile-edit").style.visibility = "visible";
      }
      else{
        alert("Please fill the data correctly");
      }
      
    })

   

    // to relation and name for dependent data
    userProfilePage.getProfileData();

    
    document.getElementById("view-dependents").addEventListener("click",()=>{
      userProfilePage.viewDependentData();
    });

    document.getElementById("add-dependents").addEventListener("click",()=>{
      document.getElementById("dependent-form").innerHTML = dependentProfilePage.render();
      if(dependentProfilePage.after_render){
        let flag = "addData";
        dependentProfilePage.after_render(flag);
      }
    });

    /*document.getElementById("profile-save").addEventListener("click",()=>{
      userProfilePage.submitProfileUpdateData();

    })*/
    userProfilePage.getProfileImage();
  },
  render: () => {

    return `
    <div class="mainbar" id="mainbar">
    <div class="profile-photos" id="profile-photos">
        <form id="profile-form">
          <span class="image-cum-editbtn"><img src="" id="profile-photo">
          <span id="link-hidden">&#x270E;<input type="file" id="profile-photo-upload" hidden/></span>
          </span><br>
          <h2 class="image-para">PROFILE</h2>
            <table id="profile-form">
              <tr><th>Name</th><td><input type="text" id="profile-name" readonly/></td><td id="pr-1"></td></tr>
              <tr><th>Email id</th><td><input type="email" id="profile-email" readonly/></td><td id="pr-2"></td></tr>
              <tr><th>Contact Number</th><td><input type="number" id="profile-contact" readonly/></td><td id="pr-3"></td></tr>
              <tr><th>Blood Group</th><td><input type="text" id="profile-bloodgroup" readonly/></td><td id="pr-4"></td></tr>
              <tr><th>Date of Birth</th><td><input type="date" id="profile-dob" readonly/></td><td id="pr-5"></td></tr>
              <tr><th>Weight(kg)</th><td><input type="text" id="profile-weight" readonly/></td><td id="pr-6"></td></tr>
              <tr><th>Height(cm)</th><td><input type="text" id="profile-height" readonly/></td><td id="pr-7"></td></tr>
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
    const dependentProfileData = await viewDependentData(data)
    if(dependentProfileData == null){
      document.getElementById("dependent-form").innerHTML = "<h2>No dependent data found. Please check dependent relation and dependent name</h2>";
    }
    else{
      document.getElementById("dependent-form").innerHTML = dependentProfilePage.render();
      document.getElementById("dependent-relationship").value = dependentProfileData.dependentRelation;
      document.getElementById("dependent-name").value = dependentProfileData.dependentName;
      document.getElementById("dependent-email").value = dependentProfileData.dependentEmail;
      document.getElementById("dependent-contact").value = dependentProfileData.dependentContact;
      document.getElementById("dependent-bloodgroup").value = dependentProfileData.dependentBloodGroup;
      document.getElementById("dependent-weight").value = dependentProfileData.dependentWeight;
      document.getElementById("dependent-height").value = dependentProfileData.dependentHeight;
      document.getElementById("dependent-dob").value = dependentProfileData.dependentDateOfBirth;
      if(dependentProfilePage.after_render){
        let flag = "updateData";
        dependentProfilePage.after_render(flag);
    }
  }
},

  submitProfilePicture: async function(arrayBuffer){
    //console.log(arrayBuffer);
    var formdata = new FormData();
    formdata.append("image",document.getElementById("profile-photo-upload").files[0]);
    //formdata.append("type","file");
    //formdata.append("name","test1d");
    
    //console.log(formdata);
    const result = await uploadProfilePicture(formdata);
    if(result == true){
      //localStorage.setItem("encodedImage",userProfilePage.encode_function(arrayBuffer));
      await header.getProfileImageOnHomePage("photo-logout");
      alert("Photo Uploaded Seccessfully!");
    }
    else{
      alert("Error, try again!");
    }
    
  },

  getProfileImage: async function(){
    await header.getProfileImageOnHomePage("profile-photo");
    // if(localStorage.getItem("encodedImage")!=null){
    //   console.log("#####################");
    //   let image = document.getElementById("profile-photo");
    //   let bytes = localStorage.getItem("imageInBytes");
    //   var arr = [];
    //   arr.push(bytes);
    //   /*image.src = "data:image/jpg;base64,"+
    //   userProfilePage.encode_function(arr);*/
    //   image.src = localStorage.getItem("urlImage");
    //   console.log(image.src);
    //   image.setAttribute("src",localStorage.getItem("urlImage"));
    //   var a = document.createElement("img");
    //   a.src = localStorage.getItem("urlImage");
    //   a.id = "profile-photo";
    //   a.setAttribute("hidden");
    //   document.getElementById("dependent-form").appendChild(a);
    //   console.log("#####################");
      /*console.log(bytes);
      console.log(userProfilePage.encode_function(arr));*/
    
  },

  encode_function: function encode (input) {
    var keyStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";
    var output = "";
    var chr1, chr2, chr3, enc1, enc2, enc3, enc4;
    var i = 0;

    while (i < input.length) {
        chr1 = input[i++];
        chr2 = i < input.length ? input[i++] : Number.NaN; // Not sure if the index 
        chr3 = i < input.length ? input[i++] : Number.NaN; // checks are needed here

        enc1 = chr1 >> 2;
        enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
        enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
        enc4 = chr3 & 63;

        if (isNaN(chr2)) {
            enc3 = enc4 = 64;
        } else if (isNaN(chr3)) {
            enc4 = 64;
        }
        output += keyStr.charAt(enc1) + keyStr.charAt(enc2) +
                  keyStr.charAt(enc3) + keyStr.charAt(enc4);
    }
    return output;
}
  
}

export default userProfilePage;