package edu.ifg.formosa.model;

public class ConexaoModelo {
	
	private String usuario;
	private String senha;
	private String host;
	private String nomeDB;
	private String db;
	private String porta;
	
	public String getPorta() {
		return porta;
	}
	public void setPorta(String porta) {
		this.porta = porta;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getNomeDB() {
		return nomeDB;
	}
	public void setNomeDB(String nomeDB) {
		this.nomeDB = nomeDB;
	}
	public String getDb() {
		return db;
	}
	public void setDb(String db) {
		this.db = db;
	}
	
	

}
