package edu.ifg.formosa.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.ifg.formosa.model.Imagem;
import edu.ifg.formosa.model.Produto;



public class ProdutoDAO {
	
	public static boolean adicionaProduto(Produto produto){
		boolean resultado = false;
		String sql = "insert into produto (qtdestoque, idsubcategoria, "
				+ "descricao, nome, valor, valorAnterior, imagem) values "
				+ "(?,?,?,?,?,?,?)";
		try{
			Connection conexao = GerenciadorConexao.pegaConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setInt(1, produto.getQtdEstoque());
			ps.setInt(2, produto.getSubCategoria().getIdSubCategoria());
			ps.setString(3, produto.getDescricao());
			ps.setString(4, produto.getNome());
			ps.setDouble(5, produto.getValor());
			ps.setDouble(6, produto.getValor_anterior());
			ps.setBinaryStream(7, produto.getImage().getImagem());
			
			resultado = ps.executeUpdate()==1?true:false;
			
			ps.close();
			conexao.close();
			
		}catch(Exception e){
			resultado = false;
			System.out.println("Erro ao adicionar produto: " +e.getMessage());
		}
		
		return resultado;
	}

	public static List<Produto> buscaProdutos(){
		List<Produto> produtos = new ArrayList<Produto>();
		
		try{
			Connection con = GerenciadorConexao.pegaConexao();
			PreparedStatement ps = con.prepareStatement("Select * from produto");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Produto p = new Produto();
				p.setNome(rs.getString("nome"));
				p.setDescricao(rs.getString("descricao"));
				p.setQtdEstoque(rs.getInt("qtdEstoque"));
				p.setIdProduto(rs.getInt("idproduto"));
				p.setValor(rs.getDouble("valor"));
				p.setValor_anterior(rs.getDouble("valorAnterior"));
				
				Imagem imagem = new Imagem();
				imagem.setImagem(rs.getBinaryStream(("imagem").length()));
				
				p.setImage(imagem);
				produtos.add(p);
			}
		}catch(Exception e){
			produtos = null;
			System.out.println("Erro ao buscar produto");
		}
		return produtos;
	}
	
	
	public static Produto buscaProduto(int idProduto){
		Produto p = null;
		
		try{
			Connection con = GerenciadorConexao.pegaConexao();
			PreparedStatement ps = con.prepareStatement("Select * from produto where idProduto = ?");
			ps.setInt(1, idProduto);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				p = new Produto();
				p.setNome(rs.getString("nome"));
				p.setDescricao(rs.getString("descricao"));
				p.setQtdEstoque(rs.getInt("qtdEstoque"));
				p.setIdProduto(rs.getInt("idproduto"));
				p.setValor(rs.getDouble("valor"));
				p.setValor_anterior(rs.getDouble("valorAnterior"));
				
				Imagem imagem = new Imagem();
				imagem.setTamanhoImagem(rs.getBytes("imagem").length);
				imagem.setImagem(rs.getBinaryStream("imagem"));
				
				p.setImage(imagem);
				
			}
		}catch(Exception e){
			
			System.out.println("Erro ao buscar produto");
			return null;
		}
		return p;
	}
	public static Produto buscaProdutosPorNome(Produto produto){
		Produto prod = null;
		try{
			Connection con = GerenciadorConexao.pegaConexao();
			PreparedStatement ps = con.prepareStatement("Select * from produto where produto.nome = "+produto.getNome());
			ps.setString(1, produto.getNome());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				prod = new Produto();
				prod.setNome(rs.getString("nome"));
				prod.setDescricao(rs.getString("descricao"));
				prod.setQtdEstoque(rs.getInt("qtdEstoque"));
				prod.setIdProduto(rs.getInt("idProduto"));
				prod.setValor(rs.getDouble("valor"));
				prod.setValor_anterior(rs.getDouble("valorAnterior"));
				
				Imagem imagem = new Imagem();
				imagem.setTamanhoImagem(rs.getBytes("imagem").length);
				imagem.setImagem(rs.getBinaryStream("imagem"));
				
				prod.setImage(imagem);
				
			}
		}catch(Exception e){
			System.out.println("Erro ao buscar produto");
			return null;
		}
		return null;
	}
	
	public static boolean alteraProduto(Produto produto){
		boolean resultado = false;
		String sql= "update produto set imagem=?, qtdEstoque=?, nome=?"
				+ "valor=?, valorAnterior=?, descricao=? where idproduto = "+produto.getIdProduto();
		try{
			
			
		}catch(Exception e){
			
		}
		return true;
	}
}
