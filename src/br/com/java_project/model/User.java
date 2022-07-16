package br.com.java_project.model;

public class User {
	
	private int id;
	private String usuario;
	private String login;
	private String senha;
	private String date_cadastro;
	private String date_desativacao;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getDate_cadastro() {
		return date_cadastro;
	}	
	public void setDate_cadastro(String date_cadastro) {
		this.date_cadastro = date_cadastro;
	}

	public String getDate_desativacao() {
		return date_desativacao;
	}
	public void setDate_desativacao(String date_desativacao) {
		this.date_desativacao = date_desativacao;
	}
	
}
