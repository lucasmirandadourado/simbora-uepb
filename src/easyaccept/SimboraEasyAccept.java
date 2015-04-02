package easyaccept;

import com.controller.CaronaController;
import com.controller.LocalizaCaronaController;
import com.controller.PontoDeEncontroController;
import com.controller.UsuarioController;
import com.excessoes.CaronaException;
import com.excessoes.UsuarioException;

public class SimboraEasyAccept {

	UsuarioController usuarioController = new UsuarioController();
	CaronaController caronaController = new CaronaController();
	LocalizaCaronaController localizarCarona = new LocalizaCaronaController();
	
	PontoDeEncontroController pontoDeEncontroController = new PontoDeEncontroController();
	
	
	public void zerarSistema() {
		usuarioController.zerarSistema();
		caronaController.zerarSistema();
		pontoDeEncontroController.zerarSistema();
	}

	public void criarUsuario(String login, String senha, String nome, String endereco, String email) throws UsuarioException{
		usuarioController.criarUsuario(login, senha, nome, endereco, email);
	}
	
	public String abrirSessao(String login, String senha) throws UsuarioException{
		return usuarioController.abrirSessao(login, senha);
	}

	public String getAtributoUsuario(String login, String atributo) throws UsuarioException{
		return usuarioController.getAtributoUsuario(login, atributo);
	}
	
	public void encerrarSessao(String login){
		usuarioController.encerrarSessao(login);
	}
	
	public void encerrarSistema(){
		usuarioController.encerrarSistema();
	}
	
	
	//Metodos US02
	
	public String localizarCarona(String idSessao, String origem, String destino) throws Exception {
		return caronaController.localizarCarona(idSessao, origem, destino);
	}
	
	public String cadastrarCarona(String idSessao, String origem, String destino, String data, String hora, String qtdDeVagas) throws CaronaException {
		return caronaController.cadastrarCarona(idSessao, origem, destino, data, hora, qtdDeVagas);
	}
	
	public String getAtributoCarona(String idCarona, String atributo) throws CaronaException{
		return caronaController.getAtributoCarona(idCarona, atributo);
	}
	
	public String getTrajeto(String idCarona) throws CaronaException{
		return caronaController.getTrajeto(idCarona);
	}
	
	public String getCarona(String idCarona) throws CaronaException{
		return caronaController.getCarona(idCarona);
	}
	
	//Metodos US04
	
	public String sugerirPontoEncontro(String idSessao, String idCarona, String pontos){
		return pontoDeEncontroController.sugerirPontoEncontro(idSessao, idCarona, pontos);
	}
	
	
}
