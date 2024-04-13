package br.com.projetoMvc;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.projetoMvc.controller.DoceController;
import br.com.projetoMvc.model.Doce;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Criando Menu 
		
		String menu = " "
				.concat(" ** Menu do sistema **\n")
				.concat(" 1- Cadastrar \n")
				.concat(" 2- Listar Todos \n")
				.concat(" 3- Listar Por ID \n")
				.concat(" 4- Editar \n")
				.concat(" 5- Excluir \n")
				.concat(" 6- Finalizar \n")
				.concat(" Digite a opção desejada: \n"); 
		
		String option = JOptionPane.showInputDialog(menu); 
		int optionMenu = Integer.parseInt(option); 
		
		
		
		//testando o listar todos 
		DoceController controller = new DoceController(); 
		
		System.out.println("- Lista de produtos -");
		List <Doce>lista = new ArrayList<Doce>();
		lista = controller.listarTodos(); 
		
		for (Doce doce : lista) {
			System.out.print(doce.getId());
			System.out.print("-");
			System.out.println(doce.getNome());
			System.out.println(doce.getCustoProduto());
			System.out.println(doce.getIsAtivo());
			System.out.println(doce.getMargemLucro());
			System.out.println(doce.getOpcaoTamanho());
			System.out.println("---------");
			
		}
		
		
		int opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite o id: ")); 
		
		Doce 	doceEncontrado = controller.listarPorId(opcao);

		if (doceEncontrado != null) {
			String mensagemLista2=" "
					.concat("Id: ") 
					.concat(String.valueOf(doceEncontrado.getId())) //concat só recebe string entao preciso converter 
					.concat("\n")
					.concat("Descrição: ")
					.concat(doceEncontrado.getNome())
					.concat("\n")
					.concat("Custo do produto: ")
					.concat (String.valueOf(doceEncontrado.getCustoProduto()))
					.concat("\n")
					.concat("Disponível para venda: ")
					.concat(String.valueOf(doceEncontrado.getIsAtivo()))
					.concat("\n")
					.concat("Porcentagem de Lucro: ")
					.concat(String.valueOf(doceEncontrado.getMargemLucro()))
					.concat("\n")
					.concat("Pedaço/inteiro: ")
					.concat(doceEncontrado.getOpcaoTamanho());
			
			JOptionPane.showMessageDialog(null, mensagemLista2);
		} else {
			JOptionPane.showMessageDialog(null, "Não existe produto com esse código na lista");
		}
		
		
	}

}
