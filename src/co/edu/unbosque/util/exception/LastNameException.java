package co.edu.unbosque.util.exception;

public class LastNameException extends Exception{
	
	public LastNameException() {
		super("Apellido invalido: minimo 5 letras, no numeros, simbolos o espacios al inicio o al final");
	}

}
