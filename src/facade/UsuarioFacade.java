/**
 * 
 */
package facade;

/**
 * Classe que faz a interface com as Classes do model.
 * @author Lucas Miranda e Bruno Clementino
 *
 */
public class UsuarioFacade {
	
	private String login, senha, nome, endereco, email;
	private UsuarioEasyFacade usuario = null;
	
	public UsuarioFacade(String login, String senha, String nome, String endereco, String email) {
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.usuario = new UsuarioEasyFacade();
	}
	
	public void criarUsuario(String login, String senha, String nome, String endereco, String email) {
		usuario.criarUsuario(login, senha, nome, endereco, email);
	}
	
	public void abrirSessao (String login, String senha) {
		usuario.abrirSessao(login, senha);
	}
	
	public void getAtributoUsuario (String login, String atributo ) {
		usuario.getAtributoUsuario(login, atributo);
	}
	
	public void encerrarSistema () {
		usuario.encerrarSistema();
	}
}
