<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Carrinho</title>
	</head>
	<body>
		<table>
			<td>id</td>
			<td>Quantidade</td>
		</table>
		<%
			HttpSession sessao =  request.getSession(false);
			if(sessao!=null){
				HashMap<Integer, Integer> carrinho = (HashMap<Integer, Integer>)session.getAttribute("carrinho");
				Set<Entry<Integer,Integer>> produtos = carrinho.entrySet();
				Iterator<Entry<Integer,Integer>> it = produtos.iterator();
				while(it.hasNext()){
					Entry<Integer, Integer> produto = it.next();
					int idProduto = produto.getKey();
					int qntProduto = produto.getValue();
					out.println("<tr>");
					out.println("<td>" + idProduto + "<td>");
					out.println("<td>" + qntProduto + "<td>");
					out.println("</tr>");
				}
			}
			else{
				out.println("Não existe produto no carrinho");
			}
		%>
	
	</body>
</html>