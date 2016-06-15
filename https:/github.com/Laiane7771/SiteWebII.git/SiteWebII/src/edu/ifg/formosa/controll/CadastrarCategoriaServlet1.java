package edu.ifg.formosa.controll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ifg.formosa.bd.CategoriaDAO;
import edu.ifg.formosa.model.Categoria;



@WebServlet("/Administrador/registrarCategoria")
public class CadastrarCategoriaServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CadastrarCategoriaServlet1() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeCategoria = request.getParameter("categorias");
		String descricao = request.getParameter("descricao");
		
		Categoria categoria = new Categoria();
		categoria.setNomeCategoria(nomeCategoria);
		categoria.setDescricao(descricao);
		
		boolean r = CategoriaDAO.adicionaCategoria(categoria);
		String msg = "";
		if(r){
			msg = "Categoria adicionada com sucesso";
		}else{
			msg = "Categoria não adicionada";
		}
		
		response.getWriter().write(msg);
		
		request.getSession().setAttribute("mensagem", msg);
		
		response.sendRedirect("cadastrarCategoria.jsp");
				
	}

}
