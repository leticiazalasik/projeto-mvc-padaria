package br.com.projetoMvc;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.projetoMvc.controller.ProdutoController;
import br.com.projetoMvc.model.Produto;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//testando o listar todos 
		ProdutoController controller = new ProdutoController(); 
		
		System.out.println("- Lista de produtos -");
		List <Produto>lista = new ArrayList<Produto>();
		lista = controller.listarTodos(); 
		
		for (Produto produto : lista) {
			System.out.print(produto.getId());
			System.out.print("-");
			System.out.println(produto.getDescricao());
		}
		
		
		int opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite o id: ")); 
		
		Produto produtoEncontrado = controller.listarPorId(opcao);

		if (produtoEncontrado != null) {
			String mensagemLista2=" "
					.concat("Id: ") 
					.concat(String.valueOf(produtoEncontrado.getId())) //concat só recebe string entao preciso converter 
					.concat("\n")
					.concat("Descrição: ")
					.concat(produtoEncontrado.getDescricao()); 
			
			JOptionPane.showMessageDialog(null, mensagemLista2);
		} else {
			JOptionPane.showMessageDialog(null, "Não existe produto com esse código na lista");
		}
		
		
	}

}
