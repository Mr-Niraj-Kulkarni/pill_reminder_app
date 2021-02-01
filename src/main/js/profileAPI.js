export const getProfileData = async()=>{
  console.log();
  try{
		const response = await fetch('http://localhost:8080/getProfileData',{
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
        'Authorization' : localStorage.getItem("jwtToken")
      },
    })
      const returnFromServer = await response.json();
      console.log(returnFromServer);
      document.getElementById("profile-photo").setAttribute("src",returnFromServer.userProfilePic);
      document.getElementById("profile-name").value = returnFromServer.userName;
      document.getElementById("profile-email").value = returnFromServer.userEmail;
      document.getElementById("profile-contact").value = returnFromServer.userContact;
      document.getElementById("profile-bloodgroup").value = returnFromServer.userBloodGroup;
      document.getElementById("profile-dob").value = returnFromServer.userDateOfBirth;
      document.getElementById("profile-weight").value = returnFromServer.userWeight;
      document.getElementById("profile-height").value = returnFromServer.userHeight;
      console.log(returnFromServer.relationsList.length);
      for(var i = 0; i<returnFromServer.relationsList.length;i++){
        const createOption = document.createElement("option");
      createOption.value = returnFromServer.relationsList[i];
      createOption.textContent = returnFromServer.relationsList[i];
      document.getElementById("relationship").appendChild(createOption);
      }


	} catch(e){
		 console.log("ERROR: ", e);
	}
}
export const viewDependentData = async(data)=>{
  try{
		const response = await fetch('http://localhost:8080/getDependentProfileData',{
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Authorization' : localStorage.getItem("jwtToken")
      },
      body: JSON.stringify(data)
    })
      const returnFromServer = await response.json();
      console.log(returnFromServer);
      document.getElementById("dependent-relationship").value = returnFromServer.dependentRelation;
      document.getElementById("dependent-name").value = returnFromServer.dependentName;
      document.getElementById("dependent-email").value = returnFromServer.dependentEmail;
      document.getElementById("dependent-contact").value = returnFromServer.dependentContact;
      document.getElementById("dependent-bloodgroup").value = returnFromServer.dependentBloodGroup;
      document.getElementById("dependent-weight").value = returnFromServer.dependentWeight;
      document.getElementById("dependent-height").value = returnFromServer.dependentHeight;
      document.getElementById("dependent-dob").value = returnFromServer.dependentDateOfBirth;
	} catch(e){
		 console.log("ERROR: ", e);
	}
} 

export const updateUserProfileData = async(data)=>{
  try{
		const response = await fetch('http://localhost:8080/setProfileData',{
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Authorization' : localStorage.getItem("jwtToken")
      },
      body: JSON.stringify(data)
    })
      const returnFromServer = await response.text();
      if(returnFromServer!=null){
        alert(returnFromServer);
        console.log(returnFromServer);
      }
      
	} catch(e){
		 console.log("ERROR: ", e);
	}
} 

export const updateDependentProfileData = async(data)=>{
  try{
		const response = await fetch('http://localhost:8080/setDependentProfileData',{
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Authorization' : localStorage.getItem("jwtToken")
      },
      body: JSON.stringify(data)
    })
      const returnFromServer = await response.text();
      if(returnFromServer!=null){
        alert(returnFromServer);
        console.log(returnFromServer);
      }
      
	} catch(e){
		 console.log("ERROR: ", e);
	}
} 

/*export const uploadProfilePicture = async(formdata)=>{
  try{
		const response = await fetch('https://api.imgur.com/3/image',{
      method: 'POST',
      headers: {
        'Authorization' : '1d1b829370d66629b69269d956bb32c94c47bd2c'
      },
      body: formdata
    })
      const returnFromServer = await response.json();
      alert(returnFromServer.data.link);
      
	} catch(e){
		 console.log("ERROR: ", e);
	}
} */
export const uploadProfilePicture = async(formdata)=>{
  try{
    console.log(formdata);
		const response = await fetch('https://api.imgur.com/3/image',{
      crossDomain : "true",
      method: 'POST',
      headers: {
        'Authorization' : 'Bearer 9f8d93a300bcdef10c6ba00dcb564480d83e56c1',
        "Access-Control-Allow-Origin" : "*",
        "Access-Control-Allow-Methods": "POST,",
        "Access-Control-Allow-Headers": "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With"
      },
      body: formdata
    })
    console.log(formdata);
      const returnFromServer = await response.json();
      return returnFromServer.data.link;
      
	} catch(e){
		 console.log("ERROR: ", e);
	}
}
