package modelo.dao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.configuracion.Conexion;
import modelo.entidades.ContactousuarioId;


public class ContactoUsuarioDAo {

	public static void crearContactoUsuario(int idUsuario, String email, String telefonoMovil, String telefonoFijo) {
		Transaction t = null;

		try (Session se = Conexion.obtenerSesion()) {
			t = se.beginTransaction();
			// ContactousuarioId(int idUsuario, String email, String telefonoMovil, String
			// telefonoFijo)
			ContactousuarioId aut = new ContactousuarioId();
			aut.setIdUsuario(idUsuario);
			aut.setEmail(email);
			aut.setTelefonoMovil(telefonoMovil);
			aut.setTelefonoFijo(telefonoFijo);
			se.save(aut);
			t.commit();
			se.refresh(aut);
			System.out.printf("Insertado el Contactousuario con el Id: " + aut.getIdUsuario() + "  Email: "
					+ aut.getEmail() + "  Movil:  " + aut.getTelefonoMovil() + "  Fijo:   " + aut.getTelefonoFijo());
		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}

	public static void borrarContactoUsuario(int idUsuario, String email, String telefonoMovil, String telefonoFijo) {
		Transaction t = null;
		try (Session se = Conexion.obtenerSesion()) {
			t = se.beginTransaction();
			// ContactousuarioId(int idUsuario, String email, String telefonoMovil, String
			// telefonoFijo)
			ContactousuarioId aut = new ContactousuarioId();
			aut.setIdUsuario(idUsuario);
			aut.setEmail(email);
			aut.setTelefonoMovil(telefonoMovil);
			aut.setTelefonoFijo(telefonoFijo);
			se.delete(aut);
			t.commit();
			System.out.print("El Usuario ha sido borrado");
		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	public static void modificarContactoUsuario(int idUsuario, String email, String telefonoMovil, String telefonoFijo) {
		Transaction t = null;
		try (Session se = Conexion.obtenerSesion()) {
			t = se.beginTransaction();
			// ContactousuarioId(int idUsuario, String email, String telefonoMovil, String
			// telefonoFijo)
			ContactousuarioId aut = new ContactousuarioId();
			aut.setIdUsuario(idUsuario);
			aut.setEmail(email);
			aut.setTelefonoMovil(telefonoMovil);
			aut.setTelefonoFijo(telefonoFijo);
			se.saveOrUpdate(aut);
			se.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	public static void obtenerUsuarioPorId() {

	}

}
