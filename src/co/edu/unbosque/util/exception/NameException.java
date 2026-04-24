package co.edu.unbosque.util.exception;

public class NameException extends Exception{
	
	public NameException() {
		super("Nombre invalido: minimo 5 letras, no numeros, simbolos o espacios al inicio o al final");
	}

}
