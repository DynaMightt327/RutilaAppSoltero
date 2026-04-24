package co.edu.unbosque.util.exception;

public class UniversityException extends Exception {

	public UniversityException() {
		super("Nombre de universidad inválido: minimo 5 letras, no numeros, simbolos o espacios al inicio o al final");
	}

}
