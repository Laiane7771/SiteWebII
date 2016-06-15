<%@page import="java.util.Iterator"%>
<%@page import="edu.ifg.formosa.bd.CategoriaDAO"%>
<%@page import="java.util.List"%>
<%@page import="edu.ifg.formosa.model.Categoria"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Cadastrar Categoria</title>
		<link rel="stylesheet" href= "../css/categoria.css">
		<script type="text/javascript" src="../js/jquery-1.3.2.min.js"></script>
	</head>
	<body>
		<header id = cabecalho>
			<div id = "label_boasVindas" class = "estilo-text"> Bem-Vindo!</div>
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
				<%
					Categoria c = new Categoria();
						List<Categoria> lista = CategoriaDAO.buscaCategorias();
						 if(lista != null){
							Iterator<Categoria> ic = lista.iterator();
							  while(ic.hasNext()){
								   c = ic.next();
				%>
				<form action="alterarCategoria" method="GET">
					<span id = "labelCadastrar">Alterar Categoria</span>
					<span id = "labelNome">Nome:</span>
					<input  type= "text" name = "categorias" id = "categorias" value=<%= c.getNomeCategoria()%>></input>
					<span id = "labelDescricao">Descrição</span>
					<textarea rows="4" cols="6" id = "descricao" name= "descricao" value=<%=c.getDescricao()%>></textarea>
					<div id = "btnVoltar"><a href= "administracao.html"><span id = "labelv">Voltar</span></a></div>
					<input type="submit" value="cadastrar" id = "btnCadastrar" name="Cadastrar"/>
				</form> 
				<%}} %>
				<div>
					<input type="text" name="pesquisar" id="pesquisarCategoria"></input>
				</div>
				<div id="btnPesquisar"><span id=labelPesquisar>Pesquisar</span></div>
			</div>
		</div>
		<!-- -------------------------------------------------- -->
		<!-- -------------------------------------------------- -->
		<footer id = rodape><span id = "estilo-rodape">Power By Laiane Ricardo</span></footer>
	</body>
</html>