package modelo.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.configuracion.Conexion;
import modelo.entidades.Ejemplar;
import modelo.entidades.Prestamo;


public class PrestamoDao {


	public static void crearPrestamo(int idPrestamo, Ejemplar ejemplarByIdEjemplar, Ejemplar ejemplarByIdUsuario, Date fechaPrestamo,Date fechaDevolucion) {
	Transaction t =null;
	
	try(Session se= Conexion.obtenerSesion()) {
		t=se.beginTransaction();
		//(int idPrestamo, Ejemplar ejemplarByIdEjemplar, Ejemplar ejemplarByIdUsuario, Date fechaPrestamo,Date fechaDevolucion)
		Prestamo aut=new Prestamo();
		aut.setIdPrestamo(idPrestamo);
		aut.setEjemplarByIdEjemplar(ejemplarByIdEjemplar);
		aut.setEjemplarByIdUsuario(ejemplarByIdUsuario);
		aut.setFechaPrestamo(fechaPrestamo);
		aut.setFechaDevolucion(fechaDevolucion);		
		se.save(aut);		
		t.commit();		
		se.refresh(aut);
		System.out.printf("");
		
	}catch(Exception ex){
		ex.printStackTrace();
		
	}
}
	public static void borrarPrestamo(int idPrestamo, Ejemplar ejemplarByIdEjemplar, Ejemplar ejemplarByIdUsuario, Date fechaPrestamo,Date fechaDevolucion) {
		Transaction t = null;

		try (Session se = Conexion.obtenerSesion()) {
			t = se.beginTransaction();
			//(int idPrestamo, Ejemplar ejemplarByIdEjemplar, Ejemplar ejemplarByIdUsuario, Date fechaPrestamo,Date fechaDevolucion)
			Prestamo aut=new Prestamo();
			aut.setIdPrestamo(idPrestamo);
			aut.setEjemplarByIdEjemplar(ejemplarByIdEjemplar);
			aut.setEjemplarByIdUsuario(ejemplarByIdUsuario);
			//SimpleDateFormat s= new SimpleDateFormat ("dd-MM-yyy");
			aut.setFechaPrestamo(fechaPrestamo);
			aut.setFechaDevolucion(fechaDevolucion);			
			se.delete(aut);
			t.commit();
			System.out.print("El Usuario ha sido borrado");
		} catch (Exception ex) {
			ex.printStackTrace();
			
		}

	}
	public static void modificarPrestam(int idPrestamo, Ejemplar ejemplarByIdEjemplar, Ejemplar ejemplarByIdUsuario, Date fechaPrestamo,Date fechaDevolucion) {
		Transaction t = null;
		try (Session se = Conexion.obtenerSesion()) {
			t = se.beginTransaction();
			//(int idPrestamo, Ejemplar ejemplarByIdEjemplar, Ejemplar ejemplarByIdUsuario, Date fechaPrestamo,Date fechaDevolucion)
			Prestamo aut=new Prestamo();
			aut.setIdPrestamo(idPrestamo);
			aut.setEjemplarByIdEjemplar(ejemplarByIdEjemplar);
			aut.setEjemplarByIdUsuario(ejemplarByIdUsuario);
			aut.setFechaPrestamo(fechaPrestamo);
			aut.setFechaDevolucion(fechaDevolucion);
			se.saveOrUpdate(aut);
			se.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			
		}

	}
	public static void obtenerUsuarioPorId() {
		
    }


}
