package com.bean;

import utils.HibernateUtil;
import DAO.UsuarioDaoImp;

import com.model.Usuario;

public class Teste {

	public static void main(String[] args) {
		Usuario usuario = new Usuario();
		usuario.setEmail("Teste2");
		usuario.setEndereco("teste2");
		usuario.setLogin("bruno0");
		usuario.setNome("BRUNo");
		usuario.setSenha("99999");
		//new UsuarioDaoImp().update(usuario);
		
		usuario = new UsuarioDaoImp().getUsuario("bruno2");
		System.out.println(usuario.getNome());
		System.out.println("Fim");
		//new UsuarioDaoImp().remove(usuario);
		new UsuarioDaoImp().excluirTudo();
		HibernateUtil.closedSession();
	}
	
	
}
