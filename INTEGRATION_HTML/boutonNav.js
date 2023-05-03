// bouton pour se connecter ou se déconnecter
function boutonCompte() {
    if (sessionStorage.getItem('nom') === null) {
      document.getElementById('id01').style.display = 'block';
    } else {
      if (confirm("Voulez-vous vous déconnecter?")) {
        sessionStorage.clear();
        alert("Déconnexion réussie");
        location.href = 'Main.html';
      }
    }
  }


  function postUser() {

    nom = document.getElementsByName("uname")[0].value;
    sessionStorage.setItem('nom', nom);
    console.log(sessionStorage.getItem('nom'));
    psw = document.getElementsByName("psw")[0].value;
    sessionStorage.setItem('psw', psw);
    console.log(sessionStorage.getItem('psw'));

    fetch("https://jsonplaceholder.typicode.com/todos", {
      method: "POST",
      body: JSON.stringify({
        name: nom,
        password: psw
      }),
      headers: {
        "Content-type": "application/json; charset=UTF-8"
      }
    })
      .then(response => response.json())
      .then(json => console.log(json))
      .catch(error => console.log(error));
  }

  //vérifier si la personne est connecté
  function boutonPortefeuille() {
    console.log(sessionStorage.getItem('nom'));
    if (sessionStorage.getItem('nom') === null) {
      alert("Vous devez vous connecter pour accéder à votre portefeuille.");
    } else {
      location.href = 'portefeuille.html';
    }
  }

  // Get the modal
  var modal1 = document.getElementById('id01');
  var modal2 = document.getElementById('id02');
  var button1 = document.getElementById('button01')
  var button2 = document.getElementById('button02')


  // When the user clicks anywhere outside of the modal, close it
  window.onclick = function (event) {
    if (event.target == modal1) {
      modal1.style.display = "none";
    }
    if (event.target == modal2) {
      modal2.style.display = "none";
    }
  }
  button1.addEventListener("click", () => {
    modal1.style.display = "none";
    modal2.style.display = "block"
  })
  button2.addEventListener("click", () => {
    modal2.style.display = "none";
  })