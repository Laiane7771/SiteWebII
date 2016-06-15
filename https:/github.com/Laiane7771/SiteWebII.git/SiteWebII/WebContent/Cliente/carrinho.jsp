<%@page import="edu.ifg.formosa.bd.ProdutoDAO"%>
<%@page import="edu.ifg.formosa.model.Produto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="com.sun.xml.internal.stream.Entity"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<table id="tabelaC"  border=1 >
			<tr>
				<td id="nomeCat">Nome</td>
				<td>Valor</td>
				<td>Quantidade</td>
				<td>Excluir do carinho</td>
			</tr>
			<h1>Produtos no seu carrinho</h1>
			<%
				HttpSession sessao = request.getSession(false);
				if(sessao != null){
					Object o = sessao.getAttribute("carrinho");
					if(o==null){
						
						out.println("Não existe produtos no seu carrinho");
					}else{
						HashMap <Integer,Integer> carrinho = (HashMap<Integer,Integer>)o;
						Set<Entry<Integer,Integer>> produto = carrinho.entrySet();
						Iterator<Entry<Integer,Integer>> it = produto.iterator();
						if(carrinho.size()==0){
							
							out.println("Não existe produtos no seu carrinho");
							out.println();		
					}
						else{
						
					
					while(it.hasNext()){
						Entry<Integer,Integer> p = it.next();
						int idProduto = p.getKey();
						int qtd = p.getValue();
						Produto pro = ProdutoDAO.buscaProduto(idProduto);
			%>
			<tr>
				<td> <%=pro.getNome() %></td>
				<td><%=pro.getValor() %></td>
				<td><%=qtd %></td>
				<td><a href="RemoveCarrinho?idProduto=<%=idProduto %>"> <img
						src="img/ex.png" width="70px">
			</tr>
			<% 	
				   }
				}
			%>
			</table>
			<% 
					}
				}
			%>
		<br>
		<a href="logoutCliente"> Sair</a>
		<input type="button" value="Voltar" class="button_active" onclick="location.href='index.jsp';" />
		<input type="button" value="Finalizar compra" class="button_active" onclick="location.href='index.jsp';" />
	</body>
</html>