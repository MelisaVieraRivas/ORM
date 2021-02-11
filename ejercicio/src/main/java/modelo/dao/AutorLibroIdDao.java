package modelo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.configuracion.Conexion;
import modelo.entidades.AutorlibroId;

public class AutorLibroIdDao {
	
	public void guardarAutorLibro() {
		Transaction t =null;
		
		try(Session se= Conexion.obtenerSesion()) {
			t=se.beginTransaction();
			
			AutorlibroId aut =new  AutorlibroId (5, "Ma");
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
