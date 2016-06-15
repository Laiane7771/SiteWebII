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


@WebServlet("/LoginAdm")
public class LoginAdmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LoginAdmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		String tipo = request.getParameter("tipo");
		
		Usuario user = new Usuario();
		user.setLogin(usuario);
		user.setSenha(senha);
		TipoUsuario tipo1 = new TipoUsuario();
		user.setTipoUsuario(tipo1);
		
		try{
			UsuarioDAO.autentica(user);
			System.out.println(UsuarioDAO.autentica(user)+ "Aqui no login servlet");
			if(user.isAutenticado()){
				request.getSession().setAttribute("usuario", user);
				response.sendRedirect("/Administrador/checkout.jsp");
			}
			else{
				String msg = "Login incorreto";
				request.getSession().setAttribute("msg", msg);
				response.sendRedirect("LoginAdm.jsp");
			}
		}catch(SQLException e){
			System.out.println(""+e.getMessage());
		}
		
	}

}
