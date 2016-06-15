package edu.ifg.formosa.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import edu.ifg.formosa.model.Estado;

public class EnderecoDAO {
	
	public static  ArrayList<Estado> buscaEstado(){
		PreparedStatement stmt = null;
		ArrayList<Estado> listEstado = new ArrayList<Estado>();
		
		try {
			Connection con = GerenciadorConexao.pegaConexao();
			stmt = con.prepareStatement("select * from estado");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Estado estado = new Estado();
				estado.setIdEstado(rs.getInt("idEstado"));
				estado.setNomeEstado(rs.getString("nome"));
				listEstado.add(estado);
			}
			rs.close();
			stmt.close();
			
		} catch (SQLException ex) {
			System.out.println("Erro ao buscar categorias: " + ex.getMessage());
		}
		if(listEstado.isEmpty())
			return null;
		else
			return listEstado;
	}
}
