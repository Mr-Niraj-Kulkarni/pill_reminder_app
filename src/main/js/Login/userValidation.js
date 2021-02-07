

const isBlank = function (str) {
  if (str.trim() != "") {
    return false;
  }
  return true;

}

const userValidation = {
  isValidName: function () {
    // var name = document.getElementById("reg-name").value;
    // var name = this.options[this.selectedIndex].value;
    var name = this.value;
    var letters = /^[A-Za-z \s ]+$/;
    if (!isBlank(name)) {
      if (name.match(letters)) {
        //displays green tick
        if (document.getElementById("reg-name") != null ) {
          document.getElementById("reg-td1").innerHTML = "&#x2705;";
        }
        if (document.getElementById("profile-name") != null) {
          document.getElementById("pr-1").innerHTML = "&#x2705;";
        }
        return true;
      }
      else {
        //displays red cross 
        if (document.getElementById("reg-name") != null) {
          document.getElementById("reg-td1").innerHTML = "&#x274C;";
        }
        if (document.getElementById("profile-name") != null) {
          document.getElementById("pr-1").innerHTML = "&#x274C;";
        }
        return false;
      }

    }
    //displays red cross 
    if (document.getElementById("reg-name") != null ) {
      document.getElementById("reg-td1").innerHTML = "&#x274C;";
    }
    if (document.getElementById("profile-name") != null) {
      document.getElementById("pr-1").innerHTML = "&#x274C;";
    }
    return false;

  },

  isValidBloodGroup: function () {
    var BG = this.value.toUpperCase();
    console.log(BG);
    let BGRegex = "^(A|B|AB|O)[-+]$";
    if (isBlank(BG) || !BG.match(BGRegex)) {
      if (document.getElementById("profile-bloodgroup") != null) {
        document.getElementById("pr-4").innerHTML = "&#x274C;";
      }
      return false;
    }
    else{
      document.getElementById("pr-4").innerHTML = "&#x2705;";
      return true;
    }
  },

  isValidBloodGroupForProfile: function () {
    var BG = document.getElementById("profile-bloodgroup").value.toUpperCase();
    console.log(BG);
    let BGRegex = "^(A|B|AB|O)[-+]$";
    if (isBlank(BG) || !BG.match(BGRegex)) {
      return false;
    }
    else{
      return true;
    }
  },
    

  isValidEmail: function () {
    var email = this.value;
    var element = this;
    let emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
      "[a-zA-Z0-9_+&*-]+)*@" +
      "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
      "A-Z]{2,7}$";
    if (isBlank(email)) {
      if (document.getElementById("login-email") != null) {
        document.getElementById("log-mail").innerHTML = "&#x274C;";
      } 
      if (document.getElementById("reg-email") != null) {
        document.getElementById("reg-td2").innerHTML = "&#x274C;";
      } 
      if (document.getElementById("mail") != null) {
        document.getElementById("for-mail").innerHTML = "&#x274C;";
      }
      if (document.getElementById("profile-email") != null) {
        document.getElementById("pr-2").innerHTML = "&#x274C;";
      }
      //element.parentNode.parentNode.lastChild.innerHTML = "&#x274C;";
      return false;
    }
    if (email.match(emailRegex)) {
      if (document.getElementById("login-email") != null) {
        document.getElementById("log-mail").innerHTML = "&#x2705;";
      } 
      if (document.getElementById("reg-email") != null) {
        document.getElementById("reg-td2").innerHTML = "&#x2705;";
      }
      if (document.getElementById("mail") != null) {
        document.getElementById("for-mail").innerHTML = "&#x2705;";
      }
      if (document.getElementById("profile-email") != null) {
        document.getElementById("pr-2").innerHTML = "&#x2705;";
      }
      /*console.log("dsads");
      element.parentNode.parentNode.lastChild.innerHTML = "&#x2705;";*/
      return true;
    }
    else {
      if (document.getElementById("login-email") != null) {
        document.getElementById("log-mail").innerHTML = "&#x274C;";
      } 
      if (document.getElementById("reg-email") != null) {
        document.getElementById("reg-td2").innerHTML = "&#x274C;";
      }
      if (document.getElementById("mail") != null) {
        document.getElementById("for-mail").innerHTML = "&#x274C;";
      }
      if (document.getElementById("profile-email") != null) {
        document.getElementById("pr-2").innerHTML = "&#x274C;";
      }
      return false;
    }

  },

  isValidWeight: function () {
    var wt = this.value;
    let wtRegex = "[0-9]+";
    if (isBlank(wt)) {
      if (document.getElementById("profile-weight") != null) {
        document.getElementById("pr-6").innerHTML = "&#x274C;";
      }
      return false;
    }
    if (wt.match(wtRegex)) {
      if (wt>1 && wt<595) {
      if (document.getElementById("profile-weight") != null) {
        document.getElementById("pr-6").innerHTML = "&#x2705;";
      }
      return true;
    }
    else{
      if (document.getElementById("profile-weight") != null) {
        document.getElementById("pr-6").innerHTML = "&#x274C;";
      }
      return false;
    }
  }
    return false;
  }, 

  isValidWeightForProfile: function () {
    var wt = document.getElementById("profile-weight").value;
    let wtRegex = "[0-9]+";
    if (isBlank(wt)) {
      return false;
    }
    if (wt.match(wtRegex)) {
      if (wt>1 && wt<595) {
      return true;
    }
    else{
      return false;
    }
  }
    return false;
  }, 

  isValidHeight: function () {
    var ht = this.value;
    let htRegex = "[0-9]";
    if (isBlank(ht)) {
      if (document.getElementById("profile-height") != null) {
        document.getElementById("pr-7").innerHTML = "&#x274C;";
      }
      return false;
    }
    if (ht.match(htRegex)) {
      if (ht > 30 && ht < 300) {
        if (document.getElementById("profile-height") != null) {
          document.getElementById("pr-7").innerHTML = "&#x2705;";
        }
        return true;
      }
      else{
        if (document.getElementById("profile-height") != null) {
          document.getElementById("pr-7").innerHTML = "&#x274C;";
        }
        return false;
      }
      
    }
    return false;
  },

  isValidHeightForProfile: function () {
    var ht = document.getElementById("profile-height").value;
    let htRegex = "[0-9]";
    if (isBlank(ht)) {
      return false;
    }
    if (ht.match(htRegex)) {
      if (ht > 30 && ht < 300) {
        return true;
      }
      else{
        return false;
      }
    }
    return false;
  },

  isValidContact: function () {
    var contact = this.value;
    let digitRegex = /^\d{10}$/;
    if (isBlank(contact)) {
      if (document.getElementById("reg-number") != null) {
        document.getElementById("reg-td3").innerHTML = "&#x274C;";
      }
      if (document.getElementById("profile-contact") != null) {
        document.getElementById("pr-3").innerHTML = "&#x274C;";
      }
      return false;
    }
    if (contact.match(digitRegex)) {
      console.log(contact.match(digitRegex));
      if (contact.length ==10) {
        if (document.getElementById("reg-number") != null) {
          document.getElementById("reg-td3").innerHTML = "&#x2705;";
        }
        if (document.getElementById("profile-contact") != null) {
          document.getElementById("pr-3").innerHTML = "&#x2705;";
        }
        return true;
      }else{
        if (document.getElementById("reg-number") != null) {
          document.getElementById("reg-td3").innerHTML = "&#x274C;";
        }
        if (document.getElementById("profile-contact") != null) {
          document.getElementById("pr-3").innerHTML = "&#x274C;";
        }
        return false;
      }
      
    }
    else {
      if (document.getElementById("reg-number") != null) {
        document.getElementById("reg-td3").innerHTML = "&#x274C;";
      }
      if (document.getElementById("profile-contact") != null) {
        document.getElementById("pr-3").innerHTML = "&#x274C;";
      }
      return false;
    }
  },

  isValidContactForProfile: function () {
    var contact = document.getElementById("profile-contact").value;
    let digitRegex = /^\d{10}$/;
    if (isBlank(contact)) {
      return false;
    }
    if (contact.match(digitRegex)) {
      console.log(contact.match(digitRegex));
      if (contact.length ==10) {
        return true;
      }else{
        return false;
      } 
    }
    else {
      return false;
    }
  },

  isValidDateofBirth: function () {
    var dob = this.value;
    let date = new Date();
   
    //.getDate().toString().substr(0,9)
    if (dob.length == 0 || dob>date.toISOString().substr(0,10)) {
      if (document.getElementById("reg-dob") != null) {
        document.getElementById("reg-td5").innerHTML = "&#x274C;";
      }
      if (document.getElementById("profile-dob") != null) {
        document.getElementById("pr-5").innerHTML = "&#x274C;";
      }
      return false;
    }
    else {
      if (document.getElementById("reg-dob") != null) {
        document.getElementById("reg-td5").innerHTML = "&#x2705;";
      }
      if (document.getElementById("profile-dob") != null) {
        document.getElementById("pr-5").innerHTML = "&#x2705;";
      }
      return true;
    }
  },

  isValidDateofBirthForProfile: function () {
    var dob = document.getElementById("profile-dob").value;
    let date = new Date();
   
    //.getDate().toString().substr(0,9)
    if (dob.length == 0 || dob>date.toISOString().substr(0,10)) {
      return false;
    }
    else {
      return true;
    }
  },

  isValidPassword: function () {
    
    var password = this.value;
    let passwordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,20}$/;
    if (isBlank(password) || !password.match(passwordRegex)) {
      if (document.getElementById("reg-pwd1") != null) {
        document.getElementById("reg-td6").innerHTML = "&#x274C;";
        document.getElementById("reg-td7").innerHTML = "&#x274C;";
      }
      if (document.getElementById("login-pwd") != null) {
        document.getElementById("log-pwd").innerHTML = "&#x274C;";
      }
      if (document.getElementById("newPass") != null) {
        document.getElementById("for-npass").innerHTML = "&#x274C;";
      }     
      alert("1 Uppercase, 1 lowercase and 1 number along with 8-20 characters");
      return false;
    }
    else {
      if (document.getElementById("newPass") != null) {
        document.getElementById("for-npass").innerHTML = "&#x2705;";
      } 
      if (document.getElementById("reg-pwd1") != null) {
        document.getElementById("reg-td6").innerHTML = "&#x2705;";
        document.getElementById("reg-td7").innerHTML = "&#x2705;";
      }
      return true;
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

  isValidSecretAnswerReg: function(){
    var secretans = this.value;
    var element = this;
    console.log(this);
    if(isBlank(secretans)){
      alert("Secret answer cannot be empty");
      //this.pare.innerHTML = "&#x274C;";
      //this.parent
      element.parentNode.parentNode.lastChild.innerHTML = "&#x274C;";
      //document.getElementById("").parentNode.pa
      return false;
    }
    else{
      element.parentNode.parentNode.lastChild.innerHTML = "&#x2705;";
      //document.getElementById("reg-td9").innerHTML = "&#x2705;";
      return true;
    }
  },

  isValidSecretAnswer: function(){
    var secretans = document.getElementById("reg-secretAnswer").value;
    if(secretans == null){
      alert("Secret answer cannot be empty");
      return false;
    }
    if(isBlank(secretans)){
      alert("Secret answer cannot be empty");
      return false;
    }
    else{
      return true;
    }
  },

  isValidSecretAnswerForgot: function(){
    var secretans = document.getElementById("S-Answer").value;
    if(secretans == null){
      alert("Secret answer cannot be empty");
      return false;
    }
    if(isBlank(secretans)){
      alert("Secret answer cannot be empty");
      return false;
    }
    else{
      return true;
    }
  },



  isValidEmailForForgotPassword: function () {
    var forgotEmail = document.getElementById("mail").value;
    let emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
      "[a-zA-Z0-9_+&*-]+)*@" +
      "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
      "A-Z]{2,7}$";
    console.log("forgot email check");
    if (isBlank(forgotEmail)) {
      return false;
    }
    if (forgotEmail.match(emailRegex)) {
      return true;
    }
    else {
      return false;
    }

  },

  isValidPasswordForForgotPassword: function () {
    var password = document.getElementById("newPass").value;
    let passwordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,20}$/;
    console.log("forgot pass check");
    if (isBlank(password)) {
      return false;
    }
    if (password.match(passwordRegex)) {
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

  isValidEmailForLogin: function () {
    var forgotEmail = document.getElementById("login-email").value;
    let emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
      "[a-zA-Z0-9_+&*-]+)*@" +
      "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
      "A-Z]{2,7}$";
      console.log("login email check");
    if (isBlank(forgotEmail)) {
      return false;
    }
    if (forgotEmail.match(emailRegex)) {
      return true;
    }
    else {
      return false;
    }

  },

  isValidPasswordForLogin: function () {
    var password = document.getElementById("login-pwd").value;
    let passwordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,20}$/;
    console.log("login pass check");
    if (isBlank(password)) {
      return false;
    }
    if (password.match(passwordRegex)) {
      return true;
    }else {

      //alert("1 Uppercase, 1 lowercase and 1 number along with 8-20 characters");
      return false;
    }
  },


  isValidNameForReg: function () {
    var name = document.getElementById("reg-name").value;
    var letters = /^[A-Za-z \s ]+$/;
    if (!isBlank(name)) {
      if (name.match(letters)) {
        return true;
      }
      else {
        return false;
      }

    }
    return false;
  },


  isValidEmailForReg: function () {
    var email = document.getElementById("reg-email").value;
    let emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
      "[a-zA-Z0-9_+&*-]+)*@" +
      "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
      "A-Z]{2,7}$";

    if (isBlank(email)) {
      return false;
    }
    if (email.match(emailRegex)) {
      return true;
    }
    else {
      return false;
    }

  },

  isValidPasswordForReg: function () {
    var password = document.getElementById("reg-pwd1").value;
    let passwordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,20}$/;
    if (isBlank(password)) {
      return false;
    }
    if (password.match(passwordRegex)) {
      return true;
    }
    else {
      alert("1 Uppercase, 1 lowercase and 1 number along with 8-20 characters");
      return false;
    }
  },


  isValidNameForProfile: function () {
    var name = document.getElementById("profile-name").value;
    var letters = /^[A-Za-z \s ]+$/;
    if (!isBlank(name)) {
      if (name.match(letters)) {
        return true;
      }
      else {
        return false;
      }
    }
    return false;
  },


  isValidEmailForProfile: function () {
    var email = document.getElementById("profile-email").value;
    let emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
      "[a-zA-Z0-9_+&*-]+)*@" +
      "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
      "A-Z]{2,7}$";
    if (isBlank(email)) {
      return false;
    }
    if (email.match(emailRegex)) {
      return true;
    }
    else {
      return false;
    }
  },

  isValidNameForDependent: function () {
    var name = document.getElementById("dependent-name").value;
    var letters = /^[A-Za-z \s ]+$/;
    if (!isBlank(name)) {
      if (name.match(letters)) {
        document.getElementById("dpr-1").innerHTML = "&#x2705;";
        return true;
      }
      else {
        document.getElementById("dpr-1").innerHTML = "&#x274C;";
        return false;
      }
    }
    document.getElementById("dpr-1").innerHTML = "&#x274C;";
    return false;
  },

  isValidEmailForDependent: function () {
    var email = document.getElementById("dependent-email").value;
    let emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
      "[a-zA-Z0-9_+&*-]+)*@" +
      "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
      "A-Z]{2,7}$";
    if (isBlank(email)) {
      document.getElementById("dpr-2").innerHTML = "&#x274C;";
      return false;
    }
    if (email.match(emailRegex)) {
      document.getElementById("dpr-2").innerHTML = "&#x2705;";
      return true;
    }
    else {
      document.getElementById("dpr-2").innerHTML = "&#x274C;";
      return false;
    }
  },

  isValidContactForDependent: function () {
    var contact = document.getElementById("dependent-contact").value;
    let digitRegex = /^\d{10}$/;
    if (isBlank(contact)) {
      document.getElementById("dpr-3").innerHTML = "&#x274C;";
      return false;
    }
    if (contact.match(digitRegex)) {
      if (contact.length > 9) {
        document.getElementById("dpr-3").innerHTML = "&#x2705;";
        return true;
      }else{
        document.getElementById("dpr-3").innerHTML = "&#x274C;";
        return false;
      }
      
    }
    else {
      document.getElementById("dpr-3").innerHTML = "&#x274C;";
      return false;
    }
  },


  isValidBloodGroupForDependent: function () {
    var BG = document.getElementById("dependent-bloodgroup").value.toUpperCase();
    let BGRegex = "^(A|B|AB|O)[-+]$";
    if (isBlank(BG) || !BG.match(BGRegex)) {
      document.getElementById("dpr-4").innerHTML = "&#x274C;";
      return false;
    }
    else{
      document.getElementById("dpr-4").innerHTML = "&#x2705;";
      return true;
    }
  },

  isValidDateofBirthForDependent: function () {
    var dob = document.getElementById("dependent-dob").value;
    let date = new Date();
    if (dob.length == 0 || dob>date.toISOString().substr(0,10)) {
      document.getElementById("dpr-5").innerHTML = "&#x274C;";
      return false;
    }
    else {
      document.getElementById("dpr-5").innerHTML = "&#x2705;";
      return true;
    }
  },

  isValidWeightForDependent: function () {
    var wt = document.getElementById("dependent-weight").value;
    let wtRegex = "[0-9]+";
    if (isBlank(wt)) {
      document.getElementById("dpr-6").innerHTML = "&#x274C;";
      return false;
    }
    if(wt.match(wtRegex)){
      if (wt > 2 && wt < 595) {
        document.getElementById("dpr-6").innerHTML = "&#x2705;";
        return true;
      }
      return false;
    }
  },

  isValidHeightForDependent: function () {
    var ht = document.getElementById("dependent-height").value;
    let htRegex = "[0-9]+";
    if (isBlank(ht)) {
      document.getElementById("dpr-7").innerHTML = "&#x274C;";
      return false;
    }
    if (ht.match(htRegex)) {
      if (ht > 30 && ht < 300) {
        document.getElementById("dpr-7").innerHTML = "&#x2705;";
        return true;
      }
      else{
        document.getElementById("dpr-7").innerHTML = "&#x274C;";
        return false;
      }
      
    }
    return false;
  },





}

export default userValidation;