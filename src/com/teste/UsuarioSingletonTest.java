package com.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.controller.SessaoSingletonController;
import com.controller.UsuarioController;
import com.excessoes.SessaoException;
import com.excessoes.UsuarioException;

public class UsuarioSingletonTest {

	UsuarioController usuario;

	@Before
	public void iniciarTest() {
		usuario = new UsuarioController();

	}

	@Test
	public void test() {
		// Para garantir que não existira nenhum usuario!
		usuario.zerarSistema();
		// Não foi criado o usuário
		try {
			SessaoSingletonController.abrirSessao("mark", "m@rk");
		} catch (SessaoException er) { 
			assertEquals("Usuário inexistente", er.getMessage());
		}
		
		try {
		usuario.criarUsuario("mark", "m@rk", "Mark Zuckerberg",
				"Palo Alto, California", "mark@facebook.com");
		} catch (UsuarioException user) {
			assertEquals("Já existe um usuário com este login", user.getMessage());
		}
	}
	
	@Test
	public void testCriarUsuario() {

		usuario.criarUsuario("mark", "m@rk", "Mark Zuckerberg",
				"Palo Alto, California", "mark@facebook.com");
		usuario.criarUsuario("steve", "5t3v3", "Steven Paul Jobs",
				"Palo Alto, California", "jobs@apple.com");
		usuario.criarUsuario("bill", "severino", "William Henry Gates III",
				"Medina, Washington", "billzin@msn.com");
		try {
			usuario.criarUsuario("bill", "severino", "William Henry Gates III",
					"Medina, Washington", "billzin@msn.com");
		} catch (UsuarioException e) {
			assertEquals("Já existe um usuário com este login", e.getMessage());
		}
		assertEquals(3, usuario.getSize());

	}
	
	@Test
	public void testGetAtributoUsuario(){
		// Teste em condições perfeitas!
		usuario.zerarSistema();
		usuario.criarUsuario("mark", "m@rk", "Mark Zuckerberg", "Palo Alto, California", "mark@facebook.com");
		usuario.criarUsuario("steve", "5t3v3", "Steven Paul Jobs", "Palo Alto, California", "jobs@apple.com");
		usuario.criarUsuario("bill", "severino", "William Henry Gates III", "Medina, Washington", "billzin@msn.com");
		
		assertEquals("Mark Zuckerberg", usuario.getAtributoUsuario("mark", "nome"));
		assertEquals("Palo Alto, California", usuario.getAtributoUsuario("mark", "endereco"));
				
		assertEquals("William Henry Gates III", usuario.getAtributoUsuario("bill", "nome"));
		assertEquals("Medina, Washington", usuario.getAtributoUsuario("bill", "endereco"));
		
		// Test passagem de parametro errado!
			// login == null
		try {
			assertEquals("", usuario.getAtributoUsuario(null, "nome"));
		} catch (UsuarioException e) {
			assertEquals("Login inválido", e.getMessage());
		}
			// login errado
		try {
			assertEquals("Mark Zuckerberg", usuario.getAtributoUsuario("markk", "nome"));
		} catch (UsuarioException e) {
			assertEquals("Usuário inexistente", e.getMessage());
		}
			// Segundo paramentro errado!
		try {
			assertEquals("Mark Zuckerberg", usuario.getAtributoUsuario("mark", "nombre"));
		} catch (UsuarioException e) {
			assertEquals("Atributo inexistente", e.getMessage());
		}
		
	}
}
