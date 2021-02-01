
const dependentMedicalHistory = {


  after_render: async function () {

    document.getElementById("view-dependent-data").addEventListener("click", () => {

      if (dependentRelation != "Relation") {
        if (dependentRelation == "Children" && dependentName.trim().length == 0) {
          alert("Please specify Name of your child");
        }
        else {

        }


      }

    });
  }
}