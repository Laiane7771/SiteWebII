package edu.ifg.formosa.model;



public class SubCategoria {

	private int idSubCategoria;
	private String nome;
	private Categoria categoria;
	
	public int getIdSubCategoria() {
		return idSubCategoria;
	}
	public void setIdSubCategoria(int idSubCategoria) {
		this.idSubCategoria = idSubCategoria;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
}
