package br.com.projetoMvc.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.projetoMvc.model.Doce;
import br.com.projetoMvc.util.ConnectionFactory;

public class DoceDAOImpl implements GenericDAO{

		
		private Connection conn; 
		public DoceDAOImpl() throws Exception { 
			
			try { 
				this.conn=ConnectionFactory.getConnection();
				System.out.println("Conectado com sucesso!");
			} catch (Exception ex) {
					throw new Exception (ex.getMessage()); 
				}
			}

		@Override
		public List<Object> listarTodos() {
			List <Object> lista = new ArrayList<Object>();
			PreparedStatement stmt = null; 
			ResultSet rs = null; 
			
			String sql = "SELECT * FROM doce ORDER BY id"; 
			
			try { 
				stmt=conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				while (rs.next()) {
					Doce doce = new Doce (); 
					doce.setId(rs.getInt("id"));
					doce.setNome(rs.getString("nome"));
					doce.setCustoProduto(rs.getDouble("custoProduto"));
					doce.setIsAtivo(rs.getBoolean("isAtivo"));
					doce.setMargemLucro(rs.getDouble("margemLucro"));
					doce.setOpcaoTamanho(rs.getString("opcaoTamanho"));
					lista.add(doce); 
				}
			} catch (SQLException ex) { 
				System.out.println("Problemas na DAO ao listar produto! Erro: " + ex.getMessage());
				ex.printStackTrace();
			} finally { 
				try { 
					ConnectionFactory.closeConnection(conn,stmt,rs);
				} catch (Exception ex) { 
					System.out.println("Problemas ao fechar a conexão! Erro: " + ex.getMessage());
				}
			}
			return lista; 
		}


		@Override
		public Object listaPorId(int id) {

			PreparedStatement stmt = null; 
			Doce doce = null; 
			ResultSet rs=null; 
			
			String sql = "SELECT * FROM doce WHERE id= "+ "(?)"; 
		try { 	
			stmt = conn.prepareStatement(sql); 
			stmt.setInt(1, id);
			stmt.executeQuery();
			rs=stmt.executeQuery(); 
			
			if (rs.next()) { 
			doce = new Doce (rs.getInt("id"), rs.getString("nome"), rs.getDouble("custoProduto"), rs.getBoolean("isAtivo"), rs.getDouble("margemLucro"),rs.getString("opcaoTamanho")); 
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
		return doce; 
		
		}

		@Override
		public Boolean cadastrar(Object object) {

		Doce doce = (Doce) object; 
		PreparedStatement stmt = null;
		String sql = "INSERT INTO doce (nome, custoProduto, isAtivo, margemLucro, opcaoTamanho) "
		           + "VALUES (?, ?, ?, ?, ?)";
		
	try { 
		stmt=conn.prepareStatement(sql);
		stmt.setString(1, doce.getNome());
		stmt.setDouble(2, doce.getCustoProduto());
		stmt.setBoolean(3, doce.getIsAtivo());
		stmt.setDouble(4, doce.getMargemLucro());
		stmt.setString(5, doce.getOpcaoTamanho());
		
		stmt.execute();
		return true; 
	} catch (SQLException ex) { 
		System.out.println("Problemas na DAO ao cadastrar produto! Erro: " + ex.getMessage());
		ex.printStackTrace();
		return false; 
		
	} finally { 
		try { 
			ConnectionFactory.closeConnection(conn, stmt);
			} catch (Exception ex) {
				System.out.println("Probelmas ao fechar conexão. Erro: " + ex.getMessage());
			ex.printStackTrace();
			}
	}
		
				
		}
		@Override
		public void excluir(int id) {
		PreparedStatement stmt = null; 
		String sql = "DELETE FROM doce WHERE id= "+ "(?)"; 
		
		try { 
			stmt =conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate(); 
		} catch (SQLException ex) { 
			System.out.println("Problemas na DAO ao excluir produto! Erro: " + ex.getMessage());
			ex.printStackTrace();
		} finally { 
			try { 
				ConnectionFactory.closeConnection(conn, stmt);
			} catch (Exception ex) { 
				System.out.println("Problemas ao fechar conexão! Erro: " + ex.getMessage());
				ex.printStackTrace();
			}
		}
			
		}

		@Override
		public Boolean alterar(Object object) {
			// TODO Auto-generated method stub
			return null;
		}

		
}
