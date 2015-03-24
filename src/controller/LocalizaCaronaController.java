package controller;

import java.util.ArrayList;
import java.util.List;

import com.model.Carona;
import com.model.Veiculo;

import facade.UsuarioFacade;

/**
 * Localizar carona. Permitir o cadastro de caronas no perfil do usuário.
 * Deve-se informar o local de origem, o local de destino, data, hora de saída e
 * quantidade de vagas disponíveis.
 * 
 * @author Lucas Miranda
 *
 */
public class LocalizaCaronaController {

	Veiculo veiculo;
	String mensagemErro = "";
	List<Carona> carona = new ArrayList<Carona>();
	UsuarioFacade usuarioFacade;
	int sessao;
	
	private void criarUsuario(String login, String senha, String nome, String endereco, String email) {
		usuarioFacade = new UsuarioFacade(login, senha, nome, endereco, email);
	}
	
	private void iniciarSessao(String login, String senha) {
		usuarioFacade.abrirSessao(login, senha);
	}
	
	private boolean localizarCarona(int sessao) {
		for (Carona carona: carona) {
			
		}		
		return false;
	}
	
	private void cadastrarCarona() {
		// TODO Auto-generated method stub

	}
	
	
}

