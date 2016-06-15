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

    public FiltroCliente() {
       
    }
	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		Object o = ((HttpServletRequest)request).getSession().getAttribute("usuario");
		if(o!=null){
			Usuario usuario = (Usuario)o;
			System.out.println(usuario.isAutenticado()+" "+usuario.getTipoUsuario().getTipo());
			if(usuario.isAutenticado() && usuario.getTipoUsuario().getTipo().equals("Cliente")){
				chain.doFilter(request, response); //permite que a transação siga adiante;
				
			}
			else{
				((HttpServletResponse)response).sendRedirect("../Login.jsp");
				
			}
		}
		else{
			((HttpServletResponse)response).sendRedirect("../Login.jsp");
		}
		chain.doFilter(request, response);
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
