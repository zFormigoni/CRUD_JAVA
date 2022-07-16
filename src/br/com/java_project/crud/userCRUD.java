package br.com.java_project.crud;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.java_project.connection.ConnectionDB;
import br.com.java_project.model.User;

public class userCRUD {

	//METODO CREATE
	public void saveUser(User user) {
		String create = "INSERT INTO cadusuarios(dcr_usuario, dcr_login, dcr_senha) VALUES (?,?,?)";
		
		Connection con = null;
		PreparedStatement ptsm = null;
		
		try {
			//Criar conexão com o banco de dados
			con = ConnectionDB.createConnectionToPostgresql();					
			
			//ptsm = (PrepareStatement) con.prepareStatement(create);
			
			//prepareStatement para executar a query
			ptsm = con.prepareStatement(create);
			
			//adiconar valores esperados pela query
			ptsm.setString(1, user.getUsuario());
			ptsm.setString(2, user.getLogin());
			ptsm.setString(3, user.getSenha());
			
			ptsm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			//fechar conexões
			try {
				if (ptsm != null) {
					ptsm.close();
				}
				if (con != null) {
					con.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	//METODO READ
	public List<User> read(){
		
		String read = "SELECT * FROM cadusuarios";
		
		List<User> users = new ArrayList<User>();
		
		Connection con = null;
		PreparedStatement pstm = null;
		//Classe que vai recuperar os dados do banco
		ResultSet rset = null;	
		
		try {
			con  = ConnectionDB.createConnectionToPostgresql();
			pstm = con.prepareStatement(read);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				User user = new User();

				user.setId(rset.getInt("idcadusuario"));					//recuperar o id
				user.setUsuario(rset.getString("dcr_usuario"));				//recuperar o nome
				user.setLogin(rset.getString("dcr_login"));					//recuperar o login
				user.setDate_cadastro(rset.getString("dat_cadastro"));		//recuperar o data de cadastro
				user.setDate_desativacao(rset.getString("dat_desativacao"));//recuperar o data de desativação
				
			
				users.add(user);
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rset != null) {
					rset.close();
				}
				if(pstm != null){
					pstm.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
		return users;
	}

	//METODO UPDATE
	public void update(User user) {
		String update = "UPDATE cadusuarios "
					  + "SET dcr_usuario = ?, dcr_login = ?, dcr_senha = ? " 
					  + "WHERE idcadusuario = ?";
	
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = ConnectionDB.createConnectionToPostgresql();
			pstm = con.prepareStatement(update);
			
			//valores a serem alterados
			pstm.setString(1, user.getUsuario());
			pstm.setString(2, user.getLogin());
			pstm.setString(3, user.getSenha());
			
			//busca o id para ser alterado
			pstm.setInt(4, user.getId());
				
			//executar
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null){
					pstm.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	//METODO DELETE
	public void deleteById(int id) {
		
		String delete = "DELETE FROM cadusuarios WHERE idcadusuario = ?";
		
		Connection con = null;
		PreparedStatement pstm = null;
	
		try {
			con = ConnectionDB.createConnectionToPostgresql();
			pstm = con.prepareStatement(delete);
					
			pstm.setInt(1, id);
			
			pstm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (con != null) {
					con.close();
				}
				if (pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
