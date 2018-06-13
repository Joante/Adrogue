package dao;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.*;



public class MovimientoDao {
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

	public int agregar(Movimiento objeto) {
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

	public void actualizar(Movimiento objeto) throws HibernateException {
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

	public void eliminar(Movimiento objeto) throws HibernateException {
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

	public Movimiento traerMovimiento(long idMovimiento) throws HibernateException {
		Movimiento objeto = null;
		try {
			iniciaOperacion();
			objeto = (Movimiento) session.get(Movimiento.class, idMovimiento);
		}
		finally {
			session.close();
		}
		return objeto;
	}
	@SuppressWarnings("unchecked")
	public List<Movimiento> traerMovimientos(long idTarjeta) throws HibernateException{
		List<Movimiento> lista = null;
		 try {
			 iniciaOperacion();
			 Query query = session.createQuery("from Movimiento c inner join fetch c.tarjeta inner join fetch c.tarifa inner join fetch c.transporte where c.tarjeta="+idTarjeta+"order by fechaHora desc");
			 query.setMaxResults(15);
			 lista = query.list();
		 }
		 finally {
			 session.close();
		 }
		 return lista;
	}
	
	
}
