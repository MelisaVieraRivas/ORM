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
		
		Usuario aut =new  Usuario (5, "Melisa", "Viera", "1200-20-00");
		se.save(aut);
		
		t.commit();
		
		se.refresh(aut);
		System.out.printf("Id Autor: "+aut.getIdAutor()+"Codigo Libro: "+aut.getCodLibro());
		
	}catch(Exception ex){
		ex.printStackTrace();
		if(t!=null)
			t.rollback();
		
	}
	
}

public void borrarAutorLibro() {
	
}


}
