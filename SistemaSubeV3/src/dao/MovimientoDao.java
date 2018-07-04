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
	@SuppressWarnings("unchecked")
	public List<Movimiento> traerMasMovimientos(long idTarjeta, long id) throws HibernateException{
		List<Movimiento> lista = null;
		 try {
			 iniciaOperacion();
			 Query query = session.createQuery("from Movimiento c inner join fetch c.tarjeta inner join fetch c.tarifa inner join fetch c.transporte where c.tarjeta="+idTarjeta+"and c.idMovimiento <"+id+" order by fechaHora desc");
			 query.setMaxResults(15);
			 lista = query.list();
		 }
		 finally {
			 session.close();
		 }
		 return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Movimiento> traerMovimientoTransporte(GregorianCalendar fechaHoraInicio, GregorianCalendar fechaHoraFinal,int tipoTransporte) throws HibernateException {
		List<Movimiento> lista = null;
		try {
			iniciaOperacion();
			String hQL=("from Movimiento m inner join fetch m.tarifa where m.transporte.tipoTransporte=:tipoTransporte and m.fechaHora between :fechaHoraInicio and :fechaHoraFinal");   
			lista=session.createQuery(hQL).setParameter("fechaHoraInicio", fechaHoraInicio).setParameter("fechaHoraFinal", fechaHoraFinal).setParameter("tipoTransporte", tipoTransporte).list();    
		}
		finally {
			session.close();
		}
		return lista;
	}
	@SuppressWarnings("unchecked")
	public List<Movimiento> traerMovimientoTransporteTarjeta(GregorianCalendar fechaHoraInicio, GregorianCalendar fechaHoraFinal,int tipoTransporte, long nroTarjeta) throws HibernateException {
		List<Movimiento> lista = null;
		try {
			iniciaOperacion();
			String hQL=("from Movimiento m inner join fetch m.tarifa inner join fetch m.transporte where m.transporte.tipoTransporte=:tipoTransporte and m.tarjeta.nroTarjeta=:nroTarjeta and m.fechaHora between :fechaHoraInicio and :fechaHoraFinal");   
			lista=session.createQuery(hQL).setParameter("nroTarjeta", nroTarjeta).setParameter("fechaHoraInicio", fechaHoraInicio).setParameter("fechaHoraFinal", fechaHoraFinal).setParameter("tipoTransporte", tipoTransporte).list();    
		}
		finally {
			session.close();
		}
		return lista;
	}
	@SuppressWarnings("unchecked")
	public List<Movimiento> traerMovimientoIdTransporte(GregorianCalendar fechaHoraInicio, GregorianCalendar fechaHoraFinal,long tipoTransporte) throws HibernateException {
		List<Movimiento> lista = null;
		try {
			iniciaOperacion();
			String hQL=("from Movimiento m where m.transporte.idTransporte=:tipoTransporte and m.fechaHora between :fechaHoraInicio and :fechaHoraFinal");   
			lista=session.createQuery(hQL).setParameter("fechaHoraInicio", fechaHoraInicio).setParameter("fechaHoraFinal", fechaHoraFinal).setParameter("tipoTransporte", tipoTransporte).list();    
		}
		finally {
			session.close();
		}
		return lista;
	}
	@SuppressWarnings("unchecked")
	public List<Movimiento> traerMovimientoTramoTransporte(GregorianCalendar fechaHoraInicio, GregorianCalendar fechaHoraFinal,long tipoTransporte,long seccion) throws HibernateException {
		List<Movimiento> lista = null;
		try {
			iniciaOperacion();
			String hQL=("from Movimiento m where m.transporte.idTransporte=:tipoTransporte and m.fechaHora between :fechaHoraInicio and :fechaHoraFinal");   
			lista=session.createQuery(hQL).setParameter("fechaHoraInicio", fechaHoraInicio).setParameter("fechaHoraFinal", fechaHoraFinal).setParameter("tipoTransporte", tipoTransporte).list();    
		}
		finally {
			session.close();
		}
		return lista;
	}
	
	public Movimiento traerUltimo() throws HibernateException{
		Movimiento objeto = null;
		try {
			iniciaOperacion();
			Query query = session.createQuery("from Movimiento c inner join fetch c.tarjeta inner join fetch c.tarifa inner join fetch c.transporte order by fechaHora desc");
			query.setMaxResults(1);
			objeto = (Movimiento) query.uniqueResult();
		}
		finally {
			session.close();
		}
		if(objeto==null) {
			objeto=new Movimiento();
			GregorianCalendar fecha = new GregorianCalendar(1970,1,1);
			objeto.setFechaHora(fecha);
		}
		return objeto;
	}
	
	public Movimiento traerUltimo(Tarjeta tarjeta) throws HibernateException{
		Movimiento objeto = null;
		try {
			iniciaOperacion();
			Query query = session.createQuery("from Movimiento c inner join fetch c.tarjeta p inner join fetch c.tarifa inner join fetch c.transporte where p.nroTarjeta="+tarjeta.getNroTarjeta()+" order by fechaHora desc");
			query.setMaxResults(1);
			objeto = (Movimiento) query.uniqueResult();
		}
		finally {
			session.close();
		}
		if(objeto==null) {
			objeto=new Movimiento();
			GregorianCalendar fecha = new GregorianCalendar(1970,1,1);
			objeto.setFechaHora(fecha);
		}
		return objeto;
	}
	
	public Movimiento traerUltimoRedSube() throws HibernateException{
		Movimiento objeto = null;
		try {
			iniciaOperacion();
			Query query = session.createQuery("from Movimiento c inner join fetch c.tarjeta inner join fetch c.tarifa inner join fetch c.transporte p where not p.idTransporte=12 order by fechaHora desc");
			query.setMaxResults(1);
			objeto = (Movimiento) query.uniqueResult();
		}
		finally {
			session.close();
		}
		if(objeto==null) {
			objeto=new Movimiento();
			GregorianCalendar fecha = new GregorianCalendar(1970,1,1);
			objeto.setFechaHora(fecha);
		}
		return objeto;
	}
	
	public int cantidadDeViajes(long idTransporte) {
		int cantidad=0;
		List<Movimiento> aux = null;
		try {
			iniciaOperacion();
			aux =(List<Movimiento>) session.createQuery("from Movimiento c inner join fetch c.tarjeta inner join fetch c.tarifa inner join fetch c.transporte p where p.idTransporte="+idTransporte).list();
			}
		finally {
			session.close();
		}
		cantidad=aux.size();
		return cantidad;
	}
}
