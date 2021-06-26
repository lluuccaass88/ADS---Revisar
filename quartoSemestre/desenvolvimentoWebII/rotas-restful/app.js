const express = require('express');
const path = require('path')
const methodOverride = require('method-override');

const app = express();

app.set('view engine', 'ejs')

app.use(methodOverride('_method'));
app.use(express.static(path.join(__dirname, 'public')))
app.use(express.urlencoded({extended: true}));


let postagens = []
let novo;
let id = 0;

app.get('/postagens', (req,res)=>{
    novo = 2;
    res.render('postagens/index', {postagens, novo});
})

app.get('/postagens/new', (req, res)=>{
    res.render('postagens/new');
})

app.get('/postagens/:id', (req, res)=>{
    const {id} = req.params;
    const postagem = postagens.find(postagem=> postagem.id == id);
    if(postagem){
        res.render('postagens/show', {postagem});
    }else{
        res.send("Postagem inexistente")
    }
})

app.get('/postagens/:id/edit', (req, res)=>{
    const{id} = req.params;
    const postagem = postagens.find(postagem=> postagem.id == id);
    res.render('postagens/edit', {postagem});
})

app.post('/postagens', (req, res)=>{
    const {titulo, categoria, texto, descricao} = req.body;
    postagens.push({titulo, categoria, texto, descricao, id})
    novo = 1;
    id++;
    res.render('postagens/index', {postagens, novo});
})

app.patch('/postagens/:id', (req, res)=>{
    const {id} = req.params;
    const {titulo, categoria} = req.body;
    const postagem = postagens.find(postagem=> postagem.id == id);
    postagem.titulo = titulo;
    postagem.categoria = categoria;
    res.redirect('/postagens');
})

app.delete('/postagens/:id', (req, res) => { 
    const {id} = req.params;
    postagens = postagens.filter(postagem => postagem.id != id);
    res.redirect('/postagens');
});

app.listen(3002, () =>{
    console.log("Server Ligado")
})