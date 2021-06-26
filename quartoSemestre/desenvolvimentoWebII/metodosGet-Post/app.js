const express = require('express');

const app = express();
const path = require("path");

app.use(express.static(path.join(__dirname, 'public')));

app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, 'views'));

app.use(express.urlencoded({extended: true}));

//Objeto para guardar os itens do carrinho.
let produtos = [

]

app.get('/', (req, res) =>{
    res.render('home');
});

app.get('/carrinho', (req, res) =>{    

    const {prodnm, prodimg, prodpreco} = req.query;

    if(prodnm){ //Verifica se tem algum dado para ser salvo dentro do obj
        produtos.push({nome: prodnm, imagem: prodimg, preco: prodpreco});
    }
    //Precisaria adicionar os objetos dentro do array por aqui
    console.log(produtos)
});

app.get('/confirmacaoVenda', (req,res)=>{
    const{q, l, p} = req.query;
    res.render('confirmVenda', {q, l, p});
})

app.post('/mostrarDados', (req, res)=>{
    const{inputEmail, inputNome, inputEndereco, inputComplemento, inputCidade, inputEstado, inputCep, inputQuantidade} = req.body;
    res.render('mostrarDados', {inputEmail, inputNome, inputEndereco, inputComplemento, inputCidade, inputEstado, inputCep, inputQuantidade});
})

app.listen(3000, ()=>{
    console.log("Servidor Rodando com sucesso!")
});