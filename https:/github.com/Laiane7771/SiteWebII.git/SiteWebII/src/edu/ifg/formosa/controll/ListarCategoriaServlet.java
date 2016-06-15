package edu.ifg.formosa.controll;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ifg.formosa.bd.CategoriaDAO;
import edu.ifg.formosa.model.Categoria;

@WebServlet("/Administrador/listarCategorias")
public class ListarCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListarCategoriaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter exibe = response.getWriter();
		ArrayList<Categoria> listaCategoria = CategoriaDAO.buscaCategorias();
		if(listaCategoria !=null){
			Iterator<Categoria> it = listaCategoria.iterator();
			while(it.hasNext()){
				Categoria c = it.next();
				exibe.println("<option value="+c.getIdCategoria() +">" + c.getNomeCategoria() +"</option>");
			}
		}
		else{
			exibe.println("<option> Nenhuma categoria </option>");
		}
	}
}
