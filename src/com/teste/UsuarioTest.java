package com.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.controller.UsuarioController;
import com.excessoes.UsuarioException;
import com.model.Usuario;

public class UsuarioTest {

	UsuarioController controller;
	Usuario usuario;
	
	
	@Before
	public void test() {
		usuario = new Usuario();
		controller = new UsuarioController();
	}
	
	@Test(expected = UsuarioException.class)
	public void testCriarUsuario(){
		
		controller.criarUsuario("mark", "m@rk", "Mark Zuckerberg", "Palo Alto, California", "mark@facebook.com");
		controller.criarUsuario("steve", "5t3v3", "Steven Paul Jobs", "Palo Alto, California", "jobs@apple.com");
		controller.criarUsuario("bill", "severino", "William Henry Gates III", "Medina, Washington", "billzin@msn.com");
		
		
		controller.criarUsuario("bill", "severino", "William Henry Gates III", "Medina, Washington", "billzin@msn.com");
		
		assertEquals(3, controller.getSize());		
		
	}
	
	
	@Test
	public void testGetAtributoUsuario(){
		
		controller.criarUsuario("mark", "m@rk", "Mark Zuckerberg", "Palo Alto, California", "mark@facebook.com");
		controller.criarUsuario("steve", "5t3v3", "Steven Paul Jobs", "Palo Alto, California", "jobs@apple.com");
		controller.criarUsuario("bill", "severino", "William Henry Gates III", "Medina, Washington", "billzin@msn.com");
		
		assertEquals("Mark Zuckerberg", controller.getAtributoUsuario("mark", "nome"));
		assertEquals("Palo Alto, California", controller.getAtributoUsuario("mark", "endereco"));
				
		assertEquals("William Henry Gates III", controller.getAtributoUsuario("bill", "nome"));
		assertEquals("Medina, Washington", controller.getAtributoUsuario("bill", "endereco"));
		
		
	}
	@Test
	public void testZerarLimparDados(){
		controller.zerarSistema();
		assertEquals(0, controller.getSize());
	}

}
