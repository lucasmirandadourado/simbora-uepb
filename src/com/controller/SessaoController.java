package com.controller;

import java.util.ArrayList;
import java.util.List;

import com.excessoes.SessaoException;
import com.model.Sessao;
import com.model.Usuario;

/**
 * Controla a {@link Sessao}. Métodos: <li>abrirSessao</li> <li></li>
 * 
 * @author Lucas Miranda e Bruno Clementino
 *
 */
public class SessaoController {

	private static List<Sessao> sessoes = new ArrayList<Sessao>();
	/**
	 * Foi necessario colocar <code>static</code> para não ser necessário
	 * instanciar outra {@link List}.
	 */
	private static List<Usuario> usuarios = new ArrayList<>();

	/**
	 * Ao abrir a sessão é necessário o login e senha do usuário. Esse metodo
	 * retornará o idSessao que é o login do usuário. Caso os parametros tenham
	 * sido inseridos errados será gerado um erro de <b>Usuário inexistente</b>
	 *
	 * <br>
	 * @see {@link Usuario}
	 * 
	 * @param login
	 * @param senha
	 * @return
	 * @throws SessaoException
	 *
	 */
	public String abrirSessao(String login, String senha)
			throws SessaoException {
		for (Usuario usuario : usuarios) {
			if (usuario.getLogin().equals(login)
					&& usuario.getSenha().equals(senha)) {
				Sessao ss = new Sessao();
				ss.setIdSessao(usuario.getLogin());
				ss.setIdUsuario(login);
				sessoes.add(ss);
				return ss.getIdSessao();
			} else if (login == null || login.isEmpty()
					|| usuario.getLogin().equals(login)
					|| usuario.getSenha().equals(senha)) {
				throw new SessaoException("Login inválido");
			}
		}
		throw new SessaoException("Usuário inexistente");
	}

	public void encerrarSessao(String login) {
		for (Usuario usuario : usuarios) {
			if (usuario.getLogin().equals(login)) {
				sessoes.remove(usuario); // Não deveria retirar o usuário da
											// sessao?
				// usuarios.remove(usuario); // Remover o usuário seria tirar
				// ele do cadastro não seria???
				break;
			}
		}
	}

	public static boolean hasSessao(String idSessao) {
		for (Sessao sessao : sessoes) {
			if (sessao.getIdSessao().equals(idSessao)) {
				return true;
			}
		}
		return false;
	}

	public static List<Sessao> getSessoes() {
		return sessoes;
	}

	public void setSessoes(List<Sessao> sessoes) {
		SessaoController.sessoes = sessoes;
	}

	public static List<Usuario> getUsuarios() {
		return usuarios;
	}

	public static void setUsuarios(List<Usuario> usuarios) {
		SessaoController.usuarios = usuarios;
	}

}
