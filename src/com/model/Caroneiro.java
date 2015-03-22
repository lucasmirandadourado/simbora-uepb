package com.model;

/**
 * O Caroneiro é o usuário básico. Ele tem como funções de: 
 * Solicitar carona, Sugerir local de encontro, Cancelar carona e Aceitar carona
 * 
 * @author Bruno Clementino, Lucas Miranda
 *
 */
public class Caroneiro extends Usuario {
	
	private String nome;
	private String cpf;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
