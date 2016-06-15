package edu.ifg.formosa.controll;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import edu.ifg.formosa.bd.ProdutoDAO;
import edu.ifg.formosa.bd.SubCategoriaDAO;
import edu.ifg.formosa.model.Produto;
import edu.ifg.formosa.model.SubCategoria;


/**
 * Servlet implementation class Horas
 */
@WebServlet("/Administrador/cadastrarProduto")
public class CadastrarProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		java.util.Date today = new java.util.Date();
		out.println("<html><body>"+today+"</body></html>");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Produto produto = new Produto();
		try {

			 DiskFileItemFactory factory = new DiskFileItemFactory();
	
			 // Configure a repository (to ensure a secure temp location is used)
			 ServletContext servletContext = this.getServletConfig().getServletContext();
			 File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
			 factory.setRepository(repository);
	
			 // Create a new file upload handler
			 ServletFileUpload upload = new ServletFileUpload(factory);
	
			 List<FileItem> items = null;
			 // Parse the request
			 items = upload.parseRequest(request);
			 
			// Process the uploaded items
			 Iterator<FileItem> iter = items.iterator();
			 while (iter.hasNext()) {
			     FileItem item = iter.next();
			     System.out.println(item.getFieldName() +" "+item.isFormField());
			     if (item.isFormField()) {
			    	 	verificaCampos(item, produto);
			     } else {
				    	 InputStream is = item.getInputStream();
				    	 produto.getImage().setTamanhoImagem((int)item.getSize());
				    	 produto.getImage().setImagem(is);
			     }
			 }
		 
			ProdutoDAO.adicionaProduto(produto);
				 
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
	}
	
	private void verificaCampos(FileItem item, Produto produto){
		
		switch (item.getFieldName()) {
		case "nome":
			produto.setNome(item.getString());		
			break;
		case "descricao":
			produto.setDescricao(item.getString());		
			break;
		case "valor":
			produto.setValor(Double.parseDouble(item.getString()));
			break;
		case "valorAnterior":
			produto.setValor_anterior(Double.parseDouble(item.getString()));
			break;
		case "qntEstoque":
			produto.setQtdEstoque(Integer.parseInt(item.getString()));	
			break;
		case "subcategorias":
			SubCategoria sc = new SubCategoria();
			sc.setIdSubCategoria(Integer.parseInt(item.getString()));
			produto.setSubCategoria(SubCategoriaDAO.buscaSubCategoria(sc));
			break;

		default:
			break;
		}
		
	}

}
