package modelo.dao;

import org.hibernate.Transaction;
import org.hibernate.mapping.List;
import org.hibernate.query.QueryProducer;

import com.mysql.cj.Query;
import com.mysql.cj.result.Field;

import datos.configuracion.Conexion;
import modelo.entidades.Autor;

import javax.persistence.Column;

import org.hibernate.Session;

public class AutorDao {

	public static void crearAutor() {
		Transaction t = null;

		try (Session se = Conexion.obtenerSesion()) {
			t = se.beginTransaction();

			// Autor(IdAutor, nombre, apellidos)
			Autor aut = new Autor(5, "Melisa", "Viera");
			se.save(aut);
			t.commit();
			se.refresh(aut);
			System.out.printf("Id Autor: " + aut.getIdAutor() + "  Nombre Autor: " + aut.getNombre()
					+ "  Apellido Autor: " + aut.getApellidos());

		} catch (Exception ex) {
			ex.printStackTrace();
			if (t != null)
				t.rollback();
		}

	}

	public static void borrarAutor() {
		Transaction t = null;

		try (Session se = Conexion.obtenerSesion()) {
			t = se.beginTransaction();
			Autor aut = new Autor(5, "Melisa", "Viera");
			se.delete(aut);
			t.commit();
			System.out.print("El Autor ha sido borrado");
		} catch (Exception ex) {
			ex.printStackTrace();
			if (t != null)
				t.rollback();
		}

	}



	public static void modificarAutor() {
		Transaction t = null;
		try (Session se = Conexion.obtenerSesion()) {
			t = se.beginTransaction();
			Autor aut = new Autor(101, "Juan", "Perez");
			se.saveOrUpdate(aut);
			se.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (t != null)
				t.rollback();
		}

	}

}
