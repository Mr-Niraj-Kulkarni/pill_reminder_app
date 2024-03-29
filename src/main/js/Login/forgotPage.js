import loginPage from './loginPage.js';
import { postForgotData } from '../API/loginAPI.js';
import userValidation from './userValidation.js';


const forgotPage = {
  after_render: function () {

    //save forgot data
    document.getElementById("save-data").addEventListener("click", e => {
      e.preventDefault();

      if (userValidation.isValidEmailForForgotPassword() && userValidation.isValidPasswordForForgotPassword() && userValidation.passwordCheckForForgotPassword() && userValidation.isValidSecretAnswerForgot()) {
        forgotPage.submitForgotData();
      }
      
    });

    //vaildation for forgot password fields
    document.getElementById("mail").addEventListener("keyup", userValidation.isValidEmail);
    document.getElementById("newPass").addEventListener("focusout", userValidation.isValidPassword);
    document.getElementById("oldPass").addEventListener("keyup", userValidation.passwordCheckForForgotPassword);
    document.getElementById("S-Answer").addEventListener("focusout", userValidation.isValidSecretAnswerReg);


    //back to login page
    document.getElementById("cancel-data").addEventListener("click", e => {
    	//e.preventDefault();
      let divele = document.getElementById("login");
      divele.innerHTML = loginPage.render();
      if (loginPage.after_render()) {
        loginPage.after_render();
      }

    });
  },

  render: () => {
    return `
      <h1>Reset Password</h1><br>
      <div id = "forgot-form">
        <div id = "responce-msg" align = "center"></div>
          <form id = "forgot-form">
            <table>
              <tr>
                <th>User Email : </th>
                <td><input id = "mail" type = "email" /></td>
                <td id = "for-mail"></td>
              </tr>
              <tr>
                <th>Secret Question : </th>
                <td>
                  <select  id="S-Question">
                    <option value = "whats is your first Teacher Name">whats is your first Teacher Name</option>
                    <option value = "which is your favourite color">which is your favourite color</option>
                    <option value = "what is your firsts pets name">what is your firsts pets name</option>
                  </select>
                </td>
                <td id = "for-S-que"></td>
              </tr>
              <tr>
                <th>Secret Answer : </th>
                <td><input id = "S-Answer" type = "text" /></td>
                <td id = "for-S-ans"</td>
              </tr>
              <tr>
                <th>New Password : </th>
                <td><input id = "newPass" type = "password" /></td>
                <td id = "for-npass"></td>
              </tr>
              <tr>
                <th>Confirm Password : </th>
                <td><input id = "oldPass" type = "password" /></td>
                <td id = "for-cpass"></td>
              </tr>
              <tr><nav>
                <td><br><a href = "#" ><button id = "save-data" type = "submit" style = "width:100%;">Save</button></a></td>
                <td  align = "right"><br><a href = "#/" ><button id = "cancel-data" style = "width:50%;" onclick="location.href='#/'"> cancel</button></a></td>
              </nav></tr>
            </table>
          </form>
        
      </div>
    `;
  },
/* after line 56 paste
// <<<<<<< HEAD
//               <tr>
//                 <td><br><a href = "#" ><button id = "save-data" type = "submit" style = "width:100%;">Save</button></a></td>
//                 <td  align = "right"><br><a href = "#" ><button id = "cancel-data" style = "width:50%;">Cancel</button></a></td>
//               </tr>
// =======
*/ 
  submitForgotData: async function () {
    let mail = document.getElementById("mail").value;
    let Squestion = document.getElementById("S-Question").value;
    let Sans = document.getElementById("S-Answer").value;
    let Npwd = document.getElementById("newPass").value;
    let Opwd = document.getElementById("oldPass").value;


    if (Npwd == Opwd) {
      const forgotdata = {
        "userEmail": mail,
        "secretQuestion" : Squestion,
        "secretAnswer": Sans,
        "userPassword": Npwd
      }
      console.log(forgotdata);
      let response = await postForgotData(forgotdata);
      if(response == 0){
        alert("User does not exist. Try again or register as a new user");
      }
      else if(response == 1){
        alert("Password updated successfully. Please login");
        window.location.href = "#/";
      }
      else{
        alert("New password cannot be same as old password");
      }

    } /*else {
      alert("new password does not match with confirm password ");
    }*/
  }

}

export default forgotPage;