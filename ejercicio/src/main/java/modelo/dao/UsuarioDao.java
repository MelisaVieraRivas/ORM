package modelo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.configuracion.Conexion;
import modelo.entidades.Usuario;

public class UsuarioDao {
	
	public void guardarUsuario() {
	Transaction t =null;
	
	try(Session se= Conexion.obtenerSesion()) {
		t=se.beginTransaction();
		
		
		//Usuario(IdUsuario, nombre, apellidos, Fecha nacimiento)
		Usuario aut =new  Usuario (5, "Melisa", "Viera", null);
		se.save(aut);
		
		t.commit();
		
		se.refresh(aut);
		System.out.printf("Id Usuario: "+aut.getIdUsuario()+"  Nombre: "+aut.getNombre()+"  Apellidos:  "+aut.getApellidos()+" Fecha de nacimiento:   "+aut.getFechaNacimiento());
		
	}catch(Exception ex){
		ex.printStackTrace();
		if(t!=null)
			t.rollback();
		
	}
	
}

public void borrarUsuario() {
	
}


}
