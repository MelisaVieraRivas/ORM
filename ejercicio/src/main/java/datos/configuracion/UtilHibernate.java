package datos.configuracion;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UtilHibernate {

private static final SessionFactory sessionFactory;

static {
try {
// Crea la sesion desde el archivo de (hibernate.cfg.xml)

sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
} catch (Throwable ex) {

System.err.println("Initial SessionFactory creation failed." + ex);
throw new ExceptionInInitializerError(ex);
}
}

public static SessionFactory getSessionFactory() {
return sessionFactory;
}
}