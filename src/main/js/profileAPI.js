import encode from './encodePhoto.js';
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
		const response = await fetch('http://www.whateverorigin.org/get?url=https://api.imgur.com/3/image',{
      method: 'POST',
      headers: {
        'Content-Type': 'multipart/form-data',
        'Authorization' : '1d1b829370d66629b69269d956bb32c94c47bd2c',
        'Access-Control-Allow-Origin': '*',
        'Access-Control-Allow-Methods': 'POST, GET, OPTIONS',
        'Access-Control-Allow-Headers': 'X-PINGOTHER, Content-Type',
        'Access-Control-Max-Age': '86400'
      },
      body: formdata
    })
      const returnFromServer = await response.json();
      alert(returnFromServer.data.link);
      
	} catch(e){
		 console.log("ERROR: ", e);
	}
}*/
/*export const uploadProfilePicture = async(formdata)=>{
  try{
    console.log(formdata);
		const response = await fetch('https://api.imgur.com/3/image',{
      method: 'POST',
      headers: {
        'Authorization' : 'Bearer 9f8d93a300bcdef10c6ba00dcb564480d83e56c1',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(formdata)
    })
    console.log(formdata);
      const returnFromServer = await response.json();
      return returnFromServer.data.link;
      
	} catch(e){
		 console.log("ERROR: ", e);
	}
}*/

/*export const uploadProfilePicture = async(formdata)=>{
  try{
    console.log(formdata);
		const response = await fetch('https://api.imgur.com/3/image',{
      method: 'POST',
      headers: {
        'Authorization' : 'Bearer 4707cb57268e899e37aa01f887cd0680ec26579c'
      },
      body: formdata
    })
    console.log(formdata);
      const returnFromServer = await response.json();
      return returnFromServer.data.link;
      
	} catch(e){
		 console.log("ERROR: ", e);
  }
}*/
export const uploadProfilePicture = async(formdata)=>{
  try{
    console.log(formdata);
		const response = await fetch('http://localhost:8080/uploadImage',{
      method: 'POST',
      headers: {
        'Authorization' : localStorage.getItem("jwtToken")
      },
      body: formdata
    })
    console.log(formdata);
      const returnFromServer = await response.json();
      return returnFromServer;
      //return returnFromServer.data.link;
      
	} catch(e){
		 console.log("ERROR: ", e);
  }
}

export const getProfilePicture = async()=>{
  
  console.log("sasa");
  try{
		const response = await fetch('http://localhost:8080/getImage',{
      method: 'GET',
      headers: {
        'Authorization' : localStorage.getItem("jwtToken"),
        'Content-Type': 'application/json'
      }
      //body: JSON.stringify(data)
    })
    console.log("sasa");
    var base64String = null;
      const returnFromServer = await response.arrayBuffer();
      console.log(returnFromServer);
      return returnFromServer;
      /*var img = document.getElementById("profile-photo");
      img.src = returnFromServer;*/ 
	} catch(e){
		 console.log("ERROR: ", e);
  }
}
