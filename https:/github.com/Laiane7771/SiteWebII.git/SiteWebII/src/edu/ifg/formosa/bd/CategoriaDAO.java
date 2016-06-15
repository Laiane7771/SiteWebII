package edu.ifg.formosa.bd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ifg.formosa.model.Categoria;


public class CategoriaDAO {
	
	public static boolean adicionaCategoria(Categoria categoria){
		boolean resultado = false;
		String sql = "insert into categoria (nomeCategoria,descricao) values (?,?)";
		try{
			Connection conexao = GerenciadorConexao.pegaConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, categoria.getNomeCategoria());
			ps.setString(2, categoria.getDescricao());
			resultado = ps.executeUpdate()==1?true:false;
			
			ps.close();
			conexao.close();
			
		}catch(Exception e){
			resultado = false;
			System.out.println("Erro ao adicionar categoria: " +e.getMessage());
			System.out.println(categoria.getNomeCategoria() + "" + categoria.getDescricao());
		}
		
		return resultado;
	}
	
	public static boolean alteraCategoria(Categoria categoria){
		boolean resultado = false;
		String sql = "update categoria set nomecategoria=? descricao=? where idcategoria=?";
		try{
			Connection conexao = GerenciadorConexao.pegaConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, categoria.getNomeCategoria());
			ps.setString(2, categoria.getDescricao());
			ps.setInt(3, categoria.getIdCategoria());
			resultado = ps.executeUpdate()==1?true:false;
			
			ps.close();
			conexao.close();
			
		}catch(Exception e){
			resultado = false;
			System.out.println("Erro ao alterar categoria: " +e.getMessage());
		}
		
		return resultado;
	}
	
	public boolean excluiCategoria(Categoria categoria){
		boolean resultado = false;
		String sql = "delete from categoria where idcategoria=?";
		try{
			Connection conexao = GerenciadorConexao.pegaConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, categoria.getIdCategoria());
			resultado = ps.executeUpdate()==1?true:false;
			
			ps.close();
			conexao.close();
			
		}catch(Exception e){
			resultado = false;
			System.out.println("Erro ao excluir categoria: " +e.getMessage());
		}
		
		return resultado;
	}
	
	public static ArrayList<Categoria> buscaCategorias(){
		PreparedStatement stmt = null;
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		try {
			Connection con = GerenciadorConexao.pegaConexao();
			stmt = con.prepareStatement("select * from categoria");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Categoria category = new Categoria();
				category.setIdCategoria(rs.getInt("idcategoria"));
				category.setNomeCategoria(rs.getString("nomeCategoria"));
				categorias.add(category);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Erro ao buscar categorias: " + e.getMessage());
		}
		
		if(categorias.isEmpty())
			return null;
		else
			return categorias;
	}
	
	public static Categoria buscaCategoria(Categoria categoria){
		PreparedStatement stmt = null;
		Categoria category = null;
		try {
			Connection con = GerenciadorConexao.pegaConexao();
			stmt = con.prepareStatement("select * from categoria where idcategoria = ?");
			stmt.setInt(1, categoria.getIdCategoria());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				category = new Categoria();
				category.setIdCategoria(rs.getInt("idcategoria"));
				category.setNomeCategoria(rs.getString("nomeCategoria"));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Erro ao buscar uma categoria: " + e.getMessage());
		}
		
		return category;
	}
	

}