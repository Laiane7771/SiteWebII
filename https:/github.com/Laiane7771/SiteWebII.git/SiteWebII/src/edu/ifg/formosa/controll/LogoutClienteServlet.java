package edu.ifg.formosa.controll;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Cliente/logoutCliente")
public class LogoutClienteServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public LogoutClienteServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			request.getSession().invalidate();
			response.sendRedirect("../index.jsp");
	}
}