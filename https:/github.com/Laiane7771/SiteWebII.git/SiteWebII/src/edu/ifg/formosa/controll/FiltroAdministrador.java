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

@WebFilter("/administrador/*")
public class FiltroAdministrador implements Filter {

   
    public FiltroAdministrador() {
        
    }


	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Object o = ((HttpServletRequest)request).getSession().getAttribute("Administrador");
		if(o!=null){
			Usuario usuario = (Usuario)o;
			if(usuario.isAutenticado() && usuario.getTipoUsuario().equals("Administrador")){
				chain.doFilter(request, response);
			}
			else{
				((HttpServletResponse)response).sendRedirect("../LoginAdm.jsp");
			}
		}
		else{
			((HttpServletResponse)response).sendRedirect("../LoginAdm.jsp");
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
