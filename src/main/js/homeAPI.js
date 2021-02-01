export const getUserInfoHomePage = async()=>{
  console.log();
  try{
		const response = await fetch('http://localhost:8080/getUserInfoHomePage',{
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
        'Authorization' : localStorage.getItem("jwtToken")
      },
    })
    const returnFromServer = await response.json();
    document.getElementById("homepage-username").innerHTML = returnFromServer.userName;
    document.getElementById("homepage-useremail").innerHTML = returnFromServer.userEmail;
    document.getElementById("homepage-usercontact").innerHTML = returnFromServer.userContact;
    let weight = parseInt(returnFromServer.userWeight);
    let height = parseInt(returnFromServer.userHeight);
    let bmi = weight/(height*height);
    document.getElementById("homepage-userbmi").innerHTML = bmi;
  }catch(e){
    console.log("ERROR: ", e);
 }
}