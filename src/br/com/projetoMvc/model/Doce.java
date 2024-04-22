package br.com.projetoMvc.model;

public class Doce extends Produto {
	
	private String opcaoTamanho;
	
	

	public Doce() {
		super();
	}

public Doce(int id, String nome, Double custoProduto, Boolean isAtivo, Double margemLucro, String opcaoTamanho) {
		super(id, nome, custoProduto, isAtivo, margemLucro);
		this.opcaoTamanho = opcaoTamanho;
	

		// TODO Auto-generated constructor stub
	}


	public String getOpcaoTamanho() {
		return opcaoTamanho;
	}

	public void setOpcaoTamanho(String opcaoTamanho) {
		this.opcaoTamanho = opcaoTamanho;
	} 
	
	

}
