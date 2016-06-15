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


@WebServlet(name = "ImagemProdutoServlet", urlPatterns = { "/imagemProduto" })
public class ImagemProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ImagemProdutoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idProduto = Integer.parseInt(request.getParameter("idProduto"));
		Produto p = ProdutoDAO.buscaProduto(idProduto);
		
		ServletOutputStream out = response.getOutputStream();      
      
	     byte[] buffer = new byte[p.getImage().getTamanhoImagem()];       
	     int bytesread = 0;    
	     while((bytesread = p.getImage().getImagem().read(buffer))!=-1){    
	    	 System.out.println("a");
	         out.write(buffer,0,bytesread);    
	     }    
	     
	     out.flush();    
	     out.close();    
	     p.getImage().getImagem().close(); 
	}

}
