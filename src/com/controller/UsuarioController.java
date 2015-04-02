package com.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.excessoes.UsuarioException;
import com.model.Usuario;

public class UsuarioController {
	
	Usuario usuario;
	String mensagemErro = "";
	List<Usuario> usuarios = new ArrayList<>();
	
	public void zerarSistema(){
		usuarios.clear();
	}

	public void criarUsuario(String login, String senha, String nome, String endereco, String email) throws UsuarioException{
		usuario = new Usuario();
			usuario.setLogin(login);
			usuario.setSenha(senha);
			usuario.setNome(nome);
			usuario.setEndereco(endereco);
			usuario.setEmail(email);
		if(ehUsuarioValido(usuario) && ehUsuarioNovo(usuario)){
			usuarios.add(usuario);
		}
		else{
			throw new UsuarioException(mensagemErro);
		}
		
	}
	
	private boolean ehUsuarioNovo(Usuario user) {
		for(Usuario usuario : usuarios){
			if(usuario.getLogin().equals(user.getLogin())){
				mensagemErro="Já existe um usuário com este login";
				return false;
			}
			if(usuario.getEmail().equals(user.getEmail())){
				mensagemErro="Já existe um usuário com este email";
				return false;
			}
		}
		return true;
	}

	private boolean ehUsuarioValido(Usuario usuario) {
		if(usuario.getLogin()==null || usuario.getLogin().isEmpty()){
			mensagemErro = "Login inválido";
			return false;
		}
		if(usuario.getNome()==null || usuario.getNome().isEmpty()){
			mensagemErro = "Nome inválido";
			return false;
		}
		if(usuario.getEmail()==null || usuario.getEmail().isEmpty()){
			mensagemErro = "Email inválido";
			return false;
		}
		return true;
	}

	public String abrirSessao(String login, String senha) throws UsuarioException{
		//mensagemErro = "Usuário inexistente";
		for(Usuario usuario : usuarios){
				if( usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)){
					return usuarios.indexOf(usuario)+"";	
				}
				else if(login==null || login.isEmpty() || usuario.getLogin().equals(login) || usuario.getSenha().equals(senha)){
					//mensagemErro = "Login inválido";
					throw new UsuarioException("Login inválido");
				}
		}
	
		throw new UsuarioException("Usuário inexistente");
	}

	public String getAtributoUsuario(String login, String atributo) throws UsuarioException{
		
		
		if(login==null || login.isEmpty()){
			throw new UsuarioException("Login inválido");
		}
		if(atributo==null || atributo.isEmpty()){
			throw new UsuarioException("Atributo inválido");
		}
		if(!ehLoginExistente(login)){
			throw new UsuarioException("Usuário inexistente");
		}
		if(!ehAtributoExistente(atributo)){
			throw new UsuarioException("Atributo inexistente");
		}
		
		for(Usuario usuario : usuarios){
			if(usuario.getLogin().equals(login)){
				switch(atributo){
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
		if(atributo.equals("nome") || atributo.equals("endereco") || atributo.equals("email")){
			return true;
		}
		return false;
	}

	private boolean ehLoginExistente(String login) {
		for(Usuario usuario : usuarios){
			if( usuario.getLogin().equals(login))
				return true;
	}
		return false;
	}

	public void encerrarSistema(){
		
	}

	public void encerrarSessao(String login) {
		for (Usuario usuario : usuarios) {
			if (usuario.getLogin().equals(login)) {
				usuarios.remove(usuario);
				break;
			}
		}
	}
}
