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
	
	public String sugerirPontoEncontro(String idSessao, String idCarona, String pontos){
		return simboraEasyAccept.sugerirPontoEncontro(idSessao, idCarona, pontos);
	}
	

	public static void main(String[] args) {
		args = new String[] {"facade.SimboraFacade", "scripts/us01.txt",
				"scripts/us02.txt", "scripts/us03.txt", "scripts/us04.txt"};
		EasyAccept.main(args); 
	}
}
