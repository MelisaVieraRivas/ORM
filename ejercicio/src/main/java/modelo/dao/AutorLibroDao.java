package modelo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.configuracion.Conexion;
import modelo.entidades.AutorlibroId;


public class AutorLibroDao {
	

		public static void crearAutorLibro() {
			Transaction t = null;

			try (Session se = Conexion.obtenerSesion()) {
				t = se.beginTransaction();
				//AutorlibroId(int idAutor, String codLibro)
				AutorlibroId aut= new AutorlibroId();
				aut.setIdAutor(1);
				aut.setCodLibro("codigol");
				se.save(aut);
				t.commit();
				se.refresh(aut);
				System.out.printf("Insertado el AutorLibro con Id: " + aut.getIdAutor() + "  Codigo: "
						+ aut.getCodLibro());
			} catch (Exception ex) {
				ex.printStackTrace();

			}
		}

		public static void borrarAutorLibro() {
			Transaction t = null;
			try (Session se = Conexion.obtenerSesion()) {
				t = se.beginTransaction();
				//AutorlibroId(int idAutor, String codLibro)
				AutorlibroId aut= new AutorlibroId();
				aut.setIdAutor(1);
				aut.setCodLibro("codigol");
				se.delete(aut);
				t.commit();
				System.out.print("El Usuario ha sido borrado");
			} catch (Exception ex) {
				ex.printStackTrace();

			}

		}

		public static void modificarAutorLibro() {
			Transaction t = null;
			try (Session se = Conexion.obtenerSesion()) {
				t = se.beginTransaction();
				//AutorlibroId(int idAutor, String codLibro)
				AutorlibroId aut= new AutorlibroId();
				aut.setIdAutor(1);
				aut.setCodLibro("codigol");				
				se.saveOrUpdate(aut);
				se.getTransaction().commit();
			} catch (Exception ex) {
				ex.printStackTrace();

			}

		}

		public static void obtenerUsuarioPorId() {

		}

	}

