const http = require('http');

// URL da API que você deseja consumir
const apiUrl = 'http://localhost:8080/pessoa';

// Opções da solicitação HTTP
const options = {
  method: 'GET',
  headers: {
    'Content-Type': 'application/json' // Defina os cabeçalhos conforme necessário
  }
};

// Faça a solicitação HTTP
const req = http.request(apiUrl, options, (res) => {
  let data = '';

  // Concatenar os dados recebidos
  res.on('data', (chunk) => {
    data += chunk;
  });

  // Manipular a resposta completa
  res.on('end', () => {
    // Parsear os dados recebidos (se for JSON)
    const jsonData = JSON.parse(data);
    console.log(jsonData);
  });
});

// Lidar com erros na solicitação
req.on('error', (error) => {
  console.error(error);
});

// Finalizar a solicitação
req.end();