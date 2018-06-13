package dao;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Tarifa;

public class TarifaDao {
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

	public int agregar(Tarifa objeto) {
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

	public void actualizar(Tarifa objeto) throws HibernateException {
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

	public void eliminar(Tarifa objeto) throws HibernateException {
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

	public Tarifa traerTarifa(long idTarifa) throws HibernateException {
		Tarifa objeto = null;
		try {
			iniciaOperacion();
			objeto = (Tarifa) session.get(Tarifa.class, idTarifa);
		}
		finally {
			session.close();
		}
		return objeto;
	}
	public Tarifa traerUltima() throws HibernateException {
		Tarifa objeto = null;
		try {
			iniciaOperacion();
			Query query = session.createQuery("from Tarifa c order by c.idTarifa DESC");
			query.setMaxResults(1);
			objeto = (Tarifa) query.uniqueResult();
		}
		finally {
			session.close();
		}
		return objeto;
	}

}
