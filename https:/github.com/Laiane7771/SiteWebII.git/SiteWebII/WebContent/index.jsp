<%@page import="edu.ifg.formosa.bd.SubCategoriaDAO"%>
<%@page import="edu.ifg.formosa.model.SubCategoria"%>
<%@page import="edu.ifg.formosa.bd.ProdutoDAO"%>
<%@page import="edu.ifg.formosa.bd.CategoriaDAO"%>
<%@page import="java.util.List"%>
<%@page import="edu.ifg.formosa.model.Categoria"%>
<%@page import="edu.ifg.formosa.model.Produto"%>
<%@page import="java.util.Iterator"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Home</title>
		<link rel="stylesheet" href="css/estilo_cabecalho.css">
		<link rel="stylesheet" href="css/estilo_corpo.css">
		<link rel="stylesheet" href="css/estilo_rodape.css">
		<link rel="stylesheet" href="css/subcategorias.css">
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
		<!--  <script type="text/javascript" src="js/banner2.js"></script>-->
	</head>
	<body>
		<!-- ============================================================================ -->
		<!-- =====================HEADER================================================= -->
		<!-- ============================================================================ -->
		<header id = "Menus" class="centralizar">
			<a href = "index.jsp"><div id = "logo" ></div></a>
			<a href="carrinho.jsp"><div id = "carrinho"></div></a>
			<div id = "areaBusca">
				<div id= "areaBuscaEsq"></div>
				<div id = "areaBuscaCentro">
					<div id = "label_buscar">Buscar</div>
						<div id = "area_input_buscar">
							<div id = "area-input-esq"></div>
							<div id = "area-input-centro">
								<form action="listarProdutoPorNome" method="get">
									<input id = "area_input" type="text" name="valorPesquisa">
									<input class="pesquisarProd" id = "pesquisar" type="submit">
								</form> 
							</div>
							<div id = "area-input-dir"></div>
						</div>
					</div>
				<div id = "areaBuscaDir"></div>
			</div>			
				<nav class = "navegar_acima">
					<a class = "link-cabecalho" href = "Atendimento.html"> Atendimento </a>
					<a class = "link-cabecalho" href = "MeusPedidos.html"> Meus pedidos </a>
					<a class = "link-cabecalho" href = "Login.jsp"> Login ou Cadastre-se </a>	
				</nav>	
		</header>

		<!--=================================================================================-->
		<!--==========================seçao principal======categoria=========================-->
		<!--=================================================================================-->
		<section id="principal" class= "centralizar" class = "fontTitulo">
			<div id = "banner_principal"></div>
			<section id = "categoria" >
				<div id ="categoria-esq" ></div>
				<div id ="categoria-centro" class = "labelCategoria" >Categoria</div>
				<div id ="categoria-dir"></div>
				<div id="listaCategorias">
					<ul id="ulCategoria" class="ulSemEstilo">
						<%
						Categoria c = new Categoria();
						 List<Categoria> lista = CategoriaDAO.buscaCategorias();
						 if(lista != null){
							Iterator<Categoria> ic = lista.iterator();
							  while(ic.hasNext()){
								   c = ic.next();
						%>  
						                 
						<li class="liCategoria"><a class="liCategoria1" href="/listaProdutos.jsp?codCategory=
						<%=c.getIdCategoria()%>&indexPage=1"><%= c.getNomeCategoria()%></a></li>
						<%}} %>  
					</ul>
				</div>
					 <% 
					List<Produto> listaProduto = ProdutoDAO.buscaProdutos();
	   				if(listaProduto != null){
						Iterator<Produto> it = listaProduto.iterator();
					}%>
			</section>
			<!--=================================================================================-->
			<!--==============================Produtos em Destaque===============================-->
			<!--=================================================================================-->
			
			<section id = "produtos-destaque">
				<div id ="produto-bar-esq" ></div>
				<div id ="produto-bar-centro" class = "labelCategoria" >Produtos em Destaque</div>
				<div id ="produto-bar-dir"></div>
				<div id = "listaCategorias">
					<nav class="linha">
						<ul class="listaDeProdutos">
							<%
							Iterator<Produto> it = listaProduto.iterator();
							Produto p = new Produto();
						
							while(it.hasNext()){
	                    	p = it.next();     		        		
                    		%>
							<li>
								<div class = "quadro">
								<img id="imagemProd" width="100px" height="100px"  src="imagemProduto?idProduto=<%=p.getIdProduto()%>"><div class="lista-produtos" ><a href="produto.jsp"></a></div>
								<div class = "detalhes"><a href = "produto.html"></a></div>
								<div class = "texto_descricao_produto">
								<div class = "informacao_produto"></br> 
									</div>
										<div class = "area-preco" class= "informacao_produto">
											<span class = "desc-text"> <%=p.getNome() %></span></br>
											<span class = "desc-riscado"><%=p.getDescricao() %></span></br>
											<span class = "preco"><%=p.getValor() %> </span></br>
										</div>
											<span class="addCarrinho"><a href="">Adicionar ao Carrinho</a></span>
											<span class="comprar"><a href="">Comprar</a></span>
									</div>
								</div>
							</li>
							<%	} %>
						</ul>
					</nav>
			</div>
			</section>
		</section>
	 	<section id = "rodape" class= "centralizar">
			<div class="navegar_acima">Site criado por Laiane</div>
		</section> 
		<!--<script type="text/javascript" src="js/banner2.js"></script>  -->
	</body>
</html>