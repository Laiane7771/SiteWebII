<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Cadastro de Subcategorias</title>
	   	<link rel= "stylesheet" href="../css/categoria.css">
		<link rel= "stylesheet" href="../css/subcategorias.css">
		<link rel="stylesheet" href="../css/corpo_adm.css"/>
		<link rel="stylesheet" href="../css/cabecalho_adm.css"/>
		<script src="../js/jquery-1.3.2.min.js" type="text/javascript"></script>
		<script type="text/javascript">
	        $(document).ready(function(){
	       	 	$('#categorias').load('/SiteWebII/Administrador/listarCategorias');
	        });
		</script>
		</head>
	<body>
		<header id = cabecalho>
			<div id = "label_boasVindas" class = "estilo-text"> Bem-Vindo Laiane</div>
			<div id = "logo-ecommerce"></div>
			<div id = "label-administrar"><span class = "estilo-text">Área Administrativa</span></div>
		</header>
		<div id = principal>
			<div id = "espacoFormulario">
				<% String mensagem = (String)request.getSession().getAttribute("msg");
					if(mensagem!=null){
					out.println("<span id='mensagemSucesso'>"+mensagem+"</span>");
					request.getSession().removeAttribute("msg");
					}			
				%>
				<form action="registrarSubCategoria" method="GET">
				
					<span id = "labelCadatrarSub">Cadastrar Subcategoria</span>
					<span id = "labelCategoria">Categoria:</span>
					<select id = "categorias" name = "categorias"></select>
					<span id = "labelNomeSub">Nome:</span>
					<input type = "text" id = "subcategorias" name = "nome"></input>
					<span id = "labelDescriSub">Descrição:</span>
					<textarea rows="3" cols="6" id = "areaDescri" name = "descricao"></textarea>
					<a href="administracao.html"><div id = "btnVolta"><span id = "labelVoltar">Voltar</span></div></a>
					<input type="submit" name = "Cadastrar" id = "btnCadastra" value="cadastrar"></input>
					
				</form>
			</div>
			<form enctype="multipart/form-data" action="" method="">
				<input type="text" name="pesquisar" id="inputPesquisar"></input>
				<input type= "submit" name="pesquisar" id= "pesquisar" value="Pesquisar"/>
			</form>
			<div id = "espacoTabelaSub">
				<table  id = "tabelaSub" width = "50%"border = "1">
					<tr> 
						<td> Categoria</td>
						<td> Nome</td>
						<td> Descrição</td>
					</tr>
					<tr> 
						<td> Notebook</td>
						<td> Dell</td>
						<td> Marca Registrada</td>
					</tr>
					<tr> 
						<td> Celular</td>
						<td> Apple</td>
						<td> Marca Registrada</td>
					</tr>
					<tr> 
						<td> Tablet</td>
						<td> Accer</td>
						<td> Marca Registrada</td>
					</tr>
					<tr> 
						<td> Netbook</td>
						<td> Accer</td>
						<td> Marca Registrada</td>
					</tr>
				</table>
			</div>
	  </div>
	<footer id = rodape><span id = "estilo-rodape">Power By Laiane Ricardo</span></footer>
	</body>
</html>