<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login</title>
		<link rel="stylesheet" href="css/login.css">
	</head>
<body>
	<%
		Object o = request.getSession().getAttribute("msg");
		if(o != null){
			String msg = (String)o;
			out.println("<span id='mensagemErro'>"+ o + "<span/>");
		}
	%>
	
	<div id="FormularioLogin">
		<span id="tituloPagina">Login</span>
		<form action="loginCliente" method="post">
			<input id="inputTipoUsuario" name="tipo" value="Cliente"></input>
			<span id="nomeUsuario">Usuario:</span><input id="inputUsuario" type="text"name="usuario"/><br/>
			<span id="Senha">Senha:</span><input id="inputSenha" type= "password" name="senha"/><br/>
			<div class="cadastre-se" >
				<a class="cadastre-se" href="cadastrarCliente.html">Cadastre-se</a>
				<a class="voltarHome" href="index.jsp">Voltar a tela Inicial</a>
			</div>
			<input class="botaoLogin" type="submit" value="Login">
		</form>
	</div>
</body>
</html>