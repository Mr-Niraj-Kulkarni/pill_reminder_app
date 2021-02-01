

export const displayMedicalHistory = async (data) => {
  try {
    const response = await fetch('http://localhost:8080/displayMedicalHistory', {
      method: 'POST', // or 'PUT'
      headers: {
        'Content-Type': 'application/json',
        'Authorization': localStorage.getItem("jwtToken")
      },
      body: JSON.stringify(data)
    });

    const medicalHistoryDataarray = await response.json();
    console.log(medicalHistoryDataarray);
    if (medicalHistoryDataarray != null) {
      // console.log(medicalHistoryDataarray[0].dosageBreakfastTime);
      return medicalHistoryDataarray;
    }

    return null;

  } catch (e) {
    console.log("ERROR: ", e);
  }
}


export const addMedicalHistory = async (data) => {
  try {
    const response = await fetch('http://localhost:8080/addUserMedicalHistory', {
      method: 'POST', // or 'PUT'
      headers: {
        'Content-Type': 'application/json',
        'Authorization': localStorage.getItem("jwtToken")
      },
      body: JSON.stringify(data)
    });

    return await response.json();


  } catch (e) {
    console.log("ERROR: ", e);
  }
}
export const addDependentMedicalHistory = async (data) => {
  try {
    const response = await fetch('http://localhost:8080/addDependentMedicalHistory', {
      method: 'POST', // or 'PUT'
      headers: {
        'Content-Type': 'application/json',
        'Authorization': localStorage.getItem("jwtToken")
      },
      body: JSON.stringify(data)
    });

    return await response.json();


  } catch (e) {
    console.log("ERROR: ", e);
  }
}

export const deleteMedicalHistory = async (data) => {
  try {
    const response = await fetch('http://localhost:8080/deleteSingleMedicalHistory', {
      method: 'POST', // or 'PUT'
      headers: {
        'Content-Type': 'application/json',
        'Authorization': localStorage.getItem("jwtToken")
      },
      body: JSON.stringify(data)
    });

    return await response.json();


  } catch (e) {
    console.log("ERROR: ", e);
  }
}




export const updateMedicalHistory = async (data) => {
  try {
    const response = await fetch('http://localhost:8080/updateUserMedicalHistory', {
      method: 'POST', // or 'PUT'
      headers: {
        'Content-Type': 'application/json',
        'Authorization': localStorage.getItem("jwtToken")
      },
      body: JSON.stringify(data)
    });

    return await response.json();


  } catch (e) {
    console.log("ERROR: ", e);
  }
}


export const updateDependentMedicalHistory = async (data) => {
  try {
    const response = await fetch('http://localhost:8080/updateDependentMedicalHistory', {
      method: 'POST', // or 'PUT'
      headers: {
        'Content-Type': 'application/json',
        'Authorization': localStorage.getItem("jwtToken")
      },
      body: JSON.stringify(data)
    });

    return await response.json();


  } catch (e) {
    console.log("ERROR: ", e);
  }
}