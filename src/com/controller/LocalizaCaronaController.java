package com.controller;

import java.util.ArrayList;
import java.util.List;

import com.model.Carona;
/**
 * 
 * @author Lucas Miranda e Bruno Clementino
 *
 */
public class LocalizaCaronaController {

	List<Carona> caronas = new ArrayList<Carona>();
	UsuarioController usuarios = new UsuarioController();
	int sessao;

	public String solicitarVagaPontoEncontro(String idSessao, String idCarona,
			String ponto) {
		
		return "";
	}
}
