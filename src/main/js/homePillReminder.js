export const pills = [
  { pid: 1, id: 11, medicine: "medicine 1", dosage: "2 Tablets", time: "At 3pm" },
  { pid: 1, id: 12, medicine: "medicine 2", dosage: "4 Tablets", time: "At 10pm" },
  { pid: 1, id: 13, medicine: "medicine 3", dosage: "1 Tablet", time: "At 9am" }

];
export const pills2 = [
  { pid: 2, id: 21, medicine: "medicine 4", dosage: "4 Tablets", time: "At 6pm" },
  { pid: 2, id: 22, medicine: "medicine 5", dosage: "8 Tablets", time: "At 7pm" },
  { pid: 2, id: 23, medicine: "medicine 6", dosage: "5 Tablet", time: "At 11am" }

];

const homePillReminder = {
  render: async (pills) => {
    /*const products = await getProducts();
    console.log(products);*/
    console.log(pills);
    return `
    <div class="cards">
    
      <div class="card1-cover" id="class1-cover">
            <span>&#x26a0;</span>&nbsp;<span>Pill Schedule: </span><span>Wilson, Richard</span><span>(Self)</span><br><br>
            <span>Today, 25 Aug 2020</span><br><br>
            <table id="card1">
              <tr><th></th><th>Medicine</th><th>Dosage</th><th>Time</th></tr>
              ${pills.map(pills => `
              <tr><td><input type="checkbox" id="chk${pills.id}" value = "${pills.medicine}"></td>
              <td>${pills.medicine}</td><td>${pills.dosage}</td><td>${pills.time}</td></tr>
          
        `).join("")
      }
            </table>
      </div>
    </div>
    `;
  }
}

export default homePillReminder;