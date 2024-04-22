package br.com.projetoMvc;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.projetoMvc.controller.DoceController;
import br.com.projetoMvc.model.Doce;
import br.com.projetoMvc.model.Produto;

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
		
		int option = Integer.parseInt(JOptionPane.showInputDialog(menu));
		DoceController controller = new DoceController(); 

		while (option!=6) { 

		switch (option) { 
		
		case 2: 
		//testando o listar todos 
		
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
		
		option = Integer.parseInt(JOptionPane.showInputDialog(menu));

		break; 
		
		
		case 3: 
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
		
		option = Integer.parseInt(JOptionPane.showInputDialog(menu));

		break; 
		
		case 1: 
//		//Cadastrar novo doce 
		JOptionPane.showMessageDialog(null, "*****\n Cadastro de produto novo: "); 
		Doce doce1 = new Doce(); 
		doce1.setNome(JOptionPane.showInputDialog("Digite o nome: "));
		doce1.setCustoProduto(Double.parseDouble(JOptionPane.showInputDialog("Digite o custo do produto: ")));
		doce1.setIsAtivo(Boolean.parseBoolean(JOptionPane.showInputDialog("Digite se o produto está ativo: ")));
		doce1.setMargemLucro(Double.parseDouble(JOptionPane.showInputDialog("Digite a porcentagem de lucro: ")));
		doce1.setOpcaoTamanho(JOptionPane.showInputDialog("Inteiro/Pedaço: "));

		controller.cadastrar(doce1); 
		
		option = Integer.parseInt(JOptionPane.showInputDialog(menu));

		break; 
		
		case 5: 
//testando o excluir 
	
	int op = Integer.parseInt(JOptionPane.showInputDialog("Digite o id a ser excluído: "));
	
	if (controller.excluir(op)) {
		JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!"); 
	} else { 
		controller.excluir(op); 
		JOptionPane.showMessageDialog(null, "Erro ao excluir produto " + op); 
	}
		

		break; 
		
		case 4: 
			//Alterar 
			op = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do produto que você quer alterar: "));
			

			Doce doceEditado = new Doce(); 
			doceEditado.setId(op);

			String  novoNome  = JOptionPane.showInputDialog("Digite o nome do produto "); 
			doceEditado.setNome(novoNome);
			
			Double custoProdutoEditado= Double.parseDouble(JOptionPane.showInputDialog("Digite o custo do produto: "));
			doceEditado.setCustoProduto(custoProdutoEditado);
			
			Double margemLucroEditada= Double.parseDouble(JOptionPane.showInputDialog("Digite a porctege de margem de lucro: "));
			doceEditado.setMargemLucro(margemLucroEditada); 
			
			Boolean isAtivoEditado= Boolean.parseBoolean(JOptionPane.showInputDialog("O produto está Ativo (true) ou Inativo (false)? "));
			doceEditado.setIsAtivo(isAtivoEditado);
			
			String  opcaoTamnhoEditado  = JOptionPane.showInputDialog("Digite se o produto vendido é em pedaço ou inteiro: "); 
			doceEditado.setOpcaoTamanho(opcaoTamnhoEditado);			
			
			controller.alterar(doceEditado);
			
				
			option = Integer.parseInt(JOptionPane.showInputDialog(menu));

			break; 
			
		case 6: 
			JOptionPane.showMessageDialog(null, "Sistema finalizado!"); 
			
			
			break; 
			
			default: 
				JOptionPane.showMessageDialog(null, "Essa opçao nãso existe, escolha novamente."); 
				option = Integer.parseInt(JOptionPane.showInputDialog(menu));

	
	}

		}
		
	}
}
