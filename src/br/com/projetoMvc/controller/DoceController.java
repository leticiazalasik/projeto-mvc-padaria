package br.com.projetoMvc.controller;

import java.util.ArrayList;
import java.util.List;

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

}
