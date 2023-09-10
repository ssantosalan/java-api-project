function cadastrar() {
    console.log('chegou cadastro');
    const url = 'http://localhost:8080/pessoa/create'

    const data = {
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        password: document.getElementById("password").value,
        cpf: document.getElementById("cpf").value
    };
    console.log(JSON.stringify(data));
    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => {
            console.log('Resposta da API:', response);
            window.location.href = '/home'; // Redireciona para a rota '/home'
        })
        .catch(error => {
            console.error('Erro na requisição:', error);
            // Trate o erro da requisição
        });


};