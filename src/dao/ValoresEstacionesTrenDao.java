package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.ValoresEstacionesTren;

public class ValoresEstacionesTrenDao {
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

	public int agregar(ValoresEstacionesTren objeto) {
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

	public void actualizar(ValoresEstacionesTren objeto) throws HibernateException {
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

	public void eliminar(ValoresEstacionesTren objeto) throws HibernateException {
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

	public ValoresEstacionesTren traerValoresEstacionesTren(long idValoresEstacionesTren) throws HibernateException {
		ValoresEstacionesTren objeto = null;
		try {
			iniciaOperacion();
			objeto = (ValoresEstacionesTren) session.get(ValoresEstacionesTren.class, idValoresEstacionesTren);
		}
		finally {
			session.close();
		}
		return objeto;
	}
	
	public ValoresEstacionesTren traerValoresEstacionesTren(int estacionSubida, int estacionBajada) throws HibernateException {
		ValoresEstacionesTren objeto = null;
		try {
			iniciaOperacion();
			objeto = (ValoresEstacionesTren) session.createQuery("from ValoresEstacionesTren c inner join fetch c.seccion where c.estacionSubida="+estacionSubida+"and c.estacionBajada="+estacionBajada).uniqueResult();
		}
		finally {
			session.close();
		}
		return objeto;
	}
}
