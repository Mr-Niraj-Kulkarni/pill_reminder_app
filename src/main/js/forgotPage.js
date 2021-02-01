import loginPage from './loginPage.js';
import { postForgotData } from './loginAPI.js';


const forgotPage = {
  after_render: function () {

    //save forgot data
    document.getElementById("save-data").addEventListener("click", e => {
      e.preventDefault();
<<<<<<< HEAD
      alert("hello darling")
=======
>>>>>>> cff86cabed5a6066cf6f9767f57845481a6f3c6c
      forgotPage.submitForgotData();
    });

    //back to login page
    document.getElementById("cancel-data").addEventListener("click", e => {
<<<<<<< HEAD
      e.preventDefault();
=======
    	//e.preventDefault();
>>>>>>> cff86cabed5a6066cf6f9767f57845481a6f3c6c
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
        <div id = "responce-msg"></div>
          <form id = "forgot-form">
            <table>
              <tr>
                <th>User Email : </th>
                <td><input id = "mail" type = "email" /></td>
              </tr>
              <tr>
                <th>Secret Answer : </th>
                <td><input id = "S-ans" type = "text" /></td>
              </tr>
              <tr>
                <th>New Password : </th>
                <td><input id = "newPass" type = "password" /></td>
              </tr>
              <tr>
                <th>Confirm Password : </th>
                <td><input id = "oldPass" type = "password" /></td>
              </tr>
<<<<<<< HEAD
              <tr>
                <td><br><a href = "#" ><button id = "save-data" type = "submit" style = "width:100%;">Save</button></a></td>
                <td  align = "right"><br><a href = "#" ><button id = "cancel-data" style = "width:50%;">Cancel</button></a></td>
              </tr>
=======
              <tr><nav>
                <td><br><a href = "#" ><button id = "save-data" type = "submit" style = "width:100%;">Save</button></a></td>
                <td  align = "right"><br><a href = "#/" ><button id = "cancel-data" style = "width:50%;" onclick="location.href='#/'"> cancel</button></a></td>
              </nav></tr>
>>>>>>> cff86cabed5a6066cf6f9767f57845481a6f3c6c
            </table>
          </form>
        
      </div>
    `;
  },

  submitForgotData: async function () {
    let mail = document.getElementById("mail").value;
    let Sans = document.getElementById("S-ans").value;
    let Npwd = document.getElementById("newPass").value;
    let Opwd = document.getElementById("oldPass").value;


    if (Npwd == Opwd) {
      const forgotdata = {
        "userEmail": mail,
        "userAnswer": Sans,
        "userPassword": Npwd
      }
      console.log(forgotdata);
      await postForgotData(forgotdata);

    } else {
      alert("new password does not match with confirm password ");
    }




  }

}

export default forgotPage;