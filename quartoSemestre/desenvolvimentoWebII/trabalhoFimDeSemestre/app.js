const express = require('express');
const path = require('path');
const mongoose = require("mongoose");
const passport = require("passport");
const LocalStrategy = require("passport-local")
const expressSession = require("express-session");
const User = require('./models/user');
const Pedido = require('./models/pedidos')

const app = express();

app.set('view engine', 'ejs');

app.use(express.static(path.join(__dirname, 'public')))
app.use(express.urlencoded({extended: true}));
app.use(expressSession({ //Serve para criar uma variavel de seção/cookie
    secret: "meu_segredo...", //Assinatura do cookie  
    resave: false,
    saveUninitialized: false 
}))

app.use(passport.initialize());
app.use(passport.session());

passport.use(new LocalStrategy(User.authenticate()))

passport.serializeUser(User.serializeUser());
passport.deserializeUser(User.deserializeUser());

app.use((req, res, next) => {
    res.locals.currentUser = req.user;
    next()
})

const isLoggedIn = (req, res, next) =>{
    if(req.isAuthenticated()){
        return next();
    }
    req.session.returnTo = req.originalUrl;
    res.render('Users/login')
}

app.get('/ajudaAi', (req, res)=>{
    res.render('index')
})

app.get('/ajudaAi/newUser', (req, res)=>{
    res.render('Users/New');
})

app.get('/ajudaAi/login', (req, res)=>{
    res.render('Users/Login')
})

app.get('/ajudaAi/logout', isLoggedIn, (req, res) =>{
    req.logOut();
    res.redirect('/ajudaAi')
})

app.get('/ajudaAi/home',isLoggedIn, async(req, res) =>{
    let pedidos;

     await Pedido.find({}, (err, docs)=>{ //Pega as infos do model pedido e coloca na variavel pedidos
        if(err){
            console.log("errro ao buscar :" + err);
        }else{
            pedidos = docs;
        }
    })

    for(let i = 0; i < pedidos.length; i++){//percorre o array pedidos
        await User.findById(pedidos[i].idUsuario, (err, docs) =>{//coloca as infos achadas do id na junto no pedidos
            if(err){
                console.log("Erro ao buscar pessoas: " + err)
            }else{
                console.log(docs)
                const {nome, sobrenome, telefone, email} = docs
                const aux = pedidos[i];
                pedidos[i] = {aux, nome, sobrenome, telefone, email}
            }
        })
    }

    res.render('logado/home', {pedidos})
})

app.get('/ajudaAi/newPedido', isLoggedIn, async(req, res) =>{
    res.render('logado/pedirAjuda')
})

app.get('/ajudaAi/meuPerfil/:id', isLoggedIn, async(req, res) =>{
    const {id} = req.params;

    let pedidos;

    await Pedido.find({idUsuario: {$eq:id}}, (err, docs) =>{ 
        if(err){
            console.log("Erro ao buscar pessoas: " + err)
        }else{
            pedidos = docs
        }
    })
    res.render('logado/meuPerfil.ejs', {pedidos})
})

app.get('/ajudaAi/meuPerfil/:id/edit', isLoggedIn, async(req, res) =>{
    const {id} = req.params;

    res.render('Logado/editarPerfil.ejs')
})

app.get('/ajudaAi/dadosPedido/:idPedido/:idUser', isLoggedIn, async(req, res) =>{
    const {idPedido, idUser} = req.params

    let pedido;
    let usuario;

    await Pedido.findById(idPedido, (err, docs)=>{ //Pega as infos do model pedido e coloca na variavel pedidos
        if(err){
            console.log("errro ao buscar :" + err);
        }else{
            pedido = docs;
        }
    })

        await User.findById(idUser, (err, doc) =>{//coloca as infos achadas do id na junto no pedidos
            if(err){
                console.log("Erro ao buscar pessoas: " + err)
            }else{
                usuario = doc
            }
        })

    res.render('Logado/dadosPedido.ejs', {pedido, usuario});
})

app.get('/ajudaAi/perfil/:id', isLoggedIn, async(req, res) =>{
    const {id} = req.params

    let pedidos;
    let usuario;

    await Pedido.find({idUsuario: {$eq:id}}, (err, doc) =>{ 
        if(err){
            console.log("Erro ao buscar pessoas: " + err)
        }else{
            pedidos = doc
        }
    })

    await User.findById(id, (err, doc)=>{
        if(err){
            console.log("Erro: " + err)
        }else{
            usuario = doc
        }
    })

    res.render('Logado/perfilUsuario.ejs', {pedidos, usuario})
})

app.post('/ajudaAi/login', passport.authenticate("local", { failureRedirect: "/ajudaAi/login"}), (req, res)=>{
    const redirectUrl = req.session.returnTo || "/ajudaAi/home";
    delete req.session.returnTo
    res.redirect(redirectUrl)
})

app.post('/ajudaAi/newPedido', async(req, res) =>{
    const data = req.body
    const {rua, numero_casa, bairro, estado, cep, idUsuario, pagamento, descricao} = req.body

    const novoPedido = new Pedido({rua, numero_casa, bairro, estado, cep, idUsuario, pagamento, descricao});
    await novoPedido.save().then(()=>{ 
        res.redirect("/ajudaAi/home"); //Mudar dps para a pagina do perfil do usuario
    }).catch((err)=>{
        console.log("Erro: " + err)
        res.redirect("/ajudaAi/home")
    })
})

app.post('/ajudaAi/newUser', (req, res) =>{
    const {username, nome, sobrenome, telefone, email, nascimento} = req.body;

    User.register(new User({
        username, 
        sobrenome,
        nome, 
        telefone, 
        email, 
        nascimento
    }), req.body.password, (err, user) => {
        if(err){
            console.log("Erro: " + err);
            res.render("Users/New");
        }else{
            passport.authenticate("local")(req, res, ()=>{
                res.redirect("/ajudaAi/home")
            })
        }
    })

})

app.post('/ajudaAi/meuPerfil/:id/edit', isLoggedIn, async(req, res) =>{
    const {id} = req.params;
    console.log(req.body)
    const {nome, sobrenome, nascimento, telefone, email, username} = req.body
    
    await User.findByIdAndUpdate(id, {nome, sobrenome, nascimento, telefone, email, username}, (err, doc)=>{
        if(err){
            console.log("Erro: " + err)
            res.redirect('/ajudaAi/meuPerfil/' + id + '/edit')
        }else{
            console.log("Salvo atualizado")
            console.log(doc)
            res.redirect('/ajudaAi/meuPerfil/' + id);
        }    
    });
    
})

mongoose.connect("mongodb://localhost/ajudaAi", { useNewUrlParser: true, useUnifiedTopology: true, useFindAndModify: false, useCreateIndex: true}).then(()=>{
    console.log("Conectado ao banco de dados");
}).catch(err =>{
    console.log("Erro ao conectar no banco de dados: " + err);
})

app.listen(3008, () =>{
    console.log("Servidor rodando")
})