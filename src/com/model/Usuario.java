package com.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Usuário básico. Ele tem como funções: 
 * <li>logar ao sistema</li>
 * <li>buscar carona</li>
 * <li>solicitar carona</li>
 * <li>sugerir local da carona</li>
 * 
 * @author Lucas Miranda
 * @author Bruno José Clementino
 *
 */

@Entity
@Table(name="USUARIO")
public class Usuario implements Serializable{

	@Id
	@Column(name = "login")
	private String login;
	private String senha;
	private String nome;
	private String endereco;
	private String email;

	/** 
	 * Método contrutor Default.
	 */
	public Usuario() {
		// TODO Auto-generated constructor stub
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
