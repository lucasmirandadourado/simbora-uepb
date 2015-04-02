package com.controller;

import java.util.ArrayList;
import java.util.List;

import com.excessoes.UsuarioException;
import com.model.Sessao;
import com.model.Usuario;

public class SessaoController {
	
	List<Sessao> sessoes = new ArrayList<>();
	List<Usuario> usuarios = new ArrayList<>();
	
	public String abrirSessao(String login, String senha) throws UsuarioException{
	
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


}
