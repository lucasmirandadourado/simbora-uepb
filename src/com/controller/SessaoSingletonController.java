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
	 * Aqui esse atributo j� � criado como uma instancia da pr�pria classe j�
	 * que nenhuma classe poder� clama-l�!
	 */
	private static SessaoSingletonController sessaoSingleton = new SessaoSingletonController();

	List<Usuario> listaUsuarios = new ArrayList<Usuario>();
	private HashMap<Sessao, Usuario> listaSessao = new HashMap<Sessao, Usuario>();

	/**
	 * Garantindo que ser� instanciado apenas uma unica vez pela mesma classe!
	 */
	private SessaoSingletonController() {}

	/**
	 *  Ao abrir a sess�o � necess�rio o login e senha do usu�rio. Esse m�todo
	 * retornar� o idSessao que � o login do usu�rio. Caso os parametros tenham sido 
	 * inseridos errados ser� gerado um erro de <b>Usu�rio inexistente</b>
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
			throw new SessaoException("Login inv�lido");
		}
		// Caso tenhar achado o usu�rio dever� retornar o idSessao! 
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
