/**
 * 
 */
package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.excessoes.SessaoException;
import com.model.Sessao;
import com.model.Usuario;

/**
 * 
 * @author Lucas Miranda e Bruno Clementino
 *
 */
public class SessaoSingletonController {

	/**
	 * Aqui esse atributo já é criado como uma instancia da própria classe já
	 * que nenhuma classe poderá clama-lá!
	 */
	private static SessaoSingletonController sessaoSingleton = new SessaoSingletonController();

	List<Usuario> listaUsuarios = new ArrayList<Usuario>();
	private HashMap<Sessao, Usuario> listaSessao = new HashMap<Sessao, Usuario>();

	/**
	 * Garantindo que será instanciado apenas uma unica vez pela mesma classe!
	 */
	private SessaoSingletonController() {}

	/**
	 *  Ao abrir a sessão é necessário o login e senha do usuário. Esse método
	 * retornará o idSessao que é o login do usuário. Caso os parametros tenham sido 
	 * inseridos errados será gerado um erro de <b>Usuário inexistente</b>
	 * 
	 * @param login
	 * @param senha
	 * @return
	 * @throws SessaoException
	 */
	public String abrirSessao(String login, String senha) throws SessaoException {
		Usuario usuarioAux = null;
		String idSessao = "";
		if(listaSessao.isEmpty()) {
			throw new SessaoException("Login inválido");
		}
		// Caso tenhar achado o usuário deverá retornar o idSessao! 
		for (int i = 0; i < listaSessao.size(); i++) {
			if (listaSessao.get(i).getLogin().equals(login)) {
				usuarioAux = new Usuario();
				usuarioAux = listaSessao.get(login);
				idSessao = listaSessao.hashCode()+"";
			}
		}
			
		return idSessao;
	}

	public static void main(String[] args) {
		try {
			System.out
					.println(sessaoSingleton.abrirSessao("lucas", "123"));
		} catch (SessaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
