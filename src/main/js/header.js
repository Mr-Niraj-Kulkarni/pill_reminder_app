
const header = {
  after_render: function () {
  var openstatus = true;
  
  document.getElementById("menu-icon").addEventListener("click",()=>{
    openstatus ? close() : open();
  });
  const close =()=>{
    document.getElementById("sidebar_one").classList.add("collapse");
    openstatus = false;
  }
  const open = ()=>{
    document.getElementById("sidebar_one").classList.remove("collapse");
    openstatus = true;
  }
  document.getElementById("logout-icon").addEventListener("click",()=>{
    localStorage.removeItem("jwtToken");
    history.pushState("http://localhost:8080","sample","#/");
    window.location.reload();
    
  })
  },
  render: () => {
    return `
    <span class="menu-icon" id="menu-icon">&#9776;</span>
    <span class="title"><b><u>Pill Reminder App</u></b></span>
    <span class="logout-icon" id="logout-icon">&#10150;</span>
    `;
  },

  submitLoginData: async function () {
    
  },
  
}

export default header;