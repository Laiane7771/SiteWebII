<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Cadastrar Categoria</title>
		<link rel="stylesheet" href= "../css/categoria.css">
		<script type="text/javascript" src="../js/jquery-1.3.2.min.js"></script>
		<script type="text/javascript">
	        $(document).ready(function(){
	       	 	$('#tabela').load('/SiteWebII/Administrador/listarCategoriasTabela');
	        });
		</script>
	</head>
	<body>
		<header id = cabecalho>
			<div id = "label_boasVindas" class = "estilo-text"> Bem-Vindo Laiane</div>
			<div id = "logo-ecommerce"></div>
			<div id = "label-administrar"><span class = "estilo-text">Área Administrativa</span></div>
		</header>
		<!-- ------------Div Principal -------------------------->
		<!------------------------------------------------------->
		<div id = principal>
			<div id = "espaco-nomeInput">
				<% String mensagem = (String)request.getSession().getAttribute("mensagem");
					if(mensagem!=null){
					out.println("<span id='mensagemSucesso'>"+mensagem+"</span>");
					}			
				%>
				<form action="registrarCategoria" method="GET">
					<span id = "labelCadastrar">Cadastrar Categoria</span>
					<span id = "labelNome">Nome:</span>
					<input  type= "text" name = "categorias" id = "categorias"></input>
					<span id = "labelDescricao">Descrição</span>
					<textarea rows="4" cols="6" id = "descricao" name= "descricao"></textarea>
					<a href= "administracao.html"><div id = "btnVoltar"><span id = "labelv">Voltar</span></div></a>
					<input type="submit" value="cadastrar" id = "btnCadastrar" name="Cadastrar"/>
				</form> 
				
				<div>
					<input type="text" name="pesquisar" id="pesquisarCategoria"></input>
				</div>
				<div id="btnPesquisar"><span id=labelPesquisar>Pesquisar</span></div>
			</div>
			<div id = "espaco-Tabela">
				<table  id = "tabela" border '1' >
					<tr> 
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</table>
			</div>
		</div>
		<!-- -------------------------------------------------- -->
		<!-- -------------------------------------------------- -->
		<footer id = rodape><span id = "estilo-rodape">Power By Laiane Ricardo</span></footer>
	</body>
</html>