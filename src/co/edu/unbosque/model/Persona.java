package co.edu.unbosque.model;

import java.io.Serializable;

public abstract class Persona implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6925091886570098130L;
	private String nombre;
	private String apellido;
	private String fechaNacimiento;
	private String genero;
	private long numeroDocumento;
	private String universidad;
	private String progAcademico;
	private String rutaFotoPerfil;
	
	public Persona() {
	}

	public Persona(String nombre, String apellido, String fechaNacimiento, String genero, long numeroDocumento,
			String universidad, String progAcademico, String rutaFotoPerfil) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
		this.numeroDocumento = numeroDocumento;
		this.universidad = universidad;
		this.progAcademico = progAcademico;
		this.rutaFotoPerfil = rutaFotoPerfil;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public double getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(long numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getUniversidad() {
		return universidad;
	}

	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}

	public String getProgAcademico() {
		return progAcademico;
	}

	public void setProgAcademico(String progAcademico) {
		this.progAcademico = progAcademico;
	}

	public String getRutaFotoPerfil() {
		return rutaFotoPerfil;
	}

	public void setRutaFotoPerfil(String rutaFotoPerfil) {
		rutaFotoPerfil = rutaFotoPerfil;
	}

	@Override
	public String toString() {
		return nombre + ";" + apellido + ";" + fechaNacimiento + ";" + genero + ";" 
		         + numeroDocumento + ";" + universidad + ";" + progAcademico + ";" + rutaFotoPerfil + "\n";
	}

}
