package br.com.projetoMvc.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.projetoMvc.DAO.GenericDAO;
import br.com.projetoMvc.DAO.ProdutoDAOImpl;
import br.com.projetoMvc.model.Produto;

public class ProdutoController {
	
	Produto produto = null;

	public List<Produto>listarTodos(){ 
		List<Produto>listaProdutos=new ArrayList<Produto>();
		
		try { 
			GenericDAO dao = new ProdutoDAOImpl(); 
			
			for (Object object : dao.listarTodos()) {
				listaProdutos.add((Produto)object); 
				
			}
		} catch (Exception e) {
			System.out.println("Erro na controller ao listar Produtos");
			e.printStackTrace();
		}
		return listaProdutos; 
	}
	
	public Produto listarPorId (int id) { 
		try { 
			GenericDAO dao = new ProdutoDAOImpl(); 
			
			Produto produto = (Produto) dao.listaPorId(id); 
			return produto; 
			
	} catch (Exception e){ 
			System.out.println("Erro na controller ao apresentar produto.");
			e.printStackTrace();
			return null; 
			
		}
	}
}
