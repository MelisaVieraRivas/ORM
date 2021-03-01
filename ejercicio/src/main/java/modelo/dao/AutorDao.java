package modelo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.configuracion.Conexion;
import modelo.entidades.Autor;


public class AutorDao {

	public static void crearAutor(int idAutor, String nombre, String apellidos) {
		Transaction t = null;

		try (Session se = Conexion.obtenerSesion()) {
			t = se.beginTransaction();
			//Autor(int idAutor, String nombre, String apellidos)
			Autor aut=new Autor();
			aut.setIdAutor(idAutor);
			aut.setNombre(nombre);
			aut.setApellidos(apellidos);			
			se.save(aut);
			t.commit();
			se.refresh(aut);
			System.out.printf("Insertado el Autor con el Id: " + aut.getIdAutor() + "  Nombre: "
					+ aut.getNombre() + "  Apellidos:  " + aut.getApellidos());
		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}

	public static void borrarAutor(int idAutor, String nombre, String apellidos) {
		Transaction t = null;
		try (Session se = Conexion.obtenerSesion()) {
			t = se.beginTransaction();
			//Autor(int idAutor, String nombre, String apellidos)
			Autor aut=new Autor();
			aut.setIdAutor(idAutor);
			aut.setNombre(nombre);
			aut.setApellidos(apellidos);
			se.delete(aut);
			t.commit();
			System.out.print("El Usuario ha sido borrado");
		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	public static void modificarAutor(int idAutor, String nombre, String apellidos) {
		Transaction t = null;
		try (Session se = Conexion.obtenerSesion()) {
			t = se.beginTransaction();//Autor(int idAutor, String nombre, String apellidos)
			Autor aut=new Autor();
			aut.setIdAutor(idAutor);
			aut.setNombre(nombre);
			aut.setApellidos(apellidos);	
			se.saveOrUpdate(aut);
			se.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	public static void obtenerUsuarioPorId() {

	}

}

