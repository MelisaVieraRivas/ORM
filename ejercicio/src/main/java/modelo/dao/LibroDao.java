package modelo.dao;



import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.configuracion.Conexion;
import modelo.entidades.Libro;

public class LibroDao {

	public static void crearLibro(String codLibro, String titulo, String editorial, float precio) {
		Transaction t = null;

		try (Session se = Conexion.obtenerSesion()) {
			t = se.beginTransaction();
			// Libro(String codLibro, String titulo, String editorial, float precio, Set
			 //ejemplars)
			Libro aut = new Libro();
			aut.setCodLibro(codLibro);
			aut.setTitulo(titulo);
			aut.setEditorial(editorial);
			aut.setPrecio((float) precio);
			se.save(aut);
			t.commit();
			se.refresh(aut);
			System.out.printf("Insertado el Libro con el Codigo: " + aut.getCodLibro() + " Titulo: " + aut.getTitulo()
					+ " Editorial: " + aut.getEditorial() + " Precio: " + aut.getPrecio());

		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}

	public static void borrarLibro(String codLibro, String titulo, String editorial, float precio) {
		Transaction t = null;

		try (Session se = Conexion.obtenerSesion()) {
			t = se.beginTransaction();
			// Libro(String codLibro, String titulo, String editorial, float precio, Set
			// ejemplars)
			Libro aut = new Libro();
			aut.setCodLibro(codLibro);
			aut.setTitulo(titulo);
			aut.setEditorial(editorial);
			aut.setPrecio((float) precio);
			se.delete(aut);
			t.commit();
			System.out.print("El Libro ha sido borrado");
		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	public static void modificarLibro(String codLibro, String titulo, String editorial, float precio) {
		Transaction t = null;
		try (Session se = Conexion.obtenerSesion()) {
			t = se.beginTransaction();
			// Libro(String codLibro, String titulo, String editorial, float precio, Set
			// ejemplars)
			Libro aut = new Libro();
			aut.setCodLibro(codLibro);
			aut.setTitulo(titulo);
			aut.setEditorial(editorial);
			aut.setPrecio((float) precio);
			se.saveOrUpdate(aut);
			se.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}
	public static void LibrosPorId() {
	}

	public static void LibrosPrestadosFecha() {
	}

	public static void LibrosNombreAutor() {
	}

	public static void LibrosPorPrecio() {
	}

}
