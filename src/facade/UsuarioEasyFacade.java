package facade;

import com.model.Usuario;

public class UsuarioEasyFacade {
	
	Usuario usuario;
	
	public void zerarSistema(){
		
	}

	public void criarUsuario(String login, String senha, String nome, String endereco, String email){
		usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setSenha(senha);
		usuario.setNome(nome);
		usuario.setEndereco(endereco);
		usuario.setEmail(email);
		
	}
	
	
}
