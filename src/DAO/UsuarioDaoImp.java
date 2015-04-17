package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtil;

import com.model.Usuario;

public class UsuarioDaoImp implements UsuarioDao{

	@Override
	public void save(Usuario usuario) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(usuario);
		t.commit();
	}

	@Override
	public Usuario getUsuario(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (Usuario) session.load(Usuario.class, id);
	}

	@Override
	public List<Usuario> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from USUARIO").list();
		t.commit();
		return lista;
	}

	@Override
	public void remove(Usuario usuario) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(usuario);
		t.commit();
	}

	@Override
	public void update(Usuario usuario) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(usuario);
		t.commit();
	}
}