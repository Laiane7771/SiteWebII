<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Cadastro</title>
		<link rel="stylesheet" href="css/cadCliente.css"></link>
		<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
		<script type="text/javascript">
	        $(document).ready(function(){
	       	 	$('#uf').load('/SiteWebII/ListarEstado');
	        });
		</script>
	</head>
	<body>
		<section></section>
			
		<div class="formulario">
			<form action="CadastrarCliente" method="post">
				<span id="spanTituloPagina">Cadastro</span>
				
				<span id="spanNome">Nome:</span><input type="text" class="inputNome" name="nome"></input>
				
				<span id="spanRG">RG:</span><input type="text" class="inputRG" name="rg"></input>
				
				<span id="spanCpf">CPF:</span><input type="text" class="inputCpf" name="cpf"></input>
				
				<span id="spanEmail">E-mail:</span><input type="text" class="inputEmail" name="email"></input>
				
				<span id="spanEndereco">Endereco:</span><input type="text" class="inputEndereco" name="endereco"></input>
				
				<span id="spanRua">Rua:</span><input type="text" class="inputRua" name="rua"></input>
				
				<span id="spanNu">Nº</span><input type="text" class="inputNu" name="numero"></input>
				
				<span id="spanCep">CEP:</span><input type="text" class="inputCep" name="cep"></input>
				
				<span id="spanBairro">Bairro:</span><input type="text" class="inputBairro" name="bairro"></input>
				
				<span id="spanCidade">Cidade:</span><input type="text" class="inputCidade" name="cidade"></input>
				
				<span id="spanGO">Estado:</span><select class="selectUf" id="uf" name="uf"></select>
				
				<span id="spanUsuario">Usuario:</span><input type="text" id="inputUsuario" name="usuario"></input>
				
				<span id="spanSenha">Senha:</span><input class="inputSenha" name="senha"></input>
				
				<span id="spanConfirma">Confirmar Senha:</span><input class="inputConfirma" name="confirmaSenha"></input>
				
				<input type="submit" value="Enviar" id="inputEnviar"></input>
				
				<div id="botaoVoltar"><a href="Login.jsp">Voltar</a></div>
				
			</form>
				<% String res = (String)request.getSession().getAttribute("mensagem");
					if(res!=null){
					out.println("<span id='mensagemSucesso'>"+res+"</span>");
					}			
				%>
		</div>
		<section></section>
	</body>
</html>