package facade;

import com.excessoes.CaronaException;
import com.excessoes.SessaoException;
import com.excessoes.UsuarioException;

import easyaccept.EasyAccept;
import easyaccept.SimboraEasyAccept;

public class SimboraFacade {
	
	SimboraEasyAccept simboraEasyAccept = new SimboraEasyAccept();
	
	public void zerarSistema(){
		simboraEasyAccept.zerarSistema();
	}

	public void criarUsuario(String login, String senha, String nome, String endereco, String email) throws UsuarioException{
		simboraEasyAccept.criarUsuario(login, senha, nome, endereco, email);
	}
	
	public String abrirSessao(String login, String senha) throws SessaoException {
		return simboraEasyAccept.abrirSessao(login, senha);
	}

	public String getAtributoUsuario(String login, String atributo) throws UsuarioException{
		return simboraEasyAccept.getAtributoUsuario(login, atributo);
	}
	
	public void encerrarSessao(String login){
		simboraEasyAccept.encerrarSessao(login);
	}
	
	public void encerrarSistema(){
		simboraEasyAccept.encerrarSistema();
	}
		
	public String localizarCarona(String idSessao, String origem , String destino) throws Exception{
		return simboraEasyAccept.localizarCarona(idSessao, origem, destino);
	} 
	
	public String cadastrarCarona(String idSessao, String origem, String destino, String data, String hora, String qtdDeVagas) throws CaronaException{
		return simboraEasyAccept.cadastrarCarona(idSessao, origem, destino, data, hora, qtdDeVagas);
	}
	
	public String getAtributoCarona(String idCarona, String atributo) throws CaronaException{
		return simboraEasyAccept.getAtributoCarona(idCarona, atributo);
	}
	
	public String getTrajeto(String idCarona) throws CaronaException{
		return simboraEasyAccept.getTrajeto(idCarona);
	}
	
	public String getCarona(String idCarona) throws CaronaException{
		return simboraEasyAccept.getCarona(idCarona);
	}
	
	public String sugerirPontoEncontro(String idSessao, String idCarona, String pontos) throws Exception{
		return simboraEasyAccept.sugerirPontoEncontro(idSessao, idCarona, pontos);
	}
	
	public void aceitarSolicitacaoPontoEncontro(String idSessao, String idSolicitacao) throws Exception { 
		simboraEasyAccept.aceitarSolicitacaoPontoEncontro(idSessao, idSolicitacao);		
	}
	
	public String responderSugestaoPontoEncontro(String idSessao,
			String idCarona, String idSugestao, String pontos) throws Exception {
		return simboraEasyAccept.responderSugestaoPontoEncontro(idSessao, idCarona, idSugestao, pontos);
	}
	
	public String solicitarVagaPontoEncontro(String idSessao, String idCarona, String ponto) {
		return simboraEasyAccept.solicitarVagaPontoEncontro(idSessao, idCarona, ponto);
	}
	
	public String getAtributoSolicitacao(String idSolicitacao, String atributo) throws CaronaException {
		return simboraEasyAccept.getAtributoSolicitacao(idSolicitacao, atributo);
	}
	
	public void desistirRequisicao(String idSessao, String idCarona, String idSolicitacao) throws Exception{
		simboraEasyAccept.desistirRequisicao(idSessao, idCarona, idSolicitacao);
	}
	
	public String solicitarVaga(String idSessao, String idCarona){
		return simboraEasyAccept.solicitarVaga(idSessao, idCarona);
	}
	
	public void aceitarSolicitacao(String idSessao, String idSolicitacao){
		simboraEasyAccept.aceitarSolicitacao(idSessao, idSolicitacao);
	}
	
	public void rejeitarSolicitacao(String idSessao, String idSolicitacao) throws Exception{
		simboraEasyAccept.rejeitarSolicitacao(idSessao, idSolicitacao);
	}
	

	public static void main(String[] args) {
		args = new String[] {"facade.SimboraFacade", "scripts/us01.txt",
				"scripts/us02.txt", "scripts/us03.txt", "scripts/us04.txt", "scripts/us05.txt"};
		EasyAccept.main(args); 
	}
}
