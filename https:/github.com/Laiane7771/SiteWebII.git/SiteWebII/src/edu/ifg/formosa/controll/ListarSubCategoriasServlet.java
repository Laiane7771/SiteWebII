package edu.ifg.formosa.controll;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ifg.formosa.bd.SubCategoriaDAO;
import edu.ifg.formosa.model.Categoria;
import edu.ifg.formosa.model.SubCategoria;


/**
 * Servlet implementation class ListarSubCategoriasServlet
 */
@WebServlet("/listarSubCategorias")
public class ListarSubCategoriasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarSubCategoriasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();

		int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
		Categoria categoria = new Categoria();
		categoria.setIdCategoria(idCategoria);
		List<SubCategoria> listSubCategory = SubCategoriaDAO.buscaSubCategorias(categoria);
		if(listSubCategory == null){
			pw.println("<option>Nenhuma SubCategoria Cadastrada</option>");
		}
		else{
			Iterator<SubCategoria> iteratorSubCategory = listSubCategory.iterator();
			
			while(iteratorSubCategory.hasNext()){
				SubCategoria subCategory = iteratorSubCategory.next();
				pw.println("<option value='"+subCategory.getIdSubCategoria()+"'>"+subCategory.getNome()+"</option>");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
