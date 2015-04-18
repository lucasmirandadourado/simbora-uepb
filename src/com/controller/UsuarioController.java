package com.controller;

import java.util.List;

import org.hibernate.type.TrueFalseType;

import com.excessoes.UsuarioException;
import com.model.Usuario;

public class UsuarioController {

	Usuario usuario;
	String mensagemErro = "";

	/**
	 * Aqui acredito que foi uma paradigma de programa��o bem conhecida para
	 * poder solucionar esse problema. POG (Programa��o Orientada a Gambiarra).
	 * Basicamente o que eu fiz: Como tivemos que criar a Class
	 * {@link SessaoController} ai no metodo {@link SessaoController}
	 */
	List<Usuario> usuarios = SessaoController.getUsuarios();

	// List<Usuario> usuarios = new ArrayList<>();

	public void zerarSistema() {
		usuarios.clear();
	}

	/**
	 * Para criar o usuario, ele faz uma verifica��o se o usu�rio � valido ou n�o 
	 * @param login
	 * @param senha
	 * @param nome
	 * @param endereco
	 * @param email
	 * @throws UsuarioException
	 */
	public void criarUsuario(String login, String senha, String nome,
			String endereco, String email) throws UsuarioException {
		usuario = new Usuario();

		usuario.setLogin(login);
		usuario.setSenha(senha);
		usuario.setNome(nome);
		usuario.setEndereco(endereco);
		usuario.setEmail(email);

		if (ehUsuarioValido(usuario) && ehUsuarioNovo(usuario)) {
			usuarios.add(usuario);
		} else {
			throw new UsuarioException(mensagemErro);
		}
	}

	/**
	 * Percorre a lista de {@link Usuario} e verifica se j� existe um Login ou
	 * email iguais. Caso n�o tenha returna um <code>true</code>.
	 * 
	 * @param user
	 * @return {@link Boolean}
	 */
	private boolean ehUsuarioNovo(Usuario user) {
		for (Usuario usuario : usuarios) {
			if (usuario.getLogin().equals(user.getLogin())) {
				mensagemErro = "J� existe um usu�rio com este login";
				return false;
			}
			if (usuario.getEmail().equals(user.getEmail())) {
				mensagemErro = "J� existe um usu�rio com este email";
				return false;
			}
		}
		return true;
	}

	/**
	 * Verifica se o login, nome e e-mail est�o <code>null</code> ou v�zios.
	 * 
	 * @param usuario
	 * @return
	 */
	private boolean ehUsuarioValido(Usuario usuario) {
		if (usuario.getLogin() == null || usuario.getLogin().isEmpty()) {
			mensagemErro = "Login inv�lido";
			return false;
		}
		if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
			mensagemErro = "Nome inv�lido";
			return false;
		}
		if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
			mensagemErro = "Email inv�lido";
			return false;
		}
		return true;
	}

	public String getAtributoUsuario(String login, String atributo)
			throws UsuarioException {

		if (login == null || login.isEmpty()) {
			throw new UsuarioException("Login inv�lido");
		}
		if (atributo == null || atributo.isEmpty()) {
			throw new UsuarioException("Atributo inv�lido");
		}
		if (!ehLoginExistente(login)) {
			throw new UsuarioException("Usu�rio inexistente");
		}
		if (!ehAtributoExistente(atributo)) {
			throw new UsuarioException("Atributo inexistente");
		}

		for (Usuario usuario : usuarios) {
			if (usuario.getLogin().equals(login)) {
				switch (atributo) {
				case "endereco":
					return usuario.getEndereco();
				case "nome":
					return usuario.getNome();
				case "email":
					return usuario.getEmail();
				}
				return usuario.getNome();
			}
		}
		return "";
	}

	private boolean ehAtributoExistente(String atributo) {
		if (atributo.equals("nome") || atributo.equals("endereco")
				|| atributo.equals("email")) {
			return true;
		}
		return false;
	}

	private boolean ehLoginExistente(String login) {
		for (Usuario usuario : usuarios) {
			if (usuario.getLogin().equals(login))
				return true;
		}
		return false;
	}

	public void encerrarSistema() {

	}

	public int getSize() {
		return usuarios.size();
	}

	/*
	 * public String abrirSessao(String login, String senha) throws
	 * UsuarioException{ //mensagemErro = "Usu�rio inexistente"; for(Usuario
	 * usuario : usuarios){ if( usuario.getLogin().equals(login) &&
	 * usuario.getSenha().equals(senha)){ return usuarios.indexOf(usuario)+""; }
	 * else if(login==null || login.isEmpty() ||
	 * usuario.getLogin().equals(login) || usuario.getSenha().equals(senha)){
	 * //mensagemErro = "Login inv�lido"; throw new
	 * UsuarioException("Login inv�lido"); } }
	 * 
	 * throw new UsuarioException("Usu�rio inexistente"); }
	 */
}
