package facade;

import java.util.ArrayList;
import java.util.List;

import com.excessoes.UsuarioException;
import com.model.Usuario;

import controller.UsuarioController;

public class UsuarioEasyFacade {
	
	UsuarioController usuarioController = new UsuarioController();
	
	public void zerarSistema(){
		usuarioController.zerarSistema();
	}

	public void criarUsuario(String login, String senha, String nome, String endereco, String email) throws UsuarioException{

		usuarioController.criarUsuario(login, senha, nome, endereco, email);
		
	}
	
	public int abrirSessao(String login, String senha) throws UsuarioException{

		return usuarioController.abrirSessao(login, senha);
	}

	public String getAtributoUsuario(String login, String atributo) throws UsuarioException{
		
		return usuarioController.getAtributoUsuario(login, atributo);
		
	}
	
	public void encerrarSistema(){
		usuarioController.encerrarSistema();
	}
	
}
