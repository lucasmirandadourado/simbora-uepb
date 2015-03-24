package facade;

public class LocalizarCaronaFacade {

	UsuarioEasyFacade user = new UsuarioEasyFacade();
	LocalizarCaronaFacade localizar = new LocalizarCaronaFacade();
	
	public LocalizarCaronaFacade() {
		
	}
	
	private void zeraSistema() {
		localizar.zeraSistema();
	}
	
	private void criarUsuario(String login, String senha, String nome, String endereco, String email) {
		user.criarUsuario(login, senha, nome, endereco, email);
	}
	
	private void iniciarSessao() {
		

	}
	
	private void localizarCarona() {
		localizar.localizarCarona();
	}
	
	private void cadastrarCarona() {
		localizar.cadastrarCarona();
	}	
}

