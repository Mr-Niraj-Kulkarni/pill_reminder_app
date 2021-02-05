import { displayMedicalHistory } from './medicalHIstoryAPI.js';
import medicalHistoryPage from './medicalHistoryPage.js';


const medicalHistoryTable = {

  createTable: async (flag) => {
    //1. call get API
    let data;
    if (flag == 1) {
      data = {
        "userEmail": null,
        "dependentRelation": null,
        "dependentName": null
      }
    }
    else {
      data = {
        "userEmail": null,
        "dependentRelation": document.getElementById("dependent-relationship").value,
        "dependentName": document.getElementById("dependent-name").value
      }
    }
    const medicalhistoryData = await displayMedicalHistory(data);
    //if null display no medical history and button to add history
    if (medicalhistoryData == "") { //change condition
      //display no data available 
      // button press 
      document.getElementById("medical-history-table").innerHTML = "<h2>No medical History Recorded</h2>"
      return 0;

    }
    else {
      document.getElementById("medical-history-table").innerHTML = `<table id="render-table">
      <tr>
        <th>Illiness</th>
        <th>Doctor Details </th>
        <th>Medicines</th>
        <th>Start Date </th>
        <th>End Date</th>
        <th>Dosage Amount</th>
        <th>Dosage Frequency</th>
        <th>Dosage BreakFast Time</th>
        <th>Dosage Lunch Time</th>
        <th>Dosage Dinner Time</th>
        <th>Email Notification</th>
    
      </tr>
      ${medicalhistoryData.map(row => 
        `
        
      <tr id=${row.medicalHistoryId}>
        <td>
          <input type="text" value=${row.illiness} readonly>
    
        </td>
        <td>
          <input type="text" value=${row.doctorDetails} readonly>
    
        </td>
        <td>
          <input type="text" value=${row.medicine} readonly>
    
        </td>
        <td>
          <input type="date" class="edit-cell" value=${row.medicineStartDate} readonly>
    
        </td>
        <td>
          <input type="date" class="edit-cell" value=${row.medicineEndDate} readonly>
    
        </td>
        <td>
          <input type="text"  class="edit-cell" value=${row.dosageAmount} readonly>
    
        </td>
        <td>
          <input type="text" class="edit-cell" value=${row.dosageFrequency} readonly>
    
        </td>
        <td>
          <input type="time"  class="dosage-time edit-cell" value=${row.dosageBreakfastTime} readonly>
    
        </td>
        <td>
          <input type="time"  class="dosage-time edit-cell" value=${row.dosageLunchTime} readonly>
    
        </td>
        <td>
          <input type="time"  class="dosage-time edit-cell" value=${row.dosageDinnerTime} readonly>
    
        </td>
        <td>
          <label class="switch">
            <input type="checkbox" class="edit-cell" id=${row.medicalHistoryId} ${row.emailNotification==1 ? "checked":""} readonly>
            <span class="slider round"></span>
          </label>
        </td>
        <td>
          <span class="delete-button" id=${row.medicalHistoryId}>&#x1F5D1;</span>
        </td>
    
      </tr>
    `).join("")
        }
    </table >
  `;
  
    }
    //else display data fetched in table format



  },
  addRow: async function () {
    let tr = document.createElement("tr");
    tr.id = "new-row";
    for (var i = 0; i < 3; i++) {
      let td = document.createElement("td");
      let input = td.appendChild(document.createElement("input"));
      input.type = "text";
      tr.appendChild(td);
    }
    for (var i = 0; i < 2; i++) {
      let td = document.createElement("td");
      let input = td.appendChild(document.createElement("input"));
      input.type = "date";
      tr.appendChild(td);
    }

    let td = document.createElement("td");
    let input = td.appendChild(document.createElement("input"));
    input.type = "number";
    tr.appendChild(td);

    let td1 = document.createElement("td");
    let input1 = td1.appendChild(document.createElement("input"));
    input1.type = "text";
    tr.appendChild(td1);

    for (var i = 0; i < 3; i++) {
      let td = document.createElement("td");
      let input = td.appendChild(document.createElement("input"));
      input.type = "time";
      input.step = "1";
      input.className = "dosage-time";
      tr.appendChild(td);
    }

    let td2 = document.createElement("td");
    let label2 = td2.appendChild(document.createElement("label"));
    label2.className = "switch";
    let input2 = label2.appendChild(document.createElement("input"));
    input2.type = "checkbox";
    let span2 = label2.appendChild(document.createElement("span"));
    span2.className = "slider round";
    tr.appendChild(td2);
    if(document.getElementById("render-table") !=null){
    document.getElementById("render-table").appendChild(tr);
    }
    else{
      document.getElementById("medical-history-table").innerHTML = `<table id="render-table">
      <tr>
        <th>Illiness</th>
        <th>Doctor Details </th>
        <th>Medicines</th>
        <th>Start Date </th>
        <th>End Date</th>
        <th>Dosage Amount</th>
        <th>Dosage Frequency</th>
        <th>Dosage BreakFast Time</th>
        <th>Dosage Lunch Time</th>
        <th>Dosage Dinner Time</th>
        <th>Email Notification</th>
    
      </tr>
      </table>`
      document.getElementById("render-table").appendChild(tr);
      //medicalHistoryPage.tableEventListeners(parentid);
    }
    
  },

  validateRowData: function (id) {
    let rowCellArray = document.getElementById(id).querySelectorAll("td");

    //when inserting data medical data

    for (var i = 0; i < 7; i++) {
      if (i != 4) {
        if (rowCellArray[i].querySelector("input").value.trim().length != 0) {
          continue;
        }
        else {
          return 0;
        }
      }
    }



    if (rowCellArray[6].querySelector("input").value != "once" &&
      rowCellArray[6].querySelector("input").value != "twice" &&
      rowCellArray[6].querySelector("input").value != "thrice") {
      return 1;
    }
    else {
      let dosagetime = document.getElementById(id).querySelectorAll(".dosage-time");
      if (rowCellArray[6].querySelector("input").value == "thrice") {
        dosagetime.forEach((t) => {
          if (t.value.trim() == "") {
            return 3;
          }
        });
      }

      if (rowCellArray[6].querySelector("input").value == "twice") {
        let sum = 0;
        dosagetime.forEach((t) => {
          if (t.value.trim() != "") {
            sum = sum + 1;
          }
        });
        if (sum == 2) {

        }
        else {
          return 3;
        }
      }

      if (rowCellArray[6].querySelector("input").value == "once") {
        let sum = 0;
        dosagetime.forEach((t) => {
          if (t.value.trim() == "") {
            sum = sum + 1;
          }
        });
        if (sum == 2) {

        }
        else {
          return 3;
        }

      }



    }

    var startDt = rowCellArray[3].querySelector("input").value;
    var endDt = rowCellArray[4].querySelector("input").value;

    if (endDt.length == 0) {
      // ok cook 
    }
    else {
      if ((new Date(startDt).getTime() > new Date(endDt).getTime())) {
        return 2;
      }
    }

    //all ok 
    return 4;

  },




}
export default medicalHistoryTable;



