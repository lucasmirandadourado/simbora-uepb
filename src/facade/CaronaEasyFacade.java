package facade;

import com.excessoes.UsuarioException;

public class CaronaEasyFacade {

	UsuarioEasyFacade usuarioFacade = new UsuarioEasyFacade();
	
	public void zerarSistema(){
		usuarioFacade.zerarSistema();
	}

	public void criarUsuario(String login, String senha, String nome, String endereco, String email) throws UsuarioException{
		usuarioFacade.criarUsuario(login, senha, nome, endereco, email);
		
	}

	public int abrirSessao(String login, String senha) throws UsuarioException{
		return usuarioFacade.abrirSessao(login, senha);
	}

	public void localizarCarona(){
		
	}

	public void encerrarSistema(){
		
	}
}
