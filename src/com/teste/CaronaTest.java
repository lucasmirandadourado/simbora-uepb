package com.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.controller.CaronaController;
import com.controller.SessaoController;
import com.controller.UsuarioController;
import com.excessoes.CaronaException;
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
		assertEquals("{}", controller.localizarCarona(sessaoMark, "Campina Grande", "João Pessoa"));
		
		assertEquals("{}", controller.localizarCarona(sessaoMark, "São Francisco", "Palo Alto"));
		assertEquals("{}", controller.localizarCarona(sessaoMark, "Rio de Janeiro", "São Paulo"));
		
		sessaoMark = sessaoController.abrirSessao("mark", "m@rk");
		
		String carona1ID = controller.cadastrarCarona(sessaoMark, "Campina Grande", "João Pessoa", "23/06/2013", "16:00", "3");
		assertEquals("Campina Grande", controller.getAtributoCarona(carona1ID, "origem"));
		assertEquals("João Pessoa", controller.getAtributoCarona(carona1ID, "destino"));
		assertEquals("Campina Grande - João Pessoa", controller.getTrajeto(carona1ID));
		
		String carona2ID = controller.cadastrarCarona(sessaoMark, "Rio de Janeiro", "São Paulo", "31/05/2013", "08:00", "2");
		assertEquals("31/05/2013", controller.getAtributoCarona(carona2ID, "data"));
		assertEquals("2", controller.getAtributoCarona(carona2ID, "vagas"));
		
		assertEquals("{}", controller.localizarCarona(sessaoMark, "São Francisco", "Palo Alto"));
		assertEquals("{"+carona2ID+"}", controller.localizarCarona(sessaoMark, "Rio de Janeiro", "São Paulo"));
		
		assertEquals("{"+carona1ID+"}", controller.localizarCarona(sessaoMark, "", "João Pessoa"));	
		
	}
	@Test 
	public void testLocalizarCaronaNull() {
		try {
			assertEquals("{}", controller.localizarCarona(null, "São Francisco", "Palo Alto"));
		} catch (Exception e) {
			new CaronaException("Sessão inválida");			
		}
	}
	
	@Test
	public void testZerarSistema(){
		controller.zerarSistema();
		assertEquals(null, controller.getCarona());
	}
}
