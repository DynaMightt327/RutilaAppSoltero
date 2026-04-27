package co.edu.unbosque.model;

import java.io.Serializable;

public class Pareja extends Persona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6041008573647296264L;
	private String apellidoPareja;
	private String nombrePareja;
	private String generoPareja;
	private String fechaNacimientoPareja;
	private String universidadPareja;
	private long numeroDocumentoPareja;
	private String rutafotoPerfilPareja;
	private String progAcademicoPareja;

	public Pareja() {
		// TODO Auto-generated constructor stub
	}

	public Pareja(String apellidoPareja, String nombrePareja, String generoPareja, String fechaNacimientoPareja,
			String universidadPareja, long numeroDocumentoPareja, String rutafotoPerfilPareja,
			String progAcademicoPareja) {
		super();
		this.apellidoPareja = apellidoPareja;
		this.nombrePareja = nombrePareja;
		this.generoPareja = generoPareja;
		this.fechaNacimientoPareja = fechaNacimientoPareja;
		this.universidadPareja = universidadPareja;
		this.numeroDocumentoPareja = numeroDocumentoPareja;
		this.rutafotoPerfilPareja = rutafotoPerfilPareja;
		this.progAcademicoPareja = progAcademicoPareja;
	}

	public Pareja(String nombre, String apellido, String fechaNacimiento, String genero, long numeroDocumento,
			String universidad, String progAcademico, String rutaFotoPerfil, String apellidoPareja, String nombrePareja,
			String generoPareja, String fechaNacimientoPareja, String universidadPareja, long numeroDocumentoPareja,
			String rutafotoPerfilPareja, String progAcademicoPareja) {
		super(nombre, apellido, fechaNacimiento, genero, numeroDocumento, universidad, progAcademico, rutaFotoPerfil);
		this.apellidoPareja = apellidoPareja;
		this.nombrePareja = nombrePareja;
		this.generoPareja = generoPareja;
		this.fechaNacimientoPareja = fechaNacimientoPareja;
		this.universidadPareja = universidadPareja;
		this.numeroDocumentoPareja = numeroDocumentoPareja;
		this.rutafotoPerfilPareja = rutafotoPerfilPareja;
		this.progAcademicoPareja = progAcademicoPareja;
	}

	public Pareja(String nombre, String apellido, String fechaNacimiento, String genero, long numeroDocumento,
			String universidad, String progAcademico, String rutaFotoPerfil) {
		super(nombre, apellido, fechaNacimiento, genero, numeroDocumento, universidad, progAcademico, rutaFotoPerfil);
		// TODO Auto-generated constructor stub
	}

	public String getApellidoPareja() {
		return apellidoPareja;
	}

	public void setApellidoPareja(String apellidoPareja) {
		this.apellidoPareja = apellidoPareja;
	}

	public String getNombrePareja() {
		return nombrePareja;
	}

	public void setNombrePareja(String nombrePareja) {
		this.nombrePareja = nombrePareja;
	}

	public String getGeneroPareja() {
		return generoPareja;
	}

	public void setGeneroPareja(String generoPareja) {
		this.generoPareja = generoPareja;
	}

	public String getFechaNacimientoPareja() {
		return fechaNacimientoPareja;
	}

	public void setFechaNacimientoPareja(String fechaNacimientoPareja) {
		this.fechaNacimientoPareja = fechaNacimientoPareja;
	}

	public String getUniversidadPareja() {
		return universidadPareja;
	}

	public void setUniversidadPareja(String universidadPareja) {
		this.universidadPareja = universidadPareja;
	}

	public long getNumeroDocumentoPareja() {
		return numeroDocumentoPareja;
	}

	public void setNumeroDocumentoPareja(long numeroDocumentoPareja) {
		this.numeroDocumentoPareja = numeroDocumentoPareja;
	}

	public String getRutafotoPerfilPareja() {
		return rutafotoPerfilPareja;
	}

	public void setRutafotoPerfilPareja(String rutafotoPerfilPareja) {
		this.rutafotoPerfilPareja = rutafotoPerfilPareja;
	}

	public String getProgAcademicoPareja() {
		return progAcademicoPareja;
	}

	public void setProgAcademicoPareja(String progAcademicoPareja) {
		this.progAcademicoPareja = progAcademicoPareja;
	}

	@Override
	public String toString() {
		return super.toString() + nombrePareja + ";" + apellidoPareja + ";" + fechaNacimientoPareja + ";" + generoPareja + ";"
				+ numeroDocumentoPareja + ";" + universidadPareja + ";" + progAcademicoPareja
				+ ";" + rutafotoPerfilPareja ;
	}
}
