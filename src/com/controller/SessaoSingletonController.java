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

	
	static List<Usuario> listaUsuarios = new ArrayList<Usuario>();
	
	private static HashMap<Sessao, Usuario> listaSessao = new HashMap<Sessao, Usuario>();

	/**
	 * Garantindo que será instanciado apenas uma unica vez pela mesma classe!
	 */
	private SessaoSingletonController() {
	}

	/**
	 * Ao abrir a sessão é necessário o login e senha do usuário. Esse método
	 * retornará o idSessao que é o login do usuário. Caso os parametros tenham
	 * sido inseridos errados será gerado um erro de <b>Usuário inexistente</b>
	 * 
	 * @param login
	 * @param senha
	 * @return
	 * @throws SessaoException
	 */

	public static String abrirSessao(String login, String senha)
			throws SessaoException {
		for (Usuario usuario : listaUsuarios) {
			if (usuario.getLogin().equals(login)
					&& usuario.getSenha().equals(senha)) {
				Sessao ss = new Sessao();
				ss.setIdSessao(usuario.getLogin());
				ss.setIdUsuario(login);
				listaSessao.put(ss, usuario);
				return ss.getIdSessao();
			} else if (login == null || login.isEmpty()
					|| usuario.getLogin().equals(login)
					|| usuario.getSenha().equals(senha)) {
				throw new SessaoException("Login inválido");
			}
		}
		throw new SessaoException("Usuário inexistente");
	}

	/**
	 * Esse método faz uma busca no {@link HashMap} para encontrar o 
	 * usuário com o <code>login</code> correspondente ao usuário. Após 
	 * encontrar será removido, se não encontrar significa que não existe 
	 * nenhum usuário com esse login. 
	 * 
	 * @param login
	 */
	public void encerrarSessao(String login) {
		for (Usuario usuario : listaUsuarios) {
			if (listaSessao.get(usuario).getLogin().equals(login)) {
				listaSessao.remove(usuario);
				break;
			}
		}			
	}
}
