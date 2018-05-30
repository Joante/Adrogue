package dao;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.LineaTren;

public class LineaTrenDao {
	
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

		public int agregar(LineaTren objeto) {
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

		public void actualizar(LineaTren objeto) throws HibernateException {
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

		public void eliminar(LineaTren objeto) throws HibernateException {
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

		public LineaTren traerLineaTren(long idLineaTren) throws HibernateException {
			LineaTren objeto = null;
			try {
				iniciaOperacion();
				objeto = (LineaTren) session.get(LineaTren.class, idLineaTren);
			}
			finally {
				session.close();
			}
			return objeto;
		}
}

