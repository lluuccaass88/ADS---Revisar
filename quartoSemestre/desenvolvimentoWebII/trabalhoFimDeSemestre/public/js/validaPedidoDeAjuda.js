
function validaCep(){
    let cep = document.getElementById('cep').value

    if(cep.length === 8){
        return true
    }else{
        alert("O cep deve ter 8 digitos");
        return false;
    }
}

function  validaForm(){
    if(validaCep()){
        return true;
    }else{
        return false;
    }
}