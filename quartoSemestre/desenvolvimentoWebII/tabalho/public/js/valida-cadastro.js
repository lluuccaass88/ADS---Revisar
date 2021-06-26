function validaTelefone(){
    let telefone = document.getElementById('numero').value;

    if(telefone.length === 9){
        return true
    }else{
        alert("O telefone deve ter 9 digitos");
        return false;
    }

}

function validaSenha(){
    let senha1 = document.getElementById('password').value
    let senha2 = document.getElementById('password-repeat').value
    
    console.log(`Senha1: ${senha1}  Senha2: ${senha2}`)

    if(senha1 == senha2){

        validaTelefone()

        console.log("Senhas ok")
        return true
    }else{
        alert("As senhas não batem");
        return false
    }
}

function validaForm(){
    if(validaSenha() == true && validaTelefone() == true){
        return true
    }else{
        return false
    }
}