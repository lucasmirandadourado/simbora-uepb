package com.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.controller.CaronaController;
import com.controller.SessaoSingletonController;
import com.controller.UsuarioController;
import com.excessoes.SessaoException;

public class SolicitacaoCaronaTest {

	UsuarioController usuario;
	SessaoSingletonController sessao;
	CaronaController carona;
	
	@Before
	public void inicializar() {
		
		usuario = new UsuarioController();
		carona = new CaronaController();
	}
	
	@Test
	public void criarUsuarioErro() {
		usuario.criarUsuario("mark", "m@rk", "Mark Zuckerberg", "Palo Alto, California", "mark@facebook.com");

		try {
			Assert.assertEquals("mark", sessao.abrirSessao("mark", "m@rk"));	
		} catch (SessaoException e) {
			assertEquals("Login inválido", e.getMessage());
		}
		
	}
	
	@Test
	public void criarCarona() {
		try {
			assertEquals("", carona.cadastrarCarona("mark", "Campina Grande", "João Pessoa", "22/04/2015", "10:00", "4"));	
		} catch (Exception e) {
			assertEquals("", e.getMessage());
		}
		
	}	
}
