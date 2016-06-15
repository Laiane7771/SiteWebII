package edu.ifg.formosa.controll;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ifg.formosa.bd.CategoriaDAO;
import edu.ifg.formosa.model.Categoria;

@WebServlet("/Administrador/ListarCategoriasTabela")
public class ListarCategoriasTabelaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ListarCategoriasTabelaServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter exibe = response.getWriter();
		ArrayList<Categoria> listaCategorias = CategoriaDAO.buscaCategorias();
		if(listaCategorias !=null){
			Iterator<Categoria> it = listaCategorias.iterator();
			while(it.hasNext()){
				Categoria c = it.next();
				exibe.println("<td>"+c.getNomeCategoria()+"</td>");
			}
		}
		else{
			exibe.println("Nenhuma categoria cadastrada");
		}
	}

	

}
