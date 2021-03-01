package modelo.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.configuracion.Conexion;
import datos.dao.IDao;
import modelo.entidades.Usuario;

public class UsuarioDao {

	public static void crearUsuario(int idUsuario, String nombre, String apellidos, Date fechaNacimiento) {
		Transaction t = null;

		try (Session se = Conexion.obtenerSesion()) {
			t = se.beginTransaction();
			//(int idUsuario, String nombre, String apellidos, Date fechaNacimiento)
			Usuario aut = new Usuario();
			aut.setIdUsuario(idUsuario);
			aut.setNombre(nombre);
			aut.setApellidos(apellidos);
			aut.setFechaNacimiento(fechaNacimiento);
			se.save(aut);
			t.commit();
			se.refresh(aut);
			System.out.printf("Insertado el usuario con el Id: " + aut.getIdUsuario() + "  Nombre: " + aut.getNombre()
					+ "  Apellidos:  " + aut.getApellidos() + "  Fecha de nacimiento:   " + aut.getFechaNacimiento());

		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}

	public static void borrarUsuario(int idUsuario, String nombre, String apellidos, Date fechaNacimiento)  {
		Transaction t = null;

		try (Session se = Conexion.obtenerSesion()) {
			t = se.beginTransaction();
			// Usuario(IdUsuario, nombre, apellidos, Fecha nacimiento)
			Usuario aut = new Usuario();
			aut.setIdUsuario(idUsuario);
			aut.setNombre(nombre);
			aut.setApellidos(apellidos);
			aut.setFechaNacimiento(fechaNacimiento);
			se.delete(aut);
			t.commit();
			System.out.print("El Usuario ha sido borrado");
		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	public static void modificarUsuario(int idUsuario, String nombre, String apellidos, Date fechaNacimiento)  {
		Transaction t = null;
		try (Session se = Conexion.obtenerSesion()) {
			t = se.beginTransaction();
			Usuario aut = new Usuario();
			aut.setIdUsuario(idUsuario);
			aut.setNombre(nombre);
			aut.setApellidos(apellidos);
			aut.setFechaNacimiento(fechaNacimiento);
			//SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyy");
			//aut.setFechaNacimiento(s.parse("10-10-2000"));
			se.saveOrUpdate(aut);
			se.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	public static void obtenerUsuarioPorId() {

	}

	public static void obtenerUsuarioPrestamo() {

	}

	public static void obtenerUsuarioMenoresEdad() {

	}

}
