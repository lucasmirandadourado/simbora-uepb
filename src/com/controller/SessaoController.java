package com.controller;

import java.util.ArrayList;
import java.util.List;

import com.excessoes.SessaoException;
import com.model.Sessao;
import com.model.Usuario;

/**
 * Controla a {@link Sessao}. M�todos: <li>abrirSessao</li> <li></li>
 * 
 * @author Lucas Miranda e Bruno Clementino
 *
 */
public class SessaoController {

	List<Sessao> sessoes = new ArrayList<>();
	/**
	 * Foi necessario colocar <code>static</code> para n�o ser necess�rio
	 * instanciar outra {@link List}.
	 */
	private static List<Usuario> usuarios = new ArrayList<>();

	public String abrirSessao(String login, String senha) throws SessaoException {
		for (Usuario usuario : usuarios) {
			if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
				return usuarios.indexOf(usuario) + "";
			} else if (login == null || login.isEmpty()
					|| usuario.getLogin().equals(login)
					|| usuario.getSenha().equals(senha)) {
				// mensagemErro = "Login inv�lido";
				throw new SessaoException("Login inv�lido");
			}
		}
		throw new SessaoException("Usu�rio inexistente");
	}

	public List<Sessao> getSessoes() {
		return sessoes;
	}

	public void setSessoes(List<Sessao> sessoes) {
		this.sessoes = sessoes;
	}

	public static List<Usuario> getUsuarios() {
		return usuarios;
	}

	public static void setUsuarios(List<Usuario> usuarios) {
		SessaoController.usuarios = usuarios;
	}

}
