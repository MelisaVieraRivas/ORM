package vista.pantallas;

import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.configuracion.Conexion;

import modelo.entidades.Autor;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Transaction t =null;
		
		try(Session se= Conexion.obtenerSesion()) {
			t=se.beginTransaction();
			
			Autor aut =new  Autor (9, "Ma", "Viera");
			se.save(aut);
			
			t.commit();
			
			se.refresh(aut);
			System.out.printf("Id Autor: "+aut.getIdAutor()+"Nombre Autor: "+aut.getNombre()+"Apellido Autor: "+aut.getApellidos());
			
		}catch(Exception ex){
			ex.printStackTrace();
			if(t!=null)
				t.rollback();
			
		}
	}
}