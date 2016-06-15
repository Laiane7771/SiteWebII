package edu.ifg.formosa.controll;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/cliente/logoutCliente")
public class LogoutCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LogoutCliente() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			request.getSession().invalidate();
			response.sendRedirect("../index.jsp");
	}
}