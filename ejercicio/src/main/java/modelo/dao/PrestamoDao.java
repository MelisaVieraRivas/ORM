package modelo.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.configuracion.Conexion;
import modelo.entidades.Ejemplar;
import modelo.entidades.Prestamo;


public class PrestamoDao {


	public static void crearPrestamo() {
	Transaction t =null;
	
	try(Session se= Conexion.obtenerSesion()) {
		t=se.beginTransaction();
		//(int idPrestamo, Ejemplar ejemplarByIdEjemplar, Ejemplar ejemplarByIdUsuario, Date fechaPrestamo,Date fechaDevolucion)
		Prestamo aut=new Prestamo();
		aut.setIdPrestamo(1);
		aut.setEjemplarByIdEjemplar(Ejemplar);
		aut.setEjemplarByIdUsuario(Usuario);
		SimpleDateFormat s= new SimpleDateFormat ("dd-MM-yyy");
		aut.setFechaPrestamo(s.parse("10-10-2000"));
		aut.setFechaDevolucion(s.parse("10-10-2000"));		
		se.save(aut);		
		t.commit();		
		se.refresh(aut);
		System.out.printf("");
		
	}catch(Exception ex){
		ex.printStackTrace();
		
	}
}
	public static void borrarPrestamo() {
		Transaction t = null;

		try (Session se = Conexion.obtenerSesion()) {
			t = se.beginTransaction();
			//(int idPrestamo, Ejemplar ejemplarByIdEjemplar, Ejemplar ejemplarByIdUsuario, Date fechaPrestamo,Date fechaDevolucion)
			Prestamo aut=new Prestamo();
			aut.setIdPrestamo(1);
			aut.setEjemplarByIdEjemplar(Ejemplar);
			aut.setEjemplarByIdUsuario(Usuario);
			SimpleDateFormat s= new SimpleDateFormat ("dd-MM-yyy");
			aut.setFechaPrestamo(s.parse("10-10-2000"));
			aut.setFechaDevolucion(s.parse("10-10-2000"));			
			se.delete(aut);
			t.commit();
			System.out.print("El Usuario ha sido borrado");
		} catch (Exception ex) {
			ex.printStackTrace();
			
		}

	}
	public static void modificarPrestamo() {
		Transaction t = null;
		try (Session se = Conexion.obtenerSesion()) {
			t = se.beginTransaction();
			//(int idPrestamo, Ejemplar ejemplarByIdEjemplar, Ejemplar ejemplarByIdUsuario, Date fechaPrestamo,Date fechaDevolucion)
			Prestamo aut=new Prestamo();
			aut.setIdPrestamo(1);
			aut.setEjemplarByIdEjemplar(Ejemplar);
			aut.setEjemplarByIdUsuario(Usuario);
			SimpleDateFormat s= new SimpleDateFormat ("dd-MM-yyy");
			aut.setFechaPrestamo(s.parse("10-10-2000"));
			aut.setFechaDevolucion(s.parse("10-10-2000"));
			se.saveOrUpdate(aut);
			se.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			
		}

	}
	public static void obtenerUsuarioPorId() {
		
    }


}
