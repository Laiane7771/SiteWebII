package edu.ifg.formosa.controll;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import edu.ifg.formosa.bd.GerenciadorConexao;
import edu.ifg.formosa.model.ConexaoModelo;


public class GerenciadorConexaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		getServletContext().getInitParameter("usuario");
		System.out.println(getServletContext().getInitParameter("usuario"));
		
		ConexaoModelo mc = new ConexaoModelo();
		mc.setUsuario(getServletContext().getInitParameter("usuario"));
		mc.setSenha(getServletContext().getInitParameter("senha"));
		mc.setHost(getServletContext().getInitParameter("host"));
		mc.setNomeDB(getServletContext().getInitParameter("nomeDB"));
		mc.setDb(getServletContext().getInitParameter("db"));
		mc.setPorta(getServletContext().getInitParameter("porta"));
		GerenciadorConexao.setConexaoModelo(mc);
	}



}
