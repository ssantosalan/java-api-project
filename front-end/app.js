const express = require('express');
const app = express();
const port = 3000;
const path = require('path');

// Definir uma rota para a página inicial
app.get('/', (req, res) => {
  console.log("---------------------------> " + __dirname)
  const filePath = path.join(__dirname, './src/login/loginView/login.html');
  res.sendFile(filePath);
});

// Iniciar o servidor
app.listen(port, () => {
  console.log(`Servidor rodando em http://localhost:${port}`);
});
