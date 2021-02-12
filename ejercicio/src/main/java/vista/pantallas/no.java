package vista.pantallas;
import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.configuracion.Conexion;
import modelo.dao.LibroDao;
import modelo.entidades.Autor;
import modelo.entidades.Usuario;


public class no {

	public static void main(String[] args) {Transaction t =null;
	
	try(Session se= Conexion.obtenerSesion()) {
		t=se.beginTransaction();		
		//Usuario(IdUsuario, nombre, apellidos, Fecha nacimiento)
		Usuario aut =new  Usuario ();
		aut.setIdUsuario(1);
		aut.setNombre("Melisa");
		aut.setApellidos("Viera");
		SimpleDateFormat s= new SimpleDateFormat ("dd-MM-yyy");
		aut.setFechaNacimiento(s.parse("10-10-2000"));
		se.save(aut);		
		t.commit();		
		se.refresh(aut);
		System.out.printf("Insertado el usuario con el Id: "+aut.getIdUsuario()+"  Nombre: "+aut.getNombre()+"  Apellidos:  "+aut.getApellidos()+"  Fecha de nacimiento:   "+aut.getFechaNacimiento());
		
	}catch(Exception ex){
		ex.printStackTrace();
		
	}
}}