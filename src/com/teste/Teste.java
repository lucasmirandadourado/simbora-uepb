package com.teste;

import com.model.Carona;
import com.model.Caroneiro;
import com.model.Motorista;
import com.model.Trajetoria;

import junit.framework.TestCase;

public class Teste extends TestCase {

	public Teste() {
		Carona carona = new Carona();
		Motorista motorista = new Motorista();
		Trajetoria trajetoria = new Trajetoria();
		Caroneiro caroneiro = new Caroneiro();
		
			carona.criarCarona(motorista, trajetoria);
		
			
		
	}
	
	
}
