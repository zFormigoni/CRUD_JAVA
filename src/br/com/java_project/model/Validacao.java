package br.com.java_project.model;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.java_project.connection.ConnectionDB;

public class Validacao{
	
	//METODO PARA VALIDAR SENHA
	public boolean Senha(String senha) {
		
		Boolean temCaracter = false;
		Boolean temNumero = false;
		Boolean tamanho = false; 
		
		
		// se tem um numero
        for (int i = 0; i < senha.length(); i++) {
            if (Character.isDigit(senha.charAt(i))) {
            	temNumero = true;
            }
        }
        
        //se tem caracter especial
        for (int i = 0; i < senha.length(); i++) {
            if (!Character.isLetterOrDigit(senha.charAt(i))) {
            	temCaracter = true;
            }
        }
        
        if (senha.length() > 8 && senha.length() < 30) {
        	tamanho = true;
        	
        } 
        if(temCaracter == true && temNumero == true && tamanho == true) {
        	return true;
        }else {
        	return false;
        }
	}


	////METODO PARA VALIDAR LOGIN
	public boolean Email(String email) {
		
		boolean emailUnico = true;
		
		String read = "SELECT * FROM cadusuarios WHERE dcr_login = ?";
		Connection con = null;
		PreparedStatement pstm = null;
		//Classe que vai recuperar os dados do banco
		ResultSet rset = null;	
		User userEmail = new User();
		
		try {
			
			con  = ConnectionDB.createConnectionToPostgresql();
			pstm = con.prepareStatement(read);
			
			pstm.setString(1, email);
			
			
			rset = pstm.executeQuery();
			while (rset.next()) {
				userEmail.setLogin(rset.getString("dcr_login"));
			}
			if (userEmail.getLogin() != null) {
				emailUnico = false;
			}
			
		}catch (Exception e) {
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
		
		System.out.println(emailUnico);
		
		return emailUnico;
	}

}