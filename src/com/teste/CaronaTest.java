package com.teste;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.controller.CaronaController;
import com.controller.SessaoController;
import com.controller.UsuarioController;
import com.excessoes.SessaoException;
import com.model.Carona;

public class CaronaTest {
	
	Carona carona;
	CaronaController controller;
	UsuarioController usuarioController;
	SessaoController sessaoController;

	@Before
	public void test() {
		carona = new Carona();
		controller=new CaronaController();
		usuarioController=new UsuarioController();
		sessaoController = new SessaoController();
		
		usuarioController.zerarSistema();
	}
	
	@Test
	public void testCadastrarCarona() throws Exception{
		
		usuarioController.criarUsuario("mark", "m@rk", "Mark Zuckerberg", "Palo Alto, California", "mark@facebook.com");
		String sessaoMark = sessaoController.abrirSessao("mark", "m@rk");
		Assert.assertEquals("{}", controller.localizarCarona(sessaoMark, "Campina Grande", "João Pessoa"));
		Assert.assertEquals("{}", controller.localizarCarona(sessaoMark, "São Francisco", "Palo Alto"));
		Assert.assertEquals("{}", controller.localizarCarona(sessaoMark, "Rio de Janeiro", "São Paulo"));
		
	}

}
