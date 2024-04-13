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
}

