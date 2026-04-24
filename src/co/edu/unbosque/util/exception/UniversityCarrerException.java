package co.edu.unbosque.util.exception;

public class UniversityCarrerException extends Exception{
	
	public UniversityCarrerException() {
		super("Carrera universitaria no válida: No puede contener números ni símbolos. Solo se cuentan letras.");
	}

}
