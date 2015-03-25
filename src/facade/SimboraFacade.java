package facade;

import com.excessoes.CaronaException;
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
	
	public int abrirSessao(String login, String senha) throws UsuarioException{
		return simboraEasyAccept.abrirSessao(login, senha);
	}

	public String getAtributoUsuario(String login, String atributo) throws UsuarioException{
		return simboraEasyAccept.getAtributoUsuario(login, atributo);
	}
	
	public void encerrarSistema(){
		simboraEasyAccept.encerrarSistema();
	}
		
	public String localizarCarona(int idSessao, String origem , String destino) throws Exception{
		return simboraEasyAccept.localizarCarona(idSessao, origem, destino);
	} 
	
	public int cadastrarCarona(Integer idSessao, String origem, String destino, String data, String hora, int qtdDeVagas) throws CaronaException{
		if (idSessao.equals(null)) {
			throw new CaronaException("Sessão inválida");
		}
		return simboraEasyAccept.cadastrarCarona(idSessao, origem, destino, data, hora, qtdDeVagas);
	}
	
	public String getAtributoCarona(int idCarona, String atributo){
		return simboraEasyAccept.getAtributoCarona(idCarona, atributo);
	}
	
	public String getTrajeto(int idCarona){
		return simboraEasyAccept.getTrajeto(idCarona);
	}
	
	public String getCarona(int idCarona){
		return simboraEasyAccept.getCarona(idCarona);
	}
	

	public static void main(String[] args) {
		args = new String[] {"facade.SimboraFacade", "scripts/us01.txt", "scripts/us02.txt", "scripts/us03.txt"};
		EasyAccept.main(args); 
	}
}
