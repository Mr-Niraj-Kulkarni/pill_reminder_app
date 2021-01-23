
const isBlank = function (str) {
  if (str.trim() != "") {
    return false;
  }
  return true;

}

const userValidation = {



  isValidName: function () {
    var name = String(document.getElementById("reg-name").value);
    var letters = /^[A-Za-z \s ]+$/;
    if (!isBlank(name)) {
      if (name.match(letters)) {
        //displays green tick
        document.getElementById("reg-td1").innerHTML = "&#x2705;";
        return true;
      }
      else {
        //displays red cross 
        document.getElementById("reg-td1").innerHTML = "&#x274C;";
        return false;
      }

    }
    //displays red cross 
    document.getElementById("reg-td1").innerHTML = "&#x274C;";
    return false;

  },

  isValidEmail: function () {
    var email = document.getElementById("reg-email").value;
    let emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
      "[a-zA-Z0-9_+&*-]+)*@" +
      "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
      "A-Z]{2,7}$";

    if (isBlank(email)) {
      document.getElementById("reg-td2").innerHTML = "&#x274C;";
      return false;
    }
    if (email.match(emailRegex)) {
      document.getElementById("reg-td2").innerHTML = "&#x2705;";
      return true;
    }
    else {
      document.getElementById("reg-td2").innerHTML = "&#x274C;";
      return false;
    }

  },

  isValidContact: function () {
    var contact = document.getElementById("reg-number").value;
    let digitRegex = "[0-9]+";
    if (isBlank(contact)) {
      document.getElementById("reg-td3").innerHTML = "&#x274C;";
      return false;
    }
    if (contact.match(digitRegex)) {
      document.getElementById("reg-td3").innerHTML = "&#x2705;";
      return true;
    }
    else {
      document.getElementById("reg-td3").innerHTML = "&#x274C;";
      return false;
    }
  },

  isValidDateofBirth: function () {
    var dob = document.getElementById("reg-dob").value;
    if (dob.length == 0) {
      document.getElementById("reg-td5").innerHTML = "&#x274C;";
      return true;
    }
    else {
      document.getElementById("reg-td5").innerHTML = "&#x2705;";
      return false;
    }
  },

  isValidPassword: function () {
    var password = document.getElementById("reg-pwd1").value;
    let passwordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,20}$/;
    if (isBlank(password)) {
      document.getElementById("reg-td6").innerHTML = "&#x274C;";
      return false;
    }
    if (password.match(passwordRegex)) {
      document.getElementById("reg-td6").innerHTML = "&#x2705;";
      return true;
    }
    else {

      alert("1 Uppercase, 1 lowercase and 1 number along with 8-20 characters");
      return false;
    }



  },

  passwordCheck: function () {
    var password = document.getElementById("reg-pwd1").value;
    var confirmpassword = document.getElementById("reg-pwd2").value;
    if (password.trim() === confirmpassword.trim()) {
      document.getElementById("reg-td7").innerHTML = "&#x2705;";
      return true;
    }
    else {
      document.getElementById("reg-td7").innerHTML = "&#x274C;";
      return false;
    }
  },



  isValidEmailForForgotPassword: function () {
    var forgotEmail = document.getElementById("mail").value;
    let emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
      "[a-zA-Z0-9_+&*-]+)*@" +
      "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
      "A-Z]{2,7}$";

    if (isBlank(forgotEmail)) {
      document.getElementById("for-mail").innerHTML = "&#x274C;";
      return false;
    }
    if (forgotEmail.match(emailRegex)) {
      document.getElementById("for-mail").innerHTML = "&#x2705;";
      return true;
    }
    else {
      document.getElementById("for-mail").innerHTML = "&#x274C;";
      return false;
    }

  },

  isValidPasswordForForgotPassword: function () {
    var password = document.getElementById("newPass").value;
    let passwordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,20}$/;
    if (isBlank(password)) {
      document.getElementById("for-npass").innerHTML = "&#x274C;";
      return false;
    }
    if (password.match(passwordRegex)) {
      document.getElementById("for-npass").innerHTML = "&#x2705;";
      return true;
    }else {

      alert("1 Uppercase, 1 lowercase and 1 number along with 8-20 characters");
      return false;
    }
  },

  passwordCheckForForgotPassword: function () {
    var password = document.getElementById("newPass").value;
    var confirmpassword = document.getElementById("oldPass").value;
    if (password.trim() === confirmpassword.trim()) {
      document.getElementById("for-cpass").innerHTML = "&#x2705;";
      return true;
    }
    else {
      document.getElementById("for-cpass").innerHTML = "&#x274C;";
      return false;
    }
  },





}

export default userValidation;