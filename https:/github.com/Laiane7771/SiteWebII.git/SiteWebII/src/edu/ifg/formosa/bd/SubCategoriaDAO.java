package edu.ifg.formosa.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ifg.formosa.model.Categoria;
import edu.ifg.formosa.model.SubCategoria;



public class SubCategoriaDAO {
	
	public static boolean adicionaSubCategoria(SubCategoria subCategoria){
		boolean resultado = false;
		String sql = "insert into subcategoria (nome, idcategoria) values (?,?)";
		try{
			Connection conexao = GerenciadorConexao.pegaConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, subCategoria.getNome());
			ps.setInt(2, subCategoria.getCategoria().getIdCategoria());
			resultado = ps.executeUpdate()==1?true:false;
			
			ps.close();
			conexao.close();
			
		}catch(Exception e){
			resultado = false;
			System.out.println("Erro ao adicionar SubCategoria: " +e.getMessage());
		}
		
		return resultado;
	}
	
	public static SubCategoria buscaSubCategoria(SubCategoria sc){
		
		PreparedStatement stmt;
		SubCategoria subCategoria = null;
		try {
			Connection con = GerenciadorConexao.pegaConexao();
			stmt = con.prepareStatement("select * from subcategoria where idsubcategoria = ?");
			stmt.setInt(1, sc.getIdSubCategoria());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {

				subCategoria = new SubCategoria();
				subCategoria.setIdSubCategoria(rs.getInt("idsubcategoria"));
				subCategoria.setNome(rs.getString("nome"));
				Categoria categoria = new Categoria();
				categoria.setIdCategoria(rs.getInt("idcategoria"));
				categoria = CategoriaDAO.buscaCategoria(categoria);
				subCategoria.setCategoria(categoria);
				
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return subCategoria;
		
	}
	
	public static List<SubCategoria> buscaSubCategorias(Categoria categoria){
		PreparedStatement stmt = null;
		List<SubCategoria> subCategorias = new ArrayList<SubCategoria>();
		try {
			Connection con = GerenciadorConexao.pegaConexao();
			stmt = con.prepareStatement("select * from subcategoria where idcategoria=?");
			stmt.setInt(1, categoria.getIdCategoria());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				SubCategoria subCategoria = new SubCategoria();
				subCategoria.setIdSubCategoria(rs.getInt("idSubcategoria"));
				subCategoria.setNome(rs.getString("nome"));
				
				Categoria c = new Categoria();
				c.setIdCategoria(rs.getInt("idCategoria"));
				c = CategoriaDAO.buscaCategoria(c);
				
				subCategoria.setCategoria(c);
				subCategorias.add(subCategoria);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Erro ao buscar subcategorias: " + e.getMessage());
		}
		
		if(subCategorias.isEmpty())
			return null;
		else
			return subCategorias;
	}
	
	public Categoria buscaCategoria(Categoria categoria){
		PreparedStatement stmt = null;
		Categoria category = null;
		try {
			Connection con = GerenciadorConexao.pegaConexao();
			stmt = con.prepareStatement("select * from categoria where idcategoria = ?");
			stmt.setInt(1, categoria.getIdCategoria());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				category = new Categoria();
				category.setIdCategoria(rs.getInt("idCategoria"));
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
	public static boolean alterarSubcategoria(SubCategoria subCategoria){
		boolean resultado = false;
		String sql="update subCategoria set nome=? where idsubcategoria=?";
		try{
			Connection conexao = GerenciadorConexao.pegaConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, subCategoria.getNome());
			ps.setInt(2, subCategoria.getIdSubCategoria());
			resultado = ps.executeUpdate()==1?true:false;
			
			ps.close();
			conexao.close();
		}catch(Exception e){
			resultado = false;
			System.out.println("Erro ao alterar SubCategoria: " +e.getMessage());
		}
		return resultado;
	}
	
	public static boolean excluiSubcategoria(SubCategoria subCategoria){
		boolean resultado = false;
		String sql = "delete from subcategoria where idSubcategoria =?";
		try{
			Connection conexao = GerenciadorConexao.pegaConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, subCategoria.getIdSubCategoria());
			resultado = ps.executeUpdate()==1?true:false;
			
			ps.close();
			conexao.close();
		}catch(Exception e){
			resultado = false;
			System.out.println("Erro ao excluir SubCategoria: " +e.getMessage());
		}
		return resultado;
	}
}