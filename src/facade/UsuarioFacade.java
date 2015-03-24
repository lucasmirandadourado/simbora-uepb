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
		this.setSenha(senha);
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UsuarioEasyFacade getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEasyFacade usuario) {
		this.usuario = usuario;
	}
}
