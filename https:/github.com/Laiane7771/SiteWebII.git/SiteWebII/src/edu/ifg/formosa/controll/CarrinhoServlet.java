package edu.ifg.formosa.controll;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CarrinhoServlet")
public class CarrinhoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int idProduto = Integer.parseInt(request.getParameter("idProduto"));
		HttpSession session = request.getSession();
		if(session.isNew()){
			HashMap<Integer, Integer> carrinho = new HashMap<Integer, Integer>();
			carrinho.put(idProduto, 1);
			session.setAttribute("carrinho", carrinho);
		}
		else{
			Object o = session.getAttribute("carrinho");

			if(o!=null){
				HashMap<Integer, Integer> carrinho = (HashMap<Integer, Integer>)o;
				if(carrinho.containsKey(idProduto)){
					int quantidade = carrinho.get(idProduto);
					quantidade = quantidade+1;
					carrinho.put(idProduto, quantidade);
				}
				else{
					carrinho.put(idProduto, 1);
				}
				session.setAttribute("carrinho", carrinho);
			}
			else{
				HashMap<Integer, Integer> carrinho = new HashMap<Integer, Integer>();
				carrinho.put(idProduto, 1);
				session.setAttribute("carrinho", carrinho);
			}
		}
	}
}
