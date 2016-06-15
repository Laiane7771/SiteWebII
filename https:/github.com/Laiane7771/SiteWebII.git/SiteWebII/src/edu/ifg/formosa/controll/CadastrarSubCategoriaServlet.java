package edu.ifg.formosa.controll;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ifg.formosa.bd.SubCategoriaDAO;
import edu.ifg.formosa.model.Categoria;
import edu.ifg.formosa.model.SubCategoria;

@WebServlet("/Administrador/registrarSubCategoria")
public class CadastrarSubCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CadastrarSubCategoriaServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		
		try{
			int categoria = Integer.parseInt(request.getParameter("categorias"));
			String nomeSubCategoria = request.getParameter("nome");
			
			SubCategoria subCategoria = new SubCategoria();
			subCategoria.setNome(nomeSubCategoria);
			Categoria c = new Categoria();
			c.setIdCategoria(categoria);
			subCategoria.setCategoria(c);
			String msg = "";
			boolean S = SubCategoriaDAO.adicionaSubCategoria(subCategoria);
			
			if(S){
				msg = "Subcategoria adicionada com sucesso";
			}else{
				msg = "Subcategoria não adicionada";
			}
			
			response.getWriter().write(msg);
			
			request.getSession().setAttribute("msg", msg);
			
			response.sendRedirect("subCategoria.jsp");
					
		}catch(Exception e){
			//pw.println("erro");
		}
	
	}

}
