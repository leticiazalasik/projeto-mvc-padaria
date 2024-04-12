package br.com.projetoMvc.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.projetoMvc.model.Produto;
import br.com.projetoMvc.util.ConnectionFactory;

public class ProdutoDAOImpl implements GenericDAO{
	
	private Connection conn; 
	public ProdutoDAOImpl() throws Exception { 
		
		try { 
			this.conn=ConnectionFactory.getConnection();
			System.out.println("Conectado com sucesso!");
		} catch (Exception ex) {
				throw new Exception (ex.getMessage()); 
			}
		}

//	@Override
//	public List<Object> listarTodos() {
//		List <Object> lista = new ArrayList<Object>();
//		PreparedStatement stmt = null; 
//		ResultSet rs = null; 
//		
//		String sql = "SELECT * FROM produto ORDER BY descricao"; 
//		
//		try { 
//			stmt=conn.prepareStatement(sql);
//			rs = stmt.executeQuery();
//			while (rs.next()) {
//				Produto produto = new Produto(); 
//				produto.setId(rs.getInt("id"));
//				produto.setDescricao(rs.getString("descricao"));
//				lista.add(produto); 
//			}
//		} catch (SQLException ex) { 
//			System.out.println("Problemas na DAO ao listar produto! Erro: " + ex.getMessage());
//			ex.printStackTrace();
//		} finally { 
//			try { 
//				ConnectionFactory.closeConnection(conn,stmt,rs);
//			} catch (Exception ex) { 
//				System.out.println("Problemas ao fechar a conexão! Erro: " + ex.getMessage());
//			}
//		}
//		return lista; 
//	}


	@Override
	public Object listaPorId(int id) {

		PreparedStatement stmt = null; 
		Produto produto = null; 
		ResultSet rs=null; 
		
		String sql = "SELECT * FROM produto WHERE id= "+ "(?)"; 
	try { 	
		stmt = conn.prepareStatement(sql); 
		stmt.setInt(1, id);
		stmt.executeQuery();
		rs=stmt.executeQuery(); 
		
		if (rs.next()) { 
			produto = new Produto (rs.getInt("id"), rs.getString("descricao")); 
	 		JOptionPane.showMessageDialog(null, "Produto localizado!");
		}
	} catch (SQLException ex){
System.out.println("Problemas na DAO, Erro: " + ex.getMessage());
		ex.printStackTrace();
		} finally { 
			try { 
				ConnectionFactory.closeConnection(conn, stmt, rs);
			} catch (Exception ex) { 
				System.out.println("Problemas ao fechar conexão! Erro: " + ex.getMessage());
			}
		
	}
		
	return produto; 
	
	}

	@Override
	public Boolean cadastrar(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean alterar(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(int id) {
		// TODO Auto-generated method stub
		
	}

}
