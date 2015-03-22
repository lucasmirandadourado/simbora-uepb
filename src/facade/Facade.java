/**
 * 
 */
package facade;

import com.model.Usuario;

/**
 * @author Lucas Miranda
 *
 */
public class Facade {

	String login, senha, nome, endereco, email;
	UsuarioEasyFacade usuario; 
	
	public Facade(String login, String senha, String nome, String endereco, String email) { 
		this.login = login;
		this.senha = senha; 
		this.nome =nome; 
		this.endereco = endereco; 
		this.email = email;
		
		this.usuario = new UsuarioEasyFacade();
		
		usuario.criarUsuario(login, senha, nome, endereco, email);
	
		this.usuario.abrirSessao(login, senha);
	
		this.usuario.encerrarSistema();
	}
}
