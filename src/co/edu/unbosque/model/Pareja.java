package co.edu.unbosque.model;

import java.io.Serializable;

public class Pareja extends Persona implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6041008573647296264L;
	
	public Pareja() {
		// TODO Auto-generated constructor stub
	}

	public Pareja(String nombre, String apellido, String fechaNacimiento, String genero, long numeroDocumento,
			String universidad, String progAcademico, String rutaFotoPerfil) {
		super(nombre, apellido, fechaNacimiento, genero, numeroDocumento, universidad, progAcademico, rutaFotoPerfil);
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	

}
