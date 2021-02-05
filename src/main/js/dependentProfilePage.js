
import userValidation from './userValidation.js';
import userProfilePage from './userProfilePage.js';
import {updateDependentProfileData} from './profileAPI.js';
import {addDependentProfileData} from './profileAPI.js';


const dependentProfilePage = {
  after_render: function (flag) {
    
    

    let oldDependentEmail = "defaultValue";
    if (flag == "updateData") {

      // edit button for update
      document.getElementById("dependent-edit").addEventListener("click",()=>{
        oldDependentEmail = document.getElementById("dependent-email").value;
        document.getElementById("dependent-save").style.visibility = "visible";
        document.getElementById("dependent-cancel").style.visibility = "visible";
        document.getElementById("dependent-edit").style.visibility = "hidden";
        const profileform = document.getElementById("dependent-form");
        const profileforminputs = profileform.getElementsByTagName("input");
        for(var i = 0; i<profileforminputs.length;i++){
          profileforminputs[i].removeAttribute("readonly");
        }

         // dynamic validation
        document.getElementById("dependent-name").addEventListener("focusout", userValidation.isValidNameForDependent);
        document.getElementById("dependent-email").addEventListener("focusout", userValidation.isValidEmailForDependent);
        document.getElementById("dependent-contact").addEventListener("focusout", userValidation.isValidContactForDependent);
        document.getElementById("dependent-bloodgroup").addEventListener("focusout", userValidation.isValidBloodGroupForDependent);
        document.getElementById("dependent-dob").addEventListener("focusout", userValidation.isValidDateofBirthForDependent);
        document.getElementById("dependent-weight").addEventListener("focusout", userValidation.isValidWeightForDependent);
        document.getElementById("dependent-height").addEventListener("focusout", userValidation.isValidHeightForDependent);


      })
      // cancel button for update
      document.getElementById("dependent-cancel").addEventListener("click",()=>{
        document.getElementById("dependent-save").style.visibility = "hidden";
        document.getElementById("dependent-cancel").style.visibility = "hidden";
        document.getElementById("dependent-edit").style.visibility = "visible";
        
        const profileform = document.getElementById("dependent-form");
        const profileforminputs = profileform.getElementsByTagName("input");
        for(var i = 0; i<profileforminputs.length-3;i++){
          profileforminputs[i].value="";
          profileforminputs[i].setAttribute("readonly","readonly");
        }
        // call the dependent data
        userProfilePage.viewDependentData();

        document.getElementById("dpr-1").innerHTML = "";
        document.getElementById("dpr-2").innerHTML = "";
        document.getElementById("dpr-3").innerHTML = "";
        document.getElementById("dpr-4").innerHTML = "";
        document.getElementById("dpr-5").innerHTML = "";
        document.getElementById("dpr-6").innerHTML = "";
        document.getElementById("dpr-7").innerHTML = "";

      }) 
      // save button for update
      document.getElementById("dependent-save").addEventListener("click", ()=>{
        if (userValidation.isValidNameForDependent() && userValidation.isValidEmailForDependent()&& 
        userValidation.isValidContactForDependent() && userValidation.isValidBloodGroupForDependent() && 
        userValidation.isValidDateofBirthForDependent() && userValidation.isValidWeightForDependent() && 
        userValidation.isValidHeightForDependent())
        {
          const dependenttData = async()=>{
            await dependentProfilePage.submitDependentUpdateData(oldDependentEmail, flag);
            await userProfilePage.viewDependentData();
          }
          dependenttData();
          

          document.getElementById("dpr-1").innerHTML = "";
          document.getElementById("dpr-2").innerHTML = "";
          document.getElementById("dpr-3").innerHTML = "";
          document.getElementById("dpr-4").innerHTML = "";
          document.getElementById("dpr-5").innerHTML = "";
          document.getElementById("dpr-6").innerHTML = "";
          document.getElementById("dpr-7").innerHTML = "";
          //readonly property
          const profileform = document.getElementById("dependent-form");
          const profileforminputs = profileform.getElementsByTagName("input");
          for(var i = 0; i<profileforminputs.length-3;i++){
            //profileforminputs[i].value="";
            profileforminputs[i].setAttribute("readonly","readonly");
          }
          // call the dependent data
          

          document.getElementById("dependent-save").style.visibility = "hidden";
          document.getElementById("dependent-cancel").style.visibility = "hidden";
          document.getElementById("dependent-edit").style.visibility = "visible";
        

        }        
        else{
          alert("Please fill the data correctly");
        }
      })

     
      
    } 
    else {

      const profileform = document.getElementById("dependent-form");
      const profileforminputs = profileform.getElementsByTagName("input");
      for(var i = 0; i<profileforminputs.length;i++){
        profileforminputs[i].removeAttribute("readonly");
      }

      // edit button for add new data
      document.getElementById("dependent-edit").style.visibility = "hidden";
           
      // cancel button for add new data
      document.getElementById("dependent-cancel").style.visibility = "visible";
      document.getElementById("dependent-cancel").addEventListener("click",()=>{

        document.getElementById("dpr-1").innerHTML = "&#x274C;";
        document.getElementById("dpr-2").innerHTML = "&#x274C;";
        document.getElementById("dpr-3").innerHTML = "&#x274C;";
        document.getElementById("dpr-4").innerHTML = "&#x274C;";
        document.getElementById("dpr-5").innerHTML = "&#x274C;";
        document.getElementById("dpr-6").innerHTML = "&#x274C;";
        document.getElementById("dpr-7").innerHTML = "&#x274C;";

        const profileform = document.getElementById("dependent-form");
        const profileforminputs = profileform.getElementsByTagName("input");
        for(var i = 0; i<profileforminputs.length-3; i++){
          profileforminputs[i].value="";
        }
      }) 
      // save button for add new data
      document.getElementById("dependent-save").style.visibility = "visible";
      document.getElementById("dependent-save").addEventListener("click",async ()=>{
        if (userValidation.isValidNameForDependent() && userValidation.isValidEmailForDependent()&& 
        userValidation.isValidContactForDependent() && userValidation.isValidBloodGroupForDependent() && 
        userValidation.isValidDateofBirthForDependent() && userValidation.isValidWeightForDependent() && 
        userValidation.isValidHeightForDependent()){
        const dependenttData = async()=>{
          await dependentProfilePage.submitDependentUpdateData(oldDependentEmail, flag);
          await userProfilePage.viewDependentData();
          await userProfilePage.getProfileData();
        }
        dependenttData();

          document.getElementById("dpr-1").innerHTML = "";
          document.getElementById("dpr-2").innerHTML = "";
          document.getElementById("dpr-3").innerHTML = "";
          document.getElementById("dpr-4").innerHTML = "";
          document.getElementById("dpr-5").innerHTML = "";
          document.getElementById("dpr-6").innerHTML = "";
          document.getElementById("dpr-7").innerHTML = "";
          //readonly property
          const profileform = document.getElementById("dependent-form");
          const profileforminputs = profileform.getElementsByTagName("input");
          for(var i = 0; i<profileforminputs.length-3;i++){
            profileforminputs[i].value="";
            profileforminputs[i].setAttribute("readonly","readonly");
          }
          // call the dependent data
          
          

          document.getElementById("dependent-save").style.visibility = "hidden";
          document.getElementById("dependent-cancel").style.visibility = "hidden";
          document.getElementById("dependent-edit").style.visibility = "hidden";
        }
        else{
          alert("Please fill the data correctly");
        }
      })

      // dynamic validation
      document.getElementById("dependent-name").addEventListener("keyup", userValidation.isValidNameForDependent);
      document.getElementById("dependent-email").addEventListener("focusout", userValidation.isValidEmailForDependent);
      document.getElementById("dependent-contact").addEventListener("keyup", userValidation.isValidContactForDependent);
      document.getElementById("dependent-bloodgroup").addEventListener("focusout", userValidation.isValidBloodGroupForDependent);
      document.getElementById("dependent-dob").addEventListener("focusout", userValidation.isValidDateofBirthForDependent);
      document.getElementById("dependent-weight").addEventListener("keyup", userValidation.isValidWeightForDependent);
      document.getElementById("dependent-height").addEventListener("keyup", userValidation.isValidHeightForDependent);


    }   

    
  },
  render: () => {

    return `
    <form id="dependent-form"></form>
            <h2 class="image-para">DEPENDENT PROFILE</h2>
              <table id="dependent-form">
                <tr><th>Relationship</th><td>
                  <select id="dependent-relationship" readonly> 
                    <option value="" disabled selected>Relation</option>
                    <option value="Mother">Mother</option>
                    <option value="Father">Father</option>
                    <option value="Spouse">Spouse</option>
                    <option value="Children">Children</option>
                    <option value="Mother-Inlaw">Mother-Inlaw</option>
                    <option value="Father-Inlaw">Father-Inlaw</option>
                  </select>
                </td></tr>
                <tr><th>Name</th><td><input type="text" id="dependent-name" readonly/></td><td id="dpr-1"></td></tr>
                <tr><th>Email id</th><td><input type="email" id="dependent-email" readonly/></td><td id="dpr-2"></td></tr>
                <tr><th>Contact Number</th><td><input type="number" id="dependent-contact" readonly/></td><td id="dpr-3"></td></tr>
                <tr><th>Blood Group</th><td><input type="text" id="dependent-bloodgroup" readonly/></td><td id="dpr-4"></td></tr>
                <tr><th>Date of Birth</th><td><input type="date" id="dependent-dob" readonly/></td><td id="dpr-5"></td></tr>
                <tr><th>Weight</th><td><input type="text" id="dependent-weight" readonly/></td><td id="dpr-6"></td></tr>
                <tr><th>Height</th><td><input type="text" id="dependent-height" readonly/></td><td id="dpr-7"></td></tr>
              </table><br>
              <span class="image-para">
            <input type="button" class="save-cancel editvisiblity" id="dependent-save" value="Save" />
            <input type="button" class="save-cancel" id="dependent-edit" value="Edit" />
            <input type="button" class="save-cancel editvisiblity" id="dependent-cancel" value="Cancel" /></span>
          </form>
    `;
  },

  submitDependentUpdateData: async function (oldDependentEmail, flag) {
    //let userProfilePic = document.getElementById("login-email").value;
    const data = {
      "dependentRelation" : document.getElementById("dependent-relationship").value,
      "dependentName" : document.getElementById("dependent-name").value,
      "dependentEmail" : document.getElementById("dependent-email").value,
      "dependentContact" : document.getElementById("dependent-contact").value,
      "dependentBloodGroup" : document.getElementById("dependent-bloodgroup").value,
      "dependentDateOfBirth" : document.getElementById("dependent-dob").value,
      "dependentWeight" : document.getElementById("dependent-weight").value,
      "dependentHeight": document.getElementById("dependent-height").value,
      "oldDependentEmail" : oldDependentEmail
    }
    console.log(data);
    if (flag == "updateData") {
      console.log(oldDependentEmail+ "update");
      await updateDependentProfileData(data);
    }else{
      console.log(oldDependentEmail+ "add");
      await addDependentProfileData(data);
    }
    
    
},
  
  /*submitProfileUpdateData: async function () {
      //let userProfilePic = document.getElementById("login-email").value;
      let userName= document.getElementById("profile-name").value;
      let userEmail= document.getElementById("profile-email").value;
      let userContact= document.getElementById("profile-contact").value;
      let userBloodGroup= document.getElementById("profile-bloodgroup").value;
      let userDateOfBirth= document.getElementById("profile-dob").value;
      let userWeight= document.getElementById("profile-weight").value;
      let userHeight= document.getElementById("profile-height").value;
      
  },
  getProfileData: async function(){
    await getProfileData();
  }*/
}

export default dependentProfilePage;