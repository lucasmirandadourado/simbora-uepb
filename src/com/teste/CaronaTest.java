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
		
		sessaoMark = sessaoController.abrirSessao("mark", "m@rk");
		
		String carona1ID = controller.cadastrarCarona(sessaoMark, "Campina Grande", "João Pessoa", "23/06/2013", "16:00", "3");
		Assert.assertEquals("Campina Grande", controller.getAtributoCarona(carona1ID, "origem"));
		Assert.assertEquals("João Pessoa", controller.getAtributoCarona(carona1ID, "destino"));
		Assert.assertEquals("Campina Grande - João Pessoa", controller.getTrajeto(carona1ID));
		
		String carona2ID = controller.cadastrarCarona(sessaoMark, "Rio de Janeiro", "São Paulo", "31/05/2013", "08:00", "2");
		Assert.assertEquals("31/05/2013", controller.getAtributoCarona(carona2ID, "data"));
		Assert.assertEquals("2", controller.getAtributoCarona(carona2ID, "vagas"));
		
		Assert.assertEquals("{}", controller.localizarCarona(sessaoMark, "São Francisco", "Palo Alto"));
		Assert.assertEquals("{"+carona2ID+"}", controller.localizarCarona(sessaoMark, "Rio de Janeiro", "São Paulo"));
		
		Assert.assertEquals("{"+carona1ID+"}", controller.localizarCarona(sessaoMark, "", "João Pessoa"));	
		
	}

}
