package br.com.projetoMvc.model;

public class Doces extends Produto {
	
	private String opcaoTamanho;
	
	

	public Doces(String opcaoTamanho) {
		super();
		this.opcaoTamanho = opcaoTamanho;
	}

	
	public Doces() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Doces(int id, String nome, Double custoProduto, Boolean isAtivo, Double margemLucro) {
		super(id, nome, custoProduto, isAtivo, margemLucro);
		// TODO Auto-generated constructor stub
	}


	public String getOpcaoTamanho() {
		return opcaoTamanho;
	}

	public void setOpcaoTamanho(String opcaoTamanho) {
		this.opcaoTamanho = opcaoTamanho;
	} 
	
	

}
