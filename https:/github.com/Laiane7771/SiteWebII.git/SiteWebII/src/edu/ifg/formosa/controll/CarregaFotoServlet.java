package edu.ifg.formosa.controll;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ifg.formosa.bd.ProdutoDAO;
import edu.ifg.formosa.model.Produto;


@WebServlet("/carregaFoto")
public class CarregaFotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int codProduto = Integer.parseInt(request.getParameter("codProduto"));
		
		Produto p1 = ProdutoDAO.buscaProduto(codProduto);
		
		ServletOutputStream out = response.getOutputStream();    
		//Produto p = new Produto();
	            
	     byte[] buffer = new byte[ p1.getImage().getTamanhoImagem()];       
	     int bytesread = 0;    
	     while((bytesread = p1.getImage().getImagem().read(buffer))!=-1){    
	         out.write(buffer,0,bytesread);    
	     }    
	     out.flush();    
	     out.close();    
	     p1.getImage().getImagem().close();  
	}
}
