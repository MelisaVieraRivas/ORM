package datos.configuracion;

import org.hibernate.Session;

public class Conexion {
	

	public static Session obtenerSesion() {
		// TODO Auto-generated method stub
		return UtilHibernate.getSessionFactory().openSession();
	}

}
