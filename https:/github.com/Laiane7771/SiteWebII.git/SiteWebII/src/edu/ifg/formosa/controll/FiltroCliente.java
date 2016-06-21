package edu.ifg.formosa.controll;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ifg.formosa.model.Usuario;

@WebFilter("/Cliente/*")
public class FiltroCliente implements Filter {

  

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		Object o = ((HttpServletRequest)request).getSession().getAttribute("usuario");
		if(o!=null){
			Usuario usuario = (Usuario)o;
		
			if(usuario.isAutenticado() && usuario.getTipoUsuario().getTipo().equals("Cliente")){
				System.out.println("entrou");
				chain.doFilter(request, response); 
				
			}
			else{
				System.out.println("b");
				((HttpServletResponse)response).sendRedirect("../Login.jsp");
				
			}
		}
		else{
			System.out.println("a");
			((HttpServletResponse)response).sendRedirect("../Login.jsp");
		}
		
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
