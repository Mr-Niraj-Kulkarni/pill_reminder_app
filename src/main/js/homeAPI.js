export const getUserInfoHomePage = async()=>{
  console.log();
  try{
		const response = await fetch('http://localhost:8080/userInfo',{
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
        'Authorization' : localStorage.getItem("jwtToken")
      },
    })
    const returnFromServer = await response.json();
    console.log(returnFromServer);
    document.getElementById("homepage-username").innerHTML = returnFromServer.userName;
    document.getElementById("homepage-useremail").innerHTML = returnFromServer.userEmail;
    document.getElementById("homepage-usercontact").innerHTML = returnFromServer.userContact;
    if(returnFromServer.userWeight == null || returnFromServer.userHeight == null){
      document.getElementById("homepage-userbmi").innerHTML = "Update your profile information to get the BMI";
    }
    else{
      let weight = parseInt(returnFromServer.userWeight);
      let height = parseInt(returnFromServer.userHeight)/100;
      let bmi = weight/(height*height);
      document.getElementById("homepage-userbmi").innerHTML = bmi.toFixed(2);
    }
    
  }catch(e){
    console.log("ERROR: ", e);
 }
}

export const getPillInfoHomePage = async()=>{
  try{
		const response = await fetch('http://localhost:8080/getPillInfo',{
      method: 'GET',
      headers: {
        'Authorization' : localStorage.getItem("jwtToken")
      },
    })
    const returnFromServer = await response.json();
    console.log(returnFromServer);
    return returnFromServer;
  }catch(e){
    
    //console.log("ERROR: ", e);
    console.log("dsdsa");
    return null;
 }
}

export const sendPillTakenStatus = async(data)=>{
  try{
		const response = await fetch('http://localhost:8080/setPillStatus',{
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Authorization' : localStorage.getItem("jwtToken")
      },
      body: JSON.stringify(data)
    })
      const returnFromServer = await response.json();
      console.log(returnFromServer);
	} catch(e){
		 console.log("ERROR: ", e);
	}
} 