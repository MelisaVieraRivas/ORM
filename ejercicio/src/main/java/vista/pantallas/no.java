package vista.pantallas;

import org.hibernate.Transaction;

import modelo.dao.AutorDao;
import modelo.dao.AutorLibroDao;
import modelo.dao.ContactoUsuarioDAo;
import modelo.dao.LibroDao;
import modelo.dao.UsuarioDao;



public class no {

	public static void main(String[] args) {
	LibroDao.crearLibro();
	UsuarioDao.crearUsuario();
	ContactoUsuarioDAo.crearContactoUsuario();
	AutorDao.crearAutor();
	AutorLibroDao.crearAutorLibro();
	
}}