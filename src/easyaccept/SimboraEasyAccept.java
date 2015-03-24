package easyaccept;

import java.util.List;

import com.excessoes.UsuarioException;
import com.model.Carona;

import controller.LocalizaCaronaController;
import controller.UsuarioController;

public class SimboraEasyAccept {

	UsuarioController usuarioController = new UsuarioController();
	// Vou mexer
	LocalizaCaronaController localizarCarona = new LocalizaCaronaController();
	///
	
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
	
	// Metodos US03
	public List<Carona> localizaCarona(int sesao, String origem, String destino) {
		return localizarCarona.localizarCarona(sesao, origem, destino);
	}
	
	public void cadastrarCarona(String origem, String destino, String data, String hora, int vagas) {
		localizarCarona.cadastrarCarona(origem, destino, data, hora, vagas);
	}	
}
