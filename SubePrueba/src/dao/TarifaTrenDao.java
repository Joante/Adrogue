package dao;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.EstacionTren;
import datos.SeccionTren;
import datos.TarifaTren;

public class TarifaTrenDao {
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

	public int agregar(TarifaTren objeto) {
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

	public void actualizar(TarifaTren objeto) throws HibernateException {
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

	public void eliminar(TarifaTren objeto) throws HibernateException {
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

	public TarifaTren traerTarifaTren(long idTarifaTren) throws HibernateException {
		TarifaTren objeto = null;
		try {
			iniciaOperacion();
			objeto = (TarifaTren) session.get(TarifaTren.class, idTarifaTren);
		}
		finally {
			session.close();
		}
		return objeto;
	}
	public TarifaTren traerSeccion(EstacionTren EstacionSubida, EstacionTren EstacionBajada) {
		TarifaTren c = null;
		try {
			iniciaOperacion();
			c = (TarifaTren) session.createQuery("from TarifaTren c where c.estacionSubida="+EstacionSubida+"and c.estacionBajada="+EstacionBajada);
		}
		finally {
			session.close();
		}
		return c;
	}
}
