package facade;

import java.util.ArrayList;
import java.util.List;

import com.excessoes.UsuarioException;
import com.model.Usuario;

public class UsuarioEasyFacade {
	
	Usuario usuario;
	String mensagemErro = "";
	List<Usuario> usuarios = new ArrayList<>();
	
	public void zerarSistema(){
		
	}

	public void criarUsuario(String login, String senha, String nome, String endereco, String email){
		usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setSenha(senha);
		usuario.setNome(nome);
		usuario.setEndereco(endereco);
		usuario.setEmail(email);
		if(ehUsuarioValido(usuario)){
			usuarios.add(usuario);
		}
		else{
			throw new UsuarioException(mensagemErro);
		}
		
	}
	
	private boolean ehUsuarioValido(Usuario usuario) {
		if(usuario.getLogin().isEmpty()){
			mensagemErro = "Login inválido";
			return false;
		}
		if(usuario.getNome().isEmpty()){
			mensagemErro = "Nome inválido";
			return false;
		}
		if(usuario.getEmail().isEmpty()){
			mensagemErro = "Email inválido";
			return false;
		}
		return true;
	}

	public int abrirSessao(String login, String senha){
		
		for(Usuario usuario : usuarios){
			if(usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)){
				return usuarios.indexOf(usuario);
			}
		}
	
		throw new UsuarioException("Login inválido");
	}

	public String getAtributoUsuario(String login, String atributo){
		for(Usuario usuario : usuarios){
			if(usuario.getLogin().equals(login)){
				switch(atributo){
				case "endereco":
					return usuario.getEndereco();
				case "nome":
					return usuario.getNome();
				case "email":
					return usuario.getEmail();
				}
				return usuario.getNome();
			}
		}
		return "";
	}
	
	public void encerrarSistema(){
		
	}
	
}
