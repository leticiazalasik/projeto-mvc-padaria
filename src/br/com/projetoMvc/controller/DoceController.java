package br.com.projetoMvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.projetoMvc.DAO.DoceDAOImpl;
import br.com.projetoMvc.DAO.GenericDAO;
import br.com.projetoMvc.model.Doce;

public class DoceController {

	Doce doce = null;

	public List<Doce>listarTodos(){ 
		List<Doce>listaProdutos=new ArrayList<Doce>();
		
		try { 
			GenericDAO dao = new DoceDAOImpl(); 
			
			for (Object object : dao.listarTodos()) {
				listaProdutos.add((Doce)object); 
				
			}
		} catch (Exception e) {
			System.out.println("Erro na controller ao listar Produtos");
			e.printStackTrace();
		}
		return listaProdutos; 
	}
	
	public Doce listarPorId (int id) { 
		try { 
			GenericDAO dao = new DoceDAOImpl(); 
			
			Doce doce = (Doce) dao.listaPorId(id); 
			return doce; 
			
	} catch (Exception e){ 
			System.out.println("Erro na controller ao apresentar produto.");
			e.printStackTrace();
			return null; 
			
		}
	}

	
	public void cadastrar (Doce doce) {
		List <Doce> listaDoces = new ArrayList<Doce>();
		
		try { 
			GenericDAO dao = new DoceDAOImpl(); 
			
			if (dao.cadastrar(doce)) {
			JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
		
			} else { 
			JOptionPane.showMessageDialog(null, "Problemas na DAO ao cadastrar produto");
		}
			
	}catch(Exception e) {
		JOptionPane.showMessageDialog(null, "Erro na controller ao casdatrar produto");
		e.printStackTrace();
	}
}
	
	private boolean validarId (int id) { 
		try { 
			GenericDAO dao = new DoceDAOImpl(); 
			Doce doce = (Doce) dao.listaPorId(id);
			
			if (doce==null) { 
				return false; 
			} else { 
				return true; 
			}
		} catch (Exception e) { 
			System.out.println("erro na controller ao excluir produto.");
			e.printStackTrace();
			return false; 
		}
	}
	
	public Boolean excluir (int id) { 
		try { 
			if (!validarId(id)) { 
				return false; 
			} 
			GenericDAO dao = new DoceDAOImpl(); 
	        dao.excluir(id); 
	        return true; 
 
		} catch (Exception e) { 
			System.out.println("Erro ma controller ao Excluir produto.");
			e.printStackTrace();
			return false;
		}
	}
	
	public void alterar (Doce doce){ 

		    try {  
		        GenericDAO dao = new DoceDAOImpl();

		        if (validarId(doce.getId()) == false) {
		            JOptionPane.showMessageDialog(null, "Nenhum produto encontrado para o ID " + doce.getId());
		            JOptionPane.showMessageDialog(null, "Erro ao alterar produto.");
		        } else {
		            if (dao.alterar(doce)) { 
		                JOptionPane.showMessageDialog(null, "Produto alterado com sucesso.");
		            } else { 
		                JOptionPane.showMessageDialog(null, "Erro ao alterar produto.");
		            }
		        }
		    } catch (Exception e) {  
		        System.out.println("Erro no controller ao alterar produto.");
		        e.printStackTrace();
		    }
		}


}

