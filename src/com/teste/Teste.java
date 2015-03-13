package com.teste;

import junit.framework.TestCase;

public class Teste extends TestCase {

	public Teste() {
		Carona carona = new Carona();
		Motorista motorista = new Motorista();
		Trajetoria trajetoria = new Trajetoria();
		carona.criarCarona(motorista, trajetoria);
		
	}
	
	
}
