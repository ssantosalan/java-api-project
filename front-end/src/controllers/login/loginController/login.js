function fazerRequisicao() {
    console.log("-----------------> Teste")
    const url = 'http://localhost:8080/pessoa/create'; // Substitua pela URL da sua API
    const data = {
        name:"Alan",
        email: "alan@gmail.com",
        password: "123654",
        cpf: "32198765422"
    };
    console.log(JSON.stringify(data))
    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(result => {
        console.log('Resposta da API:', result);
        // Faça algo com a resposta da API
    })
    .catch(error => {
        console.error('Erro na requisição:', error);
        // Trate o erro da requisição
    });
}

function teste(){
    const name = document.querySelector("#name");
    const email = document.getElementById("email");
    const password = document.getElementById("password");
    const cpf = document.getElementById("cpf");
    alert('name: ' + name.innerHTML + "\nEmail: " + email.textContent)
}
