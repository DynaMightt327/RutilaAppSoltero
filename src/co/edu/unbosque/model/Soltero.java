package co.edu.unbosque.model;

import java.io.Serializable;

public class Soltero extends Persona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3722005877406016054L;

	public Soltero() {
		// TODO Auto-generated constructor stub
	}

	public Soltero(String nombre, String apellido, String fechaNacimiento, String genero, long numeroDocumento,
			String universidad, String progAcademico, String rutaFotoPerfil) {
		super(nombre, apellido, fechaNacimiento, genero, numeroDocumento, universidad, progAcademico, rutaFotoPerfil);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return super.toString();
	}

	
}
