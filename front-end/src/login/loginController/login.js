function fazerRequisicao() {
    console.log("-----------------> Teste")
    const url = 'http://localhost:8080/pessoa/create'; // Substitua pela URL da sua API
    const data = {
        nome: document.getElementById("name"),
        email: document.getElementById("emai"),
        password: document.getElementById("password"),
        cpf: document.getElementById("cpf")
    };
    console.log(data)
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
