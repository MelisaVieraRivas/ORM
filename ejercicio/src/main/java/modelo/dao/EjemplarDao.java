package modelo.dao;

import java.text.SimpleDateFormat;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.configuracion.Conexion;
import modelo.entidades.Ejemplar;
import modelo.entidades.Libro;
import modelo.entidades.Prestamo;

public class EjemplarDao {
	
	public static void crearEjemplar(int idEjemplar, Libro libro, int numEjemplar, String estado) {
		Transaction t =null;
		
		try(Session se= Conexion.obtenerSesion()) {
			t=se.beginTransaction();		
			//Ejemplar(int idEjemplar, Libro libro, int numEjemplar, String estado)
			Ejemplar aut=new Ejemplar();
			aut.setIdEjemplar(idEjemplar);			
			aut.setLibro(libro);
			aut.setNumEjemplar(numEjemplar);
			aut.setEstado(estado);			
			se.save(aut);		
			t.commit();		
			se.refresh(aut);
			System.out.printf(" ");
			
		}catch(Exception ex){
			ex.printStackTrace();
			
		}
	}
		public static void borrarEjemplar(int idEjemplar, Libro libro, int numEjemplar, String estado) {
			Transaction t = null;

			try (Session se = Conexion.obtenerSesion()) {
				t = se.beginTransaction();
				//Ejemplar(int idEjemplar, Libro libro, int numEjemplar, String estado)
				Ejemplar aut=new Ejemplar();
				aut.setIdEjemplar(idEjemplar);			
				aut.setLibro(libro);
				aut.setNumEjemplar(numEjemplar);
				aut.setEstado(estado);		
				se.delete(aut);
				t.commit();
				System.out.print("El Usuario ha sido borrado");
			} catch (Exception ex) {
				ex.printStackTrace();
				
			}

		}
		public static void modificarEjemplar(int idEjemplar, Libro libro, int numEjemplar, String estado) {
			Transaction t = null;
			try (Session se = Conexion.obtenerSesion()) {
				t = se.beginTransaction();
				//Ejemplar(int idEjemplar, Libro libro, int numEjemplar, String estado)
				Ejemplar aut=new Ejemplar();
				aut.setIdEjemplar(idEjemplar);			
				aut.setLibro(libro);
				aut.setNumEjemplar(numEjemplar);
				aut.setEstado(estado);				
				se.saveOrUpdate(aut);
				se.getTransaction().commit();
			} catch (Exception ex) {
				ex.printStackTrace();
				
			}

		}
		public static void obtenerUsuarioPorId() {
			
	    }


	}

