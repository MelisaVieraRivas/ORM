package modelo.dao;

import org.hibernate.Transaction;

import datos.configuracion.Conexion;
import modelo.entidades.Autor;

import org.hibernate.Session;


public class AutorDao {
	
	public void guardarAutor() {
		Transaction t =null;
		
		try(Session se= Conexion.obtenerSesion()) {
			t=se.beginTransaction();
			
			Autor aut =new  Autor (5, "Ma", "Viera");
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
	public void borrarAutor() {
		
	}
	
	}