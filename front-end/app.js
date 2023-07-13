const express = require('express');
const app = express();
const port = 3000;
const path = require('path');

// Servir arquivos estáticos
app.use(express.static(path.join(__dirname, './static'), {
  setHeaders: (res, path, stat) => {
    if (path.endsWith('.css')) {
      res.setHeader('Content-Type', 'text/css');
    }
  }
}));

// Definir uma rota para a página inicial
app.get('/', (req, res) => {
  console.log("---------------------------> " + __dirname)
  const filePath = path.join(__dirname, './src/login/login.html');
  res.sendFile(filePath);
});

app.get('/home', (req, res) => {
  console.log("---------------------------> Foi de redirect")
  const filePath = path.join(__dirname, './src/home/index.html');
  res.sendFile(filePath);
});

app.get('/cadastro', (req, res) => {
  const filePath = path.join(__dirname, '/src/cadastroView/cadastro.html');
  res.sendFile(filePath);
});

// Iniciar o servidor
app.listen(port, () => {
  console.log(`Servidor rodando em http://localhost:${port}`);
});
