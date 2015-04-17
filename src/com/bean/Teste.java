package com.bean;

import DAO.UsuarioDaoImp;

import com.model.Usuario;

public class Teste {

	public static void main(String[] args) {
		Usuario usuario = new Usuario();
		usuario.setEmail("Teste");
		usuario.setEndereco("teste");
		usuario.setLogin("bruno");
		usuario.setNome("Bruno");
		usuario.setSenha("1234");
		new UsuarioDaoImp().save(usuario);
		
		usuario = new UsuarioDaoImp().getUsuario("bruno");
		System.out.println(usuario.getNome());
		System.out.println("Fim");
	}
	
}
