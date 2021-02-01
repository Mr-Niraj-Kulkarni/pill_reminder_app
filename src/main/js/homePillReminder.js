export const userpillsa = [
  [{pid:1, id:11, medicine:"medicine 1", dosage:"2 Tablets", time:"At 3pm"},
  {pid:1, id:12, medicine:"medicine 2", dosage:"4 Tablets", time:"At 10pm"},
  {pid:1, id:13, medicine:"medicine 3", dosage:"1 Tablet", time:"At 9am"}]];

export const dependentpills = [
  [{pid:2, id:21, medicine:"medicine 4", dosage:"4 Tablets", time:"At 6pm"},
  {pid:2, id:22, medicine:"medicine 5", dosage:"8 Tablets", time:"At 7pm"},
  {pid:2, id:23, medicine:"medicine 6", dosage:"5 Tablet", time:"At 11am"},
  {pid:2, id:24, medicine:"medicine 7", dosage:"51 Tablet", time:"At 12am"}],
  [{pid:3, id:31, medicine:"medicine 8", dosage:"45 Tablet", time:"At 1am"},
  {pid:3, id:32, medicine:"medicine 9", dosage:"52 Tablet", time:"At 2am"}]
   ];

   /*let idsort = pillid.reduce((acc,value,index)=>{
     console.log(value);
     acc[value.pid].push(value);
     return acc;
   },{1:[],2:[],3:[]});
   for(var i=1;i<4;i++){
     let abc = idsort[i];
     console.log(abc);
   }

let one = pillid.filter(e=>e.pid==1);
console.log(one);*/


export const homePillReminder = {
  render: async (dependentpills) => {
    /*const products = await getProducts();
    console.log(products);*/
    
    //console.log(dependentpills);
    //console.log(dependentpills.length);
    return `
    ${dependentpills.map(pills=>`
    <div id="cards">
      <div class="card1-cover" id="class1-cover">
            <div>&#x26a0;</div>&nbsp;Pill Schedule:&nbsp;<div id="name-on-card" class="name-on-card">Wilson, Richard </div><div>&nbsp;(Self)&nbsp;</div><br><br>
            <div class="date-on-card" id="date-on-card">Today, 25 Aug 2020</div>
      </div>
            <table id="card1">
              <tr><th></th><th>Medicine</th><th>Dosage</th><th>Time</th></tr>
              ${
                pills.map(finalpill =>`
              <tr><td><input type="checkbox" id="chk${finalpill.id}" value = "${finalpill.medicine}"></td>
              <td>${finalpill.medicine}</td><td>${finalpill.dosage}</td><td>${finalpill.time}</td></tr>
          
        `).join("")
      }
            </table>
      
    </div>
      `).join("")}
    
    `;
  }
}
