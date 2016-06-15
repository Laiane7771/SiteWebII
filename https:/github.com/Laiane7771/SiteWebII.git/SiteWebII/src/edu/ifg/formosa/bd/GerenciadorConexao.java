package edu.ifg.formosa.bd;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

import edu.ifg.formosa.model.ConexaoModelo;


public class GerenciadorConexao {
	
	private static ConexaoModelo mc;
	
	public static void setConexaoModelo(ConexaoModelo mc){
		GerenciadorConexao.mc = mc;
	}
	
	public static Connection pegaConexao(){
		Connection conn = null;
		try{
			Class.forName("org.postgresql.Driver");
		
		System.out.println(	conn = DriverManager.getConnection("jdbc:"+mc.getDb()+":"
				+ "//"+mc.getHost()+":"+mc.getPorta()+"/"+ mc.getNomeDB(),mc.getUsuario(), mc.getSenha()));
			System.out.println("Finalizando conexao com o BD");
			System.out.println("Conectado? "+ !conn.isClosed());
		}catch(ClassNotFoundException e){
			System.out.println(e.getMessage());
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return conn;
	}
}
