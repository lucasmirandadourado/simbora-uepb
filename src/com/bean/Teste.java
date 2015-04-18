package com.bean;

import DAO.UsuarioDaoImp;

import com.model.Usuario;

public class Teste {

	public static void main(String[] args) {
		Usuario usuario = new Usuario();
		usuario.setEmail("lucasmirandadourado@gmail.com");
		usuario.setEndereco("Rua");
		usuario.setLogin("lucas");
		usuario.setNome("Lucas");
		usuario.setSenha("4321");
		new UsuarioDaoImp().save(usuario);
		
		usuario = new UsuarioDaoImp().getUsuario("lucas");
		System.out.println(usuario.getNome());
		System.out.println("Fim");
	}
	
}
