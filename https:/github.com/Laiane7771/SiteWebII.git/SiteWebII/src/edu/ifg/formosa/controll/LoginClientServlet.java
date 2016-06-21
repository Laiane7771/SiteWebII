package edu.ifg.formosa.controll;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ifg.formosa.bd.UsuarioDAO;
import edu.ifg.formosa.model.TipoUsuario;
import edu.ifg.formosa.model.Usuario;


@WebServlet("/loginCliente")
public class LoginClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginClientServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String tipo = request.getParameter("tipo");
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		Usuario user = new Usuario();
		user.setLogin(usuario);
		user.setSenha(senha);
		TipoUsuario tipo1= new TipoUsuario();
		tipo1.setTipo(tipo);
		user.setTipoUsuario(tipo1);
		try {
			user = UsuarioDAO.autentica(user);
			if(user!=null){	
				if(user.isAutenticado()){
					request.getSession().setAttribute("usuario", user); //cria sessão
					response.sendRedirect("index.jsp"); //mostra resposta
					
				}
				else{
					String msg = "Login incorreto";
					request.getSession().setAttribute("msg",msg);
					response.sendRedirect("Login.jsp");
				}
			}
			else{
				String msg = "Login incorreto";
				request.getSession().setAttribute("msg",msg);
				response.sendRedirect("Login.jsp");
			}
		}catch (SQLException e) {
			System.out.println(""+e.getMessage());
		}
	}
}
