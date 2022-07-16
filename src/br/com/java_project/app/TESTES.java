package br.com.java_project.app;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import br.com.java_project.crud.userCRUD;
import br.com.java_project.model.User;
import br.com.java_project.model.Validacao;

public class TESTES {

	public static void main(String[] args) {
		
		userCRUD userCrud = new userCRUD();
		Validacao validar = new Validacao();
		
		// CREATE
		User user = new User();
		user.setUsuario("andressa");
		user.setLogin("andressa@gmail.com");
		user.setSenha("9411");
		String s = "Vitor0101@".replaceAll("\\s+",""); 
		
		
		// userCrud.saveUser(user);
	
		
		
		// READ
		//validar.Email("vitor");
		/*
		for (User u : userCrud.read()) {
			System.out.println("nome: " + u.getUsuario()+ "\n"+"id: " + u.getId());
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		};
		*/
		
		//UPDATE
		User userUpdate = new User();
		userUpdate.setUsuario("marcelo");
		userUpdate.setLogin("marcelo@gmail.com");
		userUpdate.setSenha("1010");
		userUpdate.setId(7); //numero para puxar usuario no banco
		
		//userCrud.update(userUpdate);
		
		// DELETE
		//userCrud.deleteById(9);
		
		
		
		
	}
}
