package easyaccept;

import java.util.List;

import com.excessoes.UsuarioException;
import com.model.Carona;

import controller.CaronaController;
import controller.LocalizaCaronaController;
import controller.UsuarioController;

public class SimboraEasyAccept {

	UsuarioController usuarioController = new UsuarioController();
	
	CaronaController caronaController = new CaronaController();
	
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
	
	
	//Metodos US02
	
	public String localizarCarona(int idSessao, String origem, String destino) throws Exception {
		return caronaController.localizarCarona(idSessao, origem, destino);
	}
	
	public int cadastrarCarona(int idSessao, String origem, String destino, String data, String hora, int qtdDeVagas){
		return caronaController.cadastrarCarona(idSessao, origem, destino, data, hora, qtdDeVagas);
	}
	
	public String getAtributoCarona(int idCarona, String atributo){
		return caronaController.getAtributoCarona(idCarona, atributo);
	}
	
	public String getTrajeto(int idCarona){
		return caronaController.getTrajeto(idCarona);
	}
	
	public String getCarona(int idCarona){
		return caronaController.getCarona(idCarona);
	}
	
	
	
}
