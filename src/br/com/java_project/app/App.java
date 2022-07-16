package br.com.java_project.app;

import javax.swing.JOptionPane;

import br.com.java_project.crud.userCRUD;
import br.com.java_project.model.User;
import br.com.java_project.model.Validacao;


public class App {		
	
	
	public static void main(String[] args) {
		userCRUD userCrud = new userCRUD();
		Validacao validar = new Validacao();
		
		//MENU CONSULTA
		//ESCOLHA CRUD
		int menu1 = 0;
		
		while(menu1 > 4 || menu1 < 1) {
		menu1 = Integer.parseInt(JOptionPane.showInputDialog("Bem vindo, "
				+ "\nOpções"
				+ "\nCadastrar Usuario:    1"
				+ "\nConsultar Usuarios:   2"
				+ "\nAtualizar um Usuario: 3"
				+ "\nApagar um Usuario:    4"));
		}
		if (menu1 == 1) {		// CREATE
			User user = new User();
			user.setUsuario(JOptionPane.showInputDialog("Nome do Usuario:"));
			
			//validar login
			String e = "";
			e = (JOptionPane.showInputDialog("Insira um Email:").replaceAll("\\s+",""));
			while(validar.Email(e) != true) {
				e = (JOptionPane.showInputDialog("(este email ja esta em uso)\nInsira um Email: ").replaceAll("\\s+",""));	
			}
				
			// validação de senha
			String s = "";
			s = (JOptionPane.showInputDialog("Insira uma Senha: ").replaceAll("\\s+",""));
			while (validar.Senha(s) != true) {
				s = (JOptionPane.showInputDialog("(a senha deve conter ao menos um numero e um caracter especial)\n"
						+ "Insira uma Senha:  ").replaceAll("\\s+",""));
			}
			
			user.setLogin(e);
			user.setSenha(s);
						
			userCrud.saveUser(user);
			JOptionPane.showMessageDialog(null, "Usuario adicionado ao banco");
			
		}else if(menu1 == 2) {	// READ
			JOptionPane.showMessageDialog(null, "Mostrando usuarios no Console");
			for (User u : userCrud.read()) {
				System.out.println("nome: " + u.getUsuario()+ "\n"+"id: " + u.getId());
				System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			};
			
		}else if (menu1 == 3) {	// UPDATE
			User userUpdate = new User();
			userUpdate.setUsuario(JOptionPane.showInputDialog("Nome do Usuario:"));
			
			
			
			//validar login
			String e = "";
			e = (JOptionPane.showInputDialog("Insira um Email:").replaceAll("\\s+",""));
			while(validar.Email(e) != true) {
				e = (JOptionPane.showInputDialog("(este email ja esta em uso)\nInsira um Email: ").replaceAll("\\s+",""));	
			}
				
			// validação de senha
			String s = "";
			s = (JOptionPane.showInputDialog("Insira uma Senha: ").replaceAll("\\s+",""));
			while (validar.Senha(s) != true) {
				s = (JOptionPane.showInputDialog("(a senha deve conter ao menos um numero e um caracter especial)\n"
						+ "Insira uma Senha:  ").replaceAll("\\s+",""));
			}
			
			userUpdate.setLogin(e);
			userUpdate.setSenha(s);
						
			
			userUpdate.setId(Integer.parseInt(JOptionPane.showInputDialog("Id do usuario que sera alterado"))); //numero para puxar usuario no banco
			
			userCrud.update(userUpdate);
			JOptionPane.showMessageDialog(null, "Usuario alterado");
			
		}else if (menu1 == 4) {	// REMOVE
			userCrud.deleteById(Integer.parseInt(JOptionPane.showInputDialog("Id do usuario que sera apagado")));
			JOptionPane.showMessageDialog(null, "Usuario removido");
			
			
		}
	}	
}
