function getTerminByID() {
    const BurgerID = document.getElementById("r_terminno").value;

    // fetch(`API_URL/${BurgerID}`)
    //   .then(response => response.json())
    //   .then(patient => {
        termin={
            "ID":"12345",
            "Op_Zimmer":"101",
            "Kunden_ID": "4234",
            "Datum": "2000-11-03T06:00",
            "Arzt_ID":"123",
            "Type":"Vorbesprechung"
        }
        document.getElementById("r_zimmer_id").value = termin.Op_Zimmer;
        document.getElementById("r_kunde_id").value = termin.Kunden_ID;
        document.getElementById("r_op_datum").value = termin.Datum;
        document.getElementById("r_arzt_id").value = termin.Arzt_ID;
        document.getElementById("r_status").value = termin.Type;
    //   })
    //   .catch(error => {
    //     console.error("Hasta bilgileri alınırken hata oluştu:", error);
    //   });
  }
  
  function updateTermin(termin) {
  
    fetch(`http://localhost:8080/termin/update/{{ID}}/${termin.id}`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(termin)
    })
      .then(response => {
        if (response.ok) {
          console.log("Der Termin-Informationen sind aktualisiert.");
        } else {
          console.error("Ups!!Etwas bei der Aktualisierung des Termin-Informationen Schiff gegangen.");
        }
      })
      .catch(error => {
        console.error("Ups!!Etwas bei der Aktualisierung des Termin-Informationen Schiff gegangen:", error);
      });
  }
  

  
  document.getElementById("update-termin-button").addEventListener("click", () => {
    const id = document.getElementById("r_terminno").value;
    const Zimmer = document.getElementById("r_zimmer_id").value;
    const Kunde = document.getElementById("r_kunde_id").value;
    const Datum = document.getElementById("r_op_datum").value;
    const Arzt = document.getElementById("r_arzt_id").value;
    const Status = document.getElementById("r_status").value;
  
   const updatedTermin = {
    id: id,
    ZimmerID: Zimmer,
    KundeID: Kunde,
    Datum: Datum,
    Arzt: Arzt,
    Status: Status,
  };

  updateTermin(updatedTermin);
});

function updateTermin(termin) {

  fetch(`http://localhost:8080/termin/update/{{ID}}/${termin.id}`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(termin)
  })
    .then(response => {
      if (response.ok) {
        console.log('Der Termin-Informationen sind aktualisiert.');
      } else {
        console.error('Ups!!Etwas bei der Aktualisierung des Termin-Informationen Schiff gegangen.');
      }
    })
    .catch(error => {
      console.error('Ups!!Etwas bei der Aktualisierung des Termin-Informationen Schiff gegangen:', error);
    });
}