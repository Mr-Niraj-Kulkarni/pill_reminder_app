import '../../resources/static/css/slider.css';

import medicalHistoryTable from './medicalHistoryTable.js';
import { addMedicalHistory, addDependentMedicalHistory } from '../API/medicalHIstoryAPI.js';
import { deleteMedicalHistory } from '../API/medicalHIstoryAPI.js';
import { updateMedicalHistory, updateDependentMedicalHistory } from '../API/medicalHIstoryAPI.js';
const medicalHistoryPage = {
  
  after_render: async () => {
    var parentid=null ;  
    console.log(parentid+"online 11 ");
    console.log(window.parentid+"online 12 ");

    let status = medicalHistoryPage.isDependentMedicalHistory();
    console.log(status);
    let tableValid = null;
    if (status == 1) {
      tableValid = await medicalHistoryTable.createTable(1);
    }
    else {
      tableValid = await medicalHistoryTable.createTable(0);
    }

    
    //ADD DATA BUTTON 
    document.getElementById("add-data").innerHTML = `
    <input type="button" value="VIEW DATA" id="view-dependent-data">
    <input type="button" value="ADD DATA" id="add-new-medical-history-data-entry">
    <input type="button" value="Cancel" id="cancel-changes-button">
    <input type="button" value="SAVE" id="save-changes-button">`;
    document.getElementById("add-new-medical-history-data-entry").addEventListener("click", async (e) => {
      e.stopPropagation();
      if (document.getElementById("new-row") == undefined && parentid == null) {
        console.log("In IFFFF")
        await medicalHistoryTable.addRow();
       // medicalHistoryPage
        document.getElementById("add-new-medical-history-data-entry").value = "Save";
        document.getElementById("cancel-changes-button").style.visibility = "visible";
        medicalHistoryPage.cancelbtn_function();
        
      }
      else if(document.getElementById("new-row") == undefined && parentid != null){
        medicalHistoryPage.alert_popup();
      }
      else {
        // window.addEventListener("load", medicalHistoryPage.alert_popup());
        // window.addEventListener("hashchange", medicalHistoryPage.alert_popup());
        console.log("IN ELSE");
        let status1 = medicalHistoryTable.validateRowData("new-row");

        if (status1 == 0) {
          alert("Fields cant be empty ");
        }
        else if (status1 == 1) {
          alert("choose valid dosage frequency");
        }
        else if (status1 == 2) {
          alert("start date should be less than end date ");
        }
        else if (status1 == 3) {
          alert("please check correct pill timinings");
        }
        else {

          medicalHistoryPage.addMedicalHistory(status);
          document.getElementById("add-new-medical-history-data-entry").value = "Add Data";
        document.getElementById("cancel-changes-button").style.visibility = "hidden";
        }
        
      }
    });
      if(tableValid!=0){
        console.log(tableValid);
        medicalHistoryPage.tableEventListeners(parentid,status);
      }





    document.getElementById("view-dependent-data").addEventListener("click", async () => {
      
      await medicalHistoryPage.after_render();
      

    });
  },

  dblclicksave : (parentid,status)=>{
    document.getElementById("save-changes-button").addEventListener("click", () => {

      let status2 = medicalHistoryTable.validateRowData(parentid);

      if (status2 == 0) {
        alert("Fields cant be empty ");
      }
      else if (status2 == 1) {
        alert("choose valid dosage frequency");
      }
      else if (status2 == 2) {
        alert("start date should be less than end date ");
      }
      else if (status2 == 3) {
        alert("please check correct pill timinings");
      }
      else {
        console.log(parentid);
        console.log(window.status);
        medicalHistoryPage.UpdateMedicalHistoryData(parentid, status);
        window.parentid = null;
      }
    })
  },

  cancelbtn_function : (parentid)=>{
    document.getElementById("cancel-changes-button").addEventListener("click",async()=>{
      document.getElementById("medical-history-table").innerHTML = "";
      parentid = null;
      await medicalHistoryPage.after_render();
      /*let sidebarone = document.getElementById("sidebar_one");
      sidebarone.querySelectorAll("a").forEach((e)=>{
        e.setAttribute("listener","false");
      })*/
      console.log(parentid);
    })
  },

  alert_popup: (e)=>{
    alert("You have unsaved changes on this page. Please save or cancel your updates");
    console.log("s");
  },

  tableEventListeners : (parentid, status)=>{
    //alert("yes");
console.log(parentid+"niraj is here");
  document.getElementById("render-table").addEventListener("click", async (e) => {
    const result = e.target.classList.contains("delete-button");
    if (result) {
      const id = e.target.getAttribute("id")
      medicalHistoryPage.deleteMedicalHistoryData(id, status);
    }

  });
  document.getElementById("render-table").addEventListener("dblclick", async (e) => {

    const result = e.target.classList.contains("edit-cell");
   

    if (parentid == null && document.getElementById("new-row") == undefined) {
      if (result) {
        e.target.removeAttribute("readonly");
        window.parentid = e.target.parentNode.parentNode.id;
        
    
        document.getElementById("save-changes-button").style.visibility = "visible";
        document.getElementById("cancel-changes-button").style.visibility = "visible";
        medicalHistoryPage.cancelbtn_function(window.parentid);
        medicalHistoryPage.dblclicksave(window.parentid,status);
        
        console.log("inside if ");
        //console.log(winparentid);


      }
    }
    else if (result && parentid == e.target.parentNode.parentNode.id) {
      e.target.removeAttribute("readonly");
      console.log("inside  else if ");
    


      //HERE
    }
    else {
      console.log("in else");
    }


  });

  let sidebarone = document.getElementById("sidebar_one");
        sidebarone.querySelectorAll("a").forEach((e)=>{
          if(e.getAttribute("listener")!="true"){
            console.log(e.getAttribute("listener"));
          e.addEventListener("click",function atagalert(e){
            console.log("################");
            console.log(parentid);
            if((document.getElementById("new-row") != undefined && window.parentid==null) || 
            (document.getElementById("new-row") == undefined && window.parentid!=null) ){
            console.log(e);
            
            console.log(parentid);
            e.preventDefault();
            medicalHistoryPage.alert_popup();
            }
          });
        }
        else{
          console.log("fis fa");
        }
        e.setAttribute("listener","true");
        });

  },

  render: async function () {

    return `
    <div class="mainbar" id="mainbar">
    <h2>Dependent Medical History</h2>
    <br><br>
    <select id="dependent-relationship" readonly> 
                        <option value="" disabled selected>Relation</option>
                        <option value="Mother">Mother</option>
                        <option value="Father">Father</option>
                        <option value="Spouse">Spouse</option>
                        <option value="Children">Children</option>
                        <option value="Mother-Inlaw">Mother-Inlaw</option>
                        <option value="Father-Inlaw">Father-Inlaw</option>
                        <option value="Self" selected>Self</option>
    </select>
    <br><br>
    <input type="text" id="dependent-name" >
    <br><br>
    
    <div id="add-data"></div> 
    
    <div id="medical-history-table">
    </div>
    <div id="button-div"></div>
    
    `;
  },

  addMedicalHistory: async (flag) => {
    let rowcellArray = document.getElementById("new-row").querySelectorAll("input");
    var breaktime = rowcellArray[7].value;
    if (breaktime == "") {

      breaktime = null;

    }


    var lunchtime = rowcellArray[8].value
    if (lunchtime == "") {
      lunchtime = null;
    }

    var dinnertime = rowcellArray[9].value
    if (dinnertime == "") {
      dinnertime = null;
    }

    var checkbox= rowcellArray[10].checked ;
    if(checkbox){
      checkbox = 1;
    }
    else{
      checkbox = 0;
    }

    //console.log(data);
    let status;
    if (flag == 1) {
      let data1 = {

        "illiness": rowcellArray[0].value,
        "doctorDetails": rowcellArray[1].value,
        "medicine": rowcellArray[2].value,
        "medicineStartDate": rowcellArray[3].value,
        "medicineEndDate": rowcellArray[4].value,
        "dosageAmount": rowcellArray[5].value,
        "dosageFrequency": rowcellArray[6].value,
        "dosageBreakfastTime": breaktime,
        "dosageLunchTime": lunchtime,
        "dosageDinnerTime": dinnertime,
        "emailNotification": checkbox

      }
      status = await addMedicalHistory(data1);
    }
    else {
      let data = {
        "dependentRelation": document.getElementById("dependent-relationship").value,
        "dependentName": document.getElementById("dependent-name").value,
        "illiness": rowcellArray[0].value,
        "doctorDetails": rowcellArray[1].value,
        "medicine": rowcellArray[2].value,
        "medicineStartDate": rowcellArray[3].value,
        "medicineEndDate": rowcellArray[4].value,
        "dosageAmount": rowcellArray[5].value,
        "dosageFrequency": rowcellArray[6].value,
        "dosageBreakfastTime": breaktime,
        "dosageLunchTime": lunchtime,
        "dosageDinnerTime": dinnertime,
        "emailNotification": checkbox
      }
      console.log(data);
      status = await addDependentMedicalHistory(data);
    }
    if (status) {
      await medicalHistoryPage.after_render();
    }

  },
  deleteMedicalHistoryData: async (id, flag) => {
    const data = {
      "medicalHistoryId": id,
      "flag": flag
    }
    let status = await deleteMedicalHistory(data);
    if (status) {
      await medicalHistoryPage.after_render();
      let sidebarone = document.getElementById("sidebar_one");
        sidebarone.querySelectorAll("a").forEach((e)=>{
          e.removeEventListener("click",function atagalert(e){
            console.log(e);
            console.log("sas");
            e.preventDefault();
            medicalHistoryPage.alert_popup();
          });
        });
    }
  },

  UpdateMedicalHistoryData: async (id, flag) => {
    let rowcellArray = document.getElementById(id).querySelectorAll("input");
    var breaktime = rowcellArray[7].value;
    if (breaktime == "") {

      breaktime = null;

    }


    var lunchtime = rowcellArray[8].value
    if (lunchtime == "") {
      lunchtime = null;
    }

    var dinnertime = rowcellArray[9].value
    if (dinnertime == "") {
      dinnertime = null;
    }
    var checkbox= rowcellArray[10].checked ;
    console.log(checkbox);
    if(checkbox){
      checkbox = 1;
    }
    else{
      checkbox = 0;
    }
    

    let data = {
      "medicalHistoryId": id,
      "medicineStartDate": rowcellArray[3].value,
      "medicineEndDate": rowcellArray[4].value,
      "dosageAmount": rowcellArray[5].value,
      "dosageFrequency": rowcellArray[6].value,
      "dosageBreakfastTime": breaktime,
      "dosageLunchTime": lunchtime,
      "dosageDinnerTime": dinnertime,
      "emailNotification": checkbox

    }
    //console.log(data);
    let status;
    if (flag == 1) {
      status = await updateMedicalHistory(data);
      console.log(status);
    }
    else {
      status = await updateDependentMedicalHistory(data);
    }
    if (status) {
      console.log(window.parentid+"IN UPDATE FUNCTION");
      await medicalHistoryPage.after_render();
    }
  },



  isDependentMedicalHistory: function () {
    let dependentRelation = document.getElementById("dependent-relationship").value;

    if (dependentRelation != "Relation" && dependentRelation == "Self") {
      return 1;
    }
    else {
      return 0;
    }
  }


}


export default medicalHistoryPage;