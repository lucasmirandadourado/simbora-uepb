package com.model;

/**
 * Usu�rio b�sico. Ele tem como fun��es: 
 * <br> Logar ao sistema
 * 
 * @author Lucas Miranda
 * @author Bruno Jos� Clementino
 *
 */
public class Usuario {

	private String login;
	private String senha;
	private String nome;
	private String endereco;
	private String email;

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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
