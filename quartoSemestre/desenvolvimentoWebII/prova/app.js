const express = require('express')
const mongoose = require('mongoose')
const path = require('path')
const passport = require('passport')
const LocalStrategy = require('passport-local')
const expressSession = require('express-session')
const methodOverride = require('method-override');
const User = require('./models/user')
const Post = require('./models/post')

const app = express()

app.set('view engine', 'ejs');

app.use(express.static(path.join(__dirname, 'public')))
app.use(express.urlencoded({extended: true}));
app.use(methodOverride('_method'));
app.use(expressSession({
    secret: "meu_segredo",
    resave: false,
    saveUninitialized: false
}))
app.use(passport.initialize())
app.use(passport.session())

passport.use(new LocalStrategy(User.authenticate()))

passport.serializeUser(User.serializeUser())
passport.deserializeUser(User.deserializeUser())

const isLoggedIn = (req, res, next) =>{
    if(req.isAuthenticated()){
        return next();
    }
    req.session.returnTo = req.originalUrl;
    res.render('login.ejs')
}

app.get("/", (req, res) =>{
    res.redirect('/home');
})

app.get("/home", async(req, res) =>{
    let posts;
    let meses = ['JANEIRO', 'FEVEREIRO', 'MARÇO', 'ABRIL', 'MAIO', 'JUNHO', 'JULHO', 'AGOSTO', 'SETEMBRO', 'NOVEMBRO', 'DEZEMBRO']
    let date 
    let datePosts = [];
    
    await Post.find({}, (err, docs)=>{ 
        if(err){
            console.log("errro ao buscar :" + err);
        }else{
            posts = docs;
        }
    })

    //Tranformando as datas no formato necessário para a pagina:
    for(let i = 0; i < posts.length; i++){
        date = posts[i].data
        datePosts[i] = `${date.getDate()} ${meses[date.getMonth()]} ${date.getFullYear()}`
    }
    
    res.render('index.ejs', {posts, datePosts})
})

app.get("/show/:id", async(req, res) =>{
    const {id} = req.params
    let post;
    let meses = ['JANEIRO', 'FEVEREIRO', 'MARÇO', 'ABRIL', 'MAIO', 'JUNHO', 'JULHO', 'AGOSTO', 'SETEMBRO', 'NOVEMBRO', 'DEZEMBRO']
    let date 
    let datePosts = [];

    await Post.findById(id, (err, docs)=>{ 
        if(err){
            console.log("errro ao buscar :" + err);
        }else{
            post = docs;
        }
    })
    
    
    //Tranformando as datas no formato necessário para a pagina:
    
        date = post.data
        datePosts = `${date.getDate()} ${meses[date.getMonth()]} ${date.getFullYear()}`
    

    res.render('show.ejs', {post, datePosts})
})

app.get("/login", (req, res)=>{
    res.render('login.ejs')
})

app.get("/new", (req, res)=>{
    res.render('cadastrar.ejs');
})

//Home da administração
app.get("/administracao", async(req, res)=>{
    let artigos;

    await Post.find({}, (err, docs)=>{ 
        if(err){
            console.log("errro ao buscar :" + err);
        }else{
            artigos = docs;
        }
    })

    res.render("adm/index.ejs", {artigos})
})

//Adicionando nova postagem
app.get("/administracao/new", (req, res)=>{
    res.render('adm/new.ejs')
})

//Editando postagem
app.get("/administracao/:id/edit", async(req, res)=>{
    const {id} = req.params;
    let post;

    await Post.findById(id, (err, docs)=>{ 
        if(err){
            console.log("errro ao buscar :" + err);
        }else{
            post = docs;
        }
    })

    res.render("adm/edit", {post});
})

app.get('/logout', (req, res) =>{
    req.logOut();
    res.redirect('/')
})

app.post("/login", (req, res)=>{
    const redirectUrl = req.session.returnTo || "/administracao";
    delete req.session.returnTo
    res.redirect(redirectUrl)
})

app.post("/new", (req, res)=>{
    const {username} = req.body;

    User.register(new User({username}), req.body.password, (err, user) =>{
        if(err){
            console.log("Erro " + err);
            res.redirect("/home");
        }else{
            passport.authenticate("local")(req, res, ()=>{
                res.redirect("/administracao");
            })
        }
    })
})

app.put("/home/:id", async(req, res)=>{  
    const { id } = req.params;
    const {text, name} = req.body

  await Post.findByIdAndUpdate(id, {$push:{comments: {text: text, name: name}}}, (err, doc)=>{
      if(err){
          console.log("Err0: " + err)
      }else{
          res.redirect("/show/"+id)
      }
  })

})

app.post("/administracao/new", async(req, res)=>{
    const {title, image, text} = req.body;

    console.log(req.body)

    const novoPost = new Post({title, image, text});

    await novoPost.save().then(()=>{ 
        res.redirect("/administracao"); 
    }).catch((err)=>{
        res.redirect("/administracao/new")
    })
})

app.put("/administracao/:id", async(req, res)=>{
    const {id} = req.params;
    await Post.findByIdAndUpdate(id, req.body, {runValidators: true});
    res.redirect('/administracao');
})

app.delete('/administracao/:id', async (req, res) => {
    const {id} = req.params;
    await Post.findByIdAndDelete(id);
    res.redirect('/administracao');
});

mongoose.connect("mongodb://localhost/provaDesweb", {useNewUrlParser: true, useUnifiedTopology: true, useFindAndModify: false, useCreateIndex: true}).then(()=>{
    console.log("Conectado ao banco de dados")
}).catch(err =>{
    console.log("Erro: " + err)
})

app.listen(3008, ()=>{
    console.log("Servidor rodando!")
})