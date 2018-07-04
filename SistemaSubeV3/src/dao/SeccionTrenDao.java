package dao;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.SeccionTren;
import datos.Tarifa;

public class SeccionTrenDao {
	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	public int agregar(SeccionTren objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		}
		catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}
		finally {
			session.close();
		}
		return id;
	}

	public void actualizar(SeccionTren objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		}
		catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}
		finally {
			session.close();
		}
	}

	public void eliminar(SeccionTren objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		}
		catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}
		finally {
			session.close();
		}
	}

	public SeccionTren traerSeccionTren(long idSeccionTren) throws HibernateException {
		SeccionTren objeto = null;
		try {
			iniciaOperacion();
			objeto = (SeccionTren) session.get(SeccionTren.class, idSeccionTren);
		}
		finally {
			session.close();
		}
		return objeto;
	}
	public SeccionTren traerMaxima() throws HibernateException {
		SeccionTren objeto = null;
		try {
			iniciaOperacion();
			Query query = session.createQuery("from SeccionTren c order by c.idSeccionTren DESC");
			query.setMaxResults(1);
			objeto = (SeccionTren) query.uniqueResult();
		}
		finally {
			session.close();
		}
		return objeto;
	}
}
