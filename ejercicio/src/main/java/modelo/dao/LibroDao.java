package modelo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.configuracion.Conexion;
import modelo.entidades.Libro;

public class LibroDao {

	public static void crearLibro() {
		Transaction t = null;

		try (Session se = Conexion.obtenerSesion()) {
			t = se.beginTransaction();
			// Libro(String codLibro, String titulo, String editorial, float precio, Set
			// ejemplars)
			Libro aut = new Libro();
			aut.setCodLibro("codigo");
			aut.setTitulo("titulo");
			aut.setEditorial("editorial");
			aut.setPrecio((float) 3.3);
			se.save(aut);
			t.commit();
			se.refresh(aut);
			System.out.printf("Insertado el Libro con el Codigo: " + aut.getCodLibro() + " Titulo: " + aut.getTitulo()
					+ " Editorial: " + aut.getEditorial() + " Precio: " + aut.getPrecio());

		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}

	public static void borrarLibro() {
		Transaction t = null;

		try (Session se = Conexion.obtenerSesion()) {
			t = se.beginTransaction();
			// Libro(String codLibro, String titulo, String editorial, float precio, Set
			// ejemplars)
			Libro aut = new Libro();
			aut.setCodLibro("codigo");
			aut.setTitulo("titulo");
			aut.setEditorial("editorial");
			aut.setPrecio((float) 3.3);
			se.delete(aut);
			t.commit();
			System.out.print("El Libro ha sido borrado");
		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	public static void modificarLibro() {
		Transaction t = null;
		try (Session se = Conexion.obtenerSesion()) {
			t = se.beginTransaction();
			// Libro(String codLibro, String titulo, String editorial, float precio, Set
			// ejemplars)
			Libro aut = new Libro();
			aut.setCodLibro("codigo1");
			aut.setTitulo("titulo1");
			aut.setEditorial("editorial1");
			aut.setPrecio((float) 3.2);
			se.saveOrUpdate(aut);
			se.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	public static void LibrpsPrestadosFecha() {
	}

	public static void LibrpsNombreAutor() {
	}

	public static void LibrosPorPrecio() {
	}

}
