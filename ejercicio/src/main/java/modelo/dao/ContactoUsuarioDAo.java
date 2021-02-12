package modelo.dao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.configuracion.Conexion;
import modelo.entidades.ContactousuarioId;


public class ContactoUsuarioDAo {

	public static void crearContactoUsuario() {
		Transaction t = null;

		try (Session se = Conexion.obtenerSesion()) {
			t = se.beginTransaction();
			// ContactousuarioId(int idUsuario, String email, String telefonoMovil, String
			// telefonoFijo)
			ContactousuarioId aut = new ContactousuarioId();
			aut.setIdUsuario(1);
			aut.setEmail("melisaviera@hotmail.com");
			aut.setTelefonoMovil("625148457");
			aut.setTelefonoFijo("635152458");
			se.save(aut);
			t.commit();
			se.refresh(aut);
			System.out.printf("Insertado el Contactousuario con el Id: " + aut.getIdUsuario() + "  Email: "
					+ aut.getEmail() + "  Movil:  " + aut.getTelefonoMovil() + "  Fijo:   " + aut.getTelefonoFijo());
		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}

	public static void borrarContactoUsuario() {
		Transaction t = null;
		try (Session se = Conexion.obtenerSesion()) {
			t = se.beginTransaction();
			// ContactousuarioId(int idUsuario, String email, String telefonoMovil, String
			// telefonoFijo)
			ContactousuarioId aut = new ContactousuarioId();
			aut.setIdUsuario(1);
			aut.setEmail("melisaviera@hotmail.com");
			aut.setTelefonoMovil("625148457");
			aut.setTelefonoFijo("635152458");
			se.delete(aut);
			t.commit();
			System.out.print("El Usuario ha sido borrado");
		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	public static void modificarContactoUsuario() {
		Transaction t = null;
		try (Session se = Conexion.obtenerSesion()) {
			t = se.beginTransaction();
			// ContactousuarioId(int idUsuario, String email, String telefonoMovil, String
			// telefonoFijo)
			ContactousuarioId aut = new ContactousuarioId();
			aut.setIdUsuario(1);
			aut.setEmail("melisaviera@hotmail.com");
			aut.setTelefonoMovil("625148457");
			aut.setTelefonoFijo("635152458");
			se.saveOrUpdate(aut);
			se.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	public static void obtenerUsuarioPorId() {

	}

}
