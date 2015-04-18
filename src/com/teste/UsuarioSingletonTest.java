package com.teste;

import org.junit.Before;
import org.junit.Test;

import com.controller.SessaoSingletonController;
import com.controller.UsuarioController;
import com.excessoes.SessaoException;

public class UsuarioSingletonTest {

	UsuarioController usuario;
	
	@Before
	public void iniciarTest() {
		usuario = new UsuarioController();
		
	}
	
	@Test
	public void test() {
		try {
			SessaoSingletonController.abrirSessao("mark", "m@rk");
		} catch (SessaoException e) {
			e.getCause();
			e.printStackTrace();
		}
		usuario.criarUsuario("mark", "m@rk", "Mark Zuckerberg", "Palo Alto, California", "mark@facebook.com");
		
	}

}
