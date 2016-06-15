function validar() {
var nome = form1.nome.value;
var email = form1.email.value;
var senha = form1.senha.value;
var rep_senha = form1.rep_senha.value;
 
if (nome == "") {
alert('Preencha o campo com seu nome');
form1.nome.focus();
return false;
}
}