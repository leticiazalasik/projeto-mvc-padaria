package br.com.projetoMvc.model;

public class Produto {

	private int id; 
	private String nome; 
	private Double custoProduto; 
	private Boolean isAtivo; 
	private Double margemLucro; 
	
	public Produto () {
		
	}
	
	

	public Produto(int id, String nome, Double custoProduto, Boolean isAtivo, double margemLucro) {
		super();
		this.id = id;
		this.nome = nome;
		this.custoProduto = custoProduto;
		this.isAtivo = isAtivo;
		this.margemLucro=margemLucro; 
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getCustoProduto() {
		return custoProduto;
	}

	public void setCustoProduto(Double custoProduto) {
		this.custoProduto = custoProduto;
	}

	public Boolean getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Boolean isAtivo) {
		this.isAtivo = isAtivo;
	}



	public Double getMargemLucro() {
		return margemLucro;
	}



	public void setMargemLucro(Double margemLucro) {
		this.margemLucro = margemLucro;
	}

	
}
