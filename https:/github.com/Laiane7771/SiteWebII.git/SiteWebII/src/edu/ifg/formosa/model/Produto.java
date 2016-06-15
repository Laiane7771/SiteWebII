package edu.ifg.formosa.model;

import java.io.FileInputStream;
import java.io.InputStream;

public class Produto {
	
	private int idProduto;
	private int qtdEstoque;
	private String descricao;
	private String nome;
	private double valor;
	private double valor_anterior;
	private SubCategoria subCategoria;
	private Imagem image = new Imagem();
	
	

	public Imagem getImage() {
		return image;
	}
	public void setImage(Imagem image) {
		this.image = image;
	}
	public SubCategoria getSubCategoria() {
		return subCategoria;
	}
	public void setSubCategoria(SubCategoria subCategoria) {
		this.subCategoria = subCategoria;
	}
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public int getQtdEstoque() {
		return qtdEstoque;
	}
	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public double getValor_anterior() {
		return valor_anterior;
	}
	public void setValor_anterior(double valor_anterior) {
		this.valor_anterior = valor_anterior;
	}
	
	

}
