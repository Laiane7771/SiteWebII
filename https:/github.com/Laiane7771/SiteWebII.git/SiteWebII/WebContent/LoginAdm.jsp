<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
		<link rel = "stylesheet" href="css/login.css"></link>
	</head>
	<body>
		<!-- ============================================= -->
		<!-- =============PRINCIPAL======================= -->
		<!-- ============================================= -->
			<div id="FormularioLogin">
				<span id="tituloPagina">Login</span>
				<form action="loginAdministrador" method="post">
					<span id="nomeUsuario">Usuario:</span><input id="inputUsuario" type="text" name="usuario"/><br/>
					<span id="Senha">Senha:</span><input id="inputSenha" type="password" name="senha"/><br/>
					<div class="cadastre-se" >
						<a class="voltarHome" href="../Administrador/administracao.html">Voltar a tela Inicial</a>
					</div>
					<input class="botaoLogin" type="submit" value="Login">
				</form>
			</div>
		
		<!-- ============================================= -->
		<!-- ============RODAPE=========================== -->
		<!-- ============================================= -->
		<footer class = "rodape"></footer>
	</body>
</html>