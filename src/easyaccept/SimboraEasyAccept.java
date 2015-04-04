package easyaccept;

import com.controller.CaronaController; 
import com.controller.SessaoController;
import com.controller.SolicitacaoVagaController;
import com.controller.UsuarioController;
import com.excessoes.CaronaException;
import com.excessoes.SessaoException;
import com.excessoes.UsuarioException;
/**
 * 
 * @author Lucas Miranda e Bruno Clementino
 *
 */
public class SimboraEasyAccept {

	UsuarioController usuarioController = new UsuarioController();
	CaronaController caronaController = new CaronaController();
	SessaoController sessaoController = new SessaoController();
	//PontoDeEncontroController pontoDeEncontroController = new PontoDeEncontroController();
	SolicitacaoVagaController solicitacao = new SolicitacaoVagaController();
	
	public void zerarSistema() {
		usuarioController.zerarSistema();
		caronaController.zerarSistema();
		//pontoDeEncontroController.zerarSistema();
	}

	public void criarUsuario(String login, String senha, String nome, String endereco, String email) throws UsuarioException{
		usuarioController.criarUsuario(login, senha, nome, endereco, email);
	}
	
	public String abrirSessao(String login, String senha) throws SessaoException{
		return sessaoController.abrirSessao(login, senha);
	}

	public String getAtributoUsuario(String login, String atributo) throws UsuarioException{
		return usuarioController.getAtributoUsuario(login, atributo);
	}
	
	public void encerrarSessao(String login){
		sessaoController.encerrarSessao(login);
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
		return solicitacao.sugerirPontoEncontro(idSessao, idCarona, pontos);
	}

	public void aceitarSolicitacaoPontoEncontro(String idSessao,
			String idSolicitacao) {
		solicitacao.aceitarSolicitacaoPontoEncontro(idSessao, idSolicitacao);
	}
	
	public String responderSugestaoPontoEncontro(String idSessao,
			String idCarona, String idSugestao, String pontos) {
		return solicitacao.responderSugestaoPontoEncontro(idSessao, idCarona, idSugestao, pontos);
	}
	
	public String solicitarVagaPontoEncontro(String idSessao, String idCarona, String ponto) {
		return solicitacao.solicitarVagaPontoEncontro(idSessao, idCarona, ponto);
	}
	
	public String getAtributoSolicitacao(String idSolicitacao, String atributo) {
		return solicitacao.getAtributoSolicitacao(idSolicitacao, atributo);
	}
	
}
