package DAO;

import java.util.List;

import com.model.Usuario;

public interface UsuarioDao {

	public void save(Usuario usuario);
	public Usuario getUsuario(long id);
	public List<Usuario> list();
	public void remove(Usuario usuario);
	public void update(Usuario usuario);
	 
}
