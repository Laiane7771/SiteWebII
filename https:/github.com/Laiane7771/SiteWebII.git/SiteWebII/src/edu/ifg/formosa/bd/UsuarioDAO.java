package edu.ifg.formosa.bd;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.ifg.formosa.model.Cidade;
import edu.ifg.formosa.model.Endereco;
import edu.ifg.formosa.model.Estado;
import edu.ifg.formosa.model.TipoUsuario;
import edu.ifg.formosa.model.Usuario;

public class UsuarioDAO {

	public static Usuario buscaUsuarioPorId(Usuario usuario){

		String sql = "select usuario.idusuario, usuario.nome, usuario.login, usuario.senha, usuario.cpf,"
				+"usuario.rg, usuario.email, estado.nome, estado.idestado, "
				+"endereco.idendereco, endereco.rua, endereco.numero, endereco.bairro,"
				+"endereco.complemento, endereco.cep, cidade.nome, cidade.idcidade from "
				+"usuario inner join endereco  on usuario.idendereco = endereco.idendereco "
				+"inner join cidade on endereco.idcidade = cidade.idcidade "
				+"inner join estado on cidade.idestado = estado.idestado "
				+"where idusuario ="+usuario.getIdUsuario();

		new GerenciadorConexao();
		Connection c = GerenciadorConexao.pegaConexao();

		PreparedStatement ps;
		try {
			ps = c.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Usuario usuarioDB = new Usuario();
				usuarioDB.setLogin(rs.getString("login"));
				usuarioDB.setSenha(rs.getString("senha"));
				TipoUsuario tu = new TipoUsuario();
				tu.setTipo(rs.getString("tipo"));
				usuarioDB.setTipoUsuario(tu);
				if(usuario.getLogin().equals(usuarioDB.getLogin())&& usuario.getSenha().equals(usuarioDB.getSenha())){
					if(usuario.getTipoUsuario().getTipo().equals(usuarioDB.getTipoUsuario().getTipo())){
						usuarioDB.setAutenticado(true);
						return usuarioDB;

					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static Usuario autentica(Usuario usuario) throws SQLException{

		String sql = "select distinct tipoUsuario.tipo, usuario.senha, usuario.login from tipoUsuario"
				+ " inner join usuario on tipoUsuario.idtipoUsuario = usuario.idtipoUsuario";

		new GerenciadorConexao();
		Connection c = GerenciadorConexao.pegaConexao();

		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Usuario usuarioDB = new Usuario();
			usuarioDB.setLogin(rs.getString("login"));
			usuarioDB.setSenha(rs.getString("senha"));
			TipoUsuario tu = new TipoUsuario();
			tu.setTipo(rs.getString("tipo"));
			usuarioDB.setTipoUsuario(tu);
			if(usuario.getLogin().equals(usuarioDB.getLogin())&& usuario.getSenha().equals(usuarioDB.getSenha())){
				if(usuario.getTipoUsuario().getTipo().equals(usuarioDB.getTipoUsuario().getTipo())){
					usuarioDB.setAutenticado(true);
					return usuarioDB;

				}
			}
		}
		return null;
	}

	public static boolean cadastrarUsuario(Usuario usuario){

		Connection con = null;

		try{
			String sql= "insert into estado"
					+ "(nome) values(?)";
			new GerenciadorConexao();
			con = GerenciadorConexao.pegaConexao();
			PreparedStatement stmt = con.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, usuario.getEndereco().getCidade().getEstado().getNomeEstado());
			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();
			int idEstado = 0;
			if(rs.next()){
				idEstado = rs.getInt("idEstado");
			}

			String sql1 = "insert into Cidade(nome, idEstado)values(?,?)";
			stmt = con.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, usuario.getEndereco().getCidade().getNome());
			stmt.setInt(2, idEstado);
			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();
			int idCidade = 0;
			if(rs.next()){
				idCidade = rs.getInt("idCidade");
			}

			String sql2 = "insert into endereco(rua, numero, bairro, complemento, cep, idcidade)values"
					+ "(?,?,?,?,?,?)";
			stmt = con.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, usuario.getEndereco().getRua());
			stmt.setString(2, usuario.getEndereco().getNumero());
			stmt.setString(3, usuario.getEndereco().getBairro());
			stmt.setString(4, usuario.getEndereco().getComplemento());
			stmt.setString(5, usuario.getEndereco().getCep());
			stmt.setInt(6, idCidade);
			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();
			int idEndereco = 0;
			if(rs.next()){
				idEndereco = rs.getInt("idEndereco");
			}
			String tipo = "Cliente";
			String sql3 = "insert into tipousuario(tipo) values(?)";
			stmt = con.prepareStatement(sql3, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, tipo);

			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			int idTipoUsuario = 0;
			if(rs.next()){
				idTipoUsuario = rs.getInt("idTipoUsuario");
			}

			String sql4 = "insert into usuario(nome, login, senha, email, cpf, rg, idTipoUsuario, idEndereco)"
					+ "values(?,?,?,?,?,?,?,?)";
			stmt = con.prepareStatement(sql4);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getLogin());
			stmt.setString(3, usuario.getSenha());
			stmt.setString(4, usuario.getEmail());
			stmt.setString(5, usuario.getCpf());
			stmt.setString(6, usuario.getRg());
			stmt.setInt(7, idTipoUsuario);
			stmt.setInt(8, idEndereco);


			stmt.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			//	throw new RuntimeException("falha ao tentar executar um comando no BD. Verifique sua conexão");
			return false;
		}finally{
			try {
				con.close();
			} catch (Exception e) {
				//throw new RuntimeException("não foi possível fechar a conexão com o BD");
				return false;
			}
		}
		return true;
	}
	public static boolean alteraCidadeUsuario(Cidade cidade){
		boolean resultado = false;
		String sql = "update cidade set nome=? where idcidade=?";
		try{
			Connection conexao = GerenciadorConexao.pegaConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, cidade.getNome());
			ps.setInt(2, cidade.getIdCidade());
			resultado = ps.executeUpdate()==1?true:false;

			ps.close();
			conexao.close();

		}catch(Exception e){
			resultado = false;
			System.out.println("Erro ao alterar cidade: " +e.getMessage());
		}
		return resultado;
	}
	public static boolean alteraEstadoUsuario(Estado estado){
		boolean resultado = false;
		String sql = "update estado set nome=? where idestado=?";
		try{
			Connection conexao = GerenciadorConexao.pegaConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, estado.getNomeEstado());
			ps.setInt(2, estado.getIdEstado());
			resultado = ps.executeUpdate()==1?true:false;

			ps.close();
			conexao.close();

		}catch(Exception e){
			resultado = false;
			System.out.println("Erro ao alterar Estado: " +e.getMessage());
		}

		return resultado;
	}

	public static boolean alteraEnderecoUsuario(Endereco endereco){
		boolean resultado = false;
		String sql = "update endereco set rua=?, numero=?, bairro=?, complemento=?, cep=? where idendereco=?";
		try{
			Connection conexao = GerenciadorConexao.pegaConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, endereco.getBairro());
			ps.setString(2, endereco.getNumero());
			ps.setString(3, endereco.getComplemento());
			ps.setString(4, endereco.getCep());
			ps.setString(5, endereco.getRua());
			resultado = ps.executeUpdate()==1?true:false;

			ps.close();
			conexao.close();

		}catch(Exception e){
			resultado = false;
			System.out.println("Erro ao alterar endereco: " +e.getMessage());
		}
		return resultado;
	}
	public static boolean alteraUsuario(Usuario usuario){
		boolean resultado = false;
		String sql = "update usuario set telefone=?, nome=?, senha=?, email=?, cpf=? ,rg=? where idusuario=?";
		try{
			Connection conexao = GerenciadorConexao.pegaConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, usuario.getTelefone());
			ps.setString(2, usuario.getNome());
			ps.setString(3, usuario.getSenha());
			ps.setString(4, usuario.getEmail());
			ps.setString(5, usuario.getCpf());
			ps.setString(6, usuario.getRg());
			resultado = ps.executeUpdate()==1?true:false;

			ps.close();
			conexao.close();

		}catch(Exception e){
			resultado = false;
			System.out.println("Erro ao alterar usuario: " +e.getMessage());
		}

		return resultado;
	}
}