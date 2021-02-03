import {getPillInfoHomePage} from './homeAPI.js';
import {getUserInfoHomePage} from './homeAPI.js';
import {sendPillTakenStatus} from './homeAPI.js';

export const homePillReminder = {
  after_render : ()=>{
    var today = new Date();
    today.setHours(0, 0, 0, 0);
    document.getElementById("date-on-card").innerHTML = today.toDateString().substring(0,15);

    document.getElementById("main_mid_row").addEventListener("click",(e)=>{ 
      //console.log(e.target);
      if(e.target.classList.contains("pillCheckbox")){
        let id = parseInt(e.target.getAttribute("id"));
        console.log(id);
        let checkvalue = 0;
        if(document.getElementById(id).checked){
          checkvalue = 1;
        }
        else{
          checkvalue = 0;
        };
        //console.log(id,checkvalue);
        homePillReminder.sendPillUpdateStatus(id,checkvalue);
      }
    })
  
  },

  render: async () => {
    const pilldata = await getPillInfoHomePage();
    let array = homePillReminder.arraymanipulation(pilldata);

    
    //console.log(dependentpills);
    //console.log(dependentpills.length);
    ///////////////////////////////////////////////////////////////
    return `
    <div>
    ${array.map(pills=>`
    <div id="cards">
      <div class="card1-cover" id="class1-cover">
            <div>&#x26a0;</div>&nbsp;Pill Schedule:&nbsp;<div id="name-on-card" class="name-on-card">${pills[0].dependentName}&nbsp;(${pills[0].dependentRelation})</div><br><br>
            <div class="date-on-card" id="date-on-card"></div>
      </div>
            <table id="card1">
              <tr><th></th><th>Medicine</th><th>Dosage</th><th>Time</th></tr>
              ${
                pills.map(pill=>`
                <tr><td><input type="checkbox" id="${pill.pillTableid}" class="pillCheckbox" ${pill.checkbox}></td>
                <td>${pill.pillName}</td><td>${pill.dosageAmount}</td><td>${pill.pillTime}</td></tr>
               
        `).join("")
      }
            </table>
    </div>
      `).join("")}
    </div>
    `;
    /////////////////////////////////////////////////////////////////////////
    // return `
    // <div id="cards">
    //   <div class="card1-cover" id="class1-cover">
    //         <div>&#x26a0;</div>&nbsp;Pill Schedule:&nbsp;<div id="name-on-card" class="name-on-card">Wilson, Richard </div><div>&nbsp;(Self)&nbsp;</div><br><br>
    //         <div class="date-on-card" id="date-on-card">Today, 25 Aug 2020</div>
    //   </div>
    //         <table id="card1">
    //           <tr><th></th><th>Medicine</th><th>Dosage</th><th>Time</th></tr>
    //           ${
    //             pilldata.map(pill =>`
    //           <tr><td><input type="checkbox" id="chk${pill.userId}" value = "${pill.pillName}"></td>
    //           <td>${pill.pillName}</td><td>${pill.dosageAmount}</td><td>${pill.pillTime}</td></tr>
          
    //     `).join("")
    //   }
    //         </table>
    
    // </div>
    // `;
  },

  arraymanipulation: (pilldata)=>{
    let i = 0;
    let arr1 = [];
    let arr2 = [];
    let arr3 = [];
    let d = 9999;
    pilldata.map(obj=>{
      if(obj.dependentId==0){
        arr1.push(obj);
      }
      else{
        if(d==obj.dependentId)
        {
          arr2.push(obj);
        }
        else{
          d=obj.dependentId;
          if(i==0){
            arr2.push(obj);
            i++;
          }else{
            arr3.push(arr2);
            arr2 = [];
            arr2.push(obj);
          }
          
        }
        
      }
      if(obj.checkbox == 1){
        obj.checkbox = "checked";
      }
      else{
        obj.checkbox = "";
      }
    })
    arr3.push(arr2);
    
    arr1[0]["dependentName"] = document.getElementById("homepage-username").innerHTML;
    arr1[0]["dependentRelation"] = "Self";
    console.log(arr1[0]["dependentName"]);
    arr3.unshift(arr1);
    return arr3;

},

sendPillUpdateStatus: async (id, checkvalue)=>{
  const data = {
    "pillTableId" : id,
    "checkbox" : checkvalue
  }
  console.log(data);
  await sendPillTakenStatus(data);
}
}
/*const sdsds = [
  [{},{},{}],[{},{}],[{}]
]*/
