package facade;

import java.util.ArrayList;
import java.util.List;

import com.excessoes.UsuarioException;
import com.model.Usuario;

import controller.UsuarioController;

public class UsuarioEasyFacade {
	
	UsuarioController usuarioController = new UsuarioController();
	
	public void zerarSistema(){
		
	}

<<<<<<< HEAD
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
=======
	public void criarUsuario(String login, String senha, String nome, String endereco, String email){
		usuarioController.criarUsuario(login, senha, nome, endereco, email);
>>>>>>> origin/master
		
	}

<<<<<<< HEAD
	public int abrirSessao(String login, String senha) throws UsuarioException{
		//mensagemErro = "Usuário inexistente";
		for(Usuario usuario : usuarios){
				if( usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)){
					return usuarios.indexOf(usuario);	
				}
				else if(login==null || login.isEmpty() || usuario.getLogin().equals(login) || usuario.getSenha().equals(senha)){
					//mensagemErro = "Login inválido";
					throw new UsuarioException("Login inválido");
				}
		}
	
		throw new UsuarioException("Usuário inexistente");
=======
	public int abrirSessao(String login, String senha){
		return usuarioController.abrirSessao(login, senha);
>>>>>>> origin/master
	}

	public String getAtributoUsuario(String login, String atributo) throws UsuarioException {
		
		
		return usuarioController.getAtributoUsuario(login, atributo);
	}

	public void encerrarSistema(){
		
	}
	
}
